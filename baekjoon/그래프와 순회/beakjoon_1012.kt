import java.util.Scanner

/**
 * https://www.acmicpc.net/problem/1012
 * 그래프와 순회 문제 유기농 배추
 * M*N 사이즈의 밭이 있다. 밭에 배추가 심어져 있으면 1 그렇지 않으면 0 으로 표기한다 (작물의 위치는 좌표로 입력받음)
 * 배추흰지렁이 한마리는 연결된 배추의 해충은 잡아 먹지만 연결되어 있지 않은 배추의 해충은 잡을 수 없다
 * 입력받은 크기의 밭에 연결되어 있는 배추들을 해충으로부터 지키려면 총 몇마리의 지렁이가 필요한지 구하는 문제
 * 모두 0으로 이루어진 M*N 크기의 밭을 만들고
 * 입력 받은 좌표에 배추를 심은 후에, 연결된 배추끼리 그룹으로 묶어서 그룹의 수를 출력해서 풀이함
 * DFS 탐색방법으로 풀이
 */

fun main() = Scanner(System.`in`).use { sc ->
    val testCase = sc.nextInt() // 테스트 케이스

    for (i in 0 until testCase) {
        val horizontal = sc.nextInt() // 가로 길이
        val vertical = sc.nextInt() // 세로 길이
        val plantedCount = sc.nextInt() // 심어진 배추의 갯수
        val field = Array(horizontal) { // 가로 길이 크기의 배열 안에
            Array(vertical) { // 세로 길이 크기의 배열을 넣어 2차원 배열을 만듬
                Field(0, mutableListOf())
            }
        }
        repeat(plantedCount) { // 심어진 배추의 수만큼
            val coordinateX = sc.nextInt() // 가로 좌표 (X)
            val coordinateY = sc.nextInt() // 세로 좌표 (Y)
            for (x in 0 until horizontal) {
                for (y in 0 until vertical) {
                    if (x == coordinateX && y == coordinateY) { // 입력 받은 좌표와 일치하는 곳에
                        field[x][y].planted = 1 // 배추를 심어줌
                    }
                }
            }
        }
        for (x in 0 until horizontal) {
            for (y in 0 until vertical) {
                if (y + 1 < vertical && field[x][y].planted == 1 && field[x][y + 1].planted == 1) { // 배추 아랫쪽에 배추가 있으면
                    field[x][y].linkedCrops.add(field[x][y + 1])
                    field[x][y + 1].linkedCrops.add(field[x][y])
                } // 두배추를 연결해줌
                if (x + 1 < horizontal && field[x][y].planted == 1 && field[x + 1][y].planted == 1) { // 배추 오른쪽에 배추가 있으면
                    field[x][y].linkedCrops.add(field[x + 1][y])
                    field[x + 1][y].linkedCrops.add(field[x][y])
                } // 두배추를 연결해줌
            }// 좌에서 우로 상에서 하로 탐색하므로 이어진 배추가 있다면 모두 연결됨
        }

        var grouped = 1 // 최초 그룹번호
        for (x in 0 until horizontal) {
            for (y in 0 until vertical) {
                if (field[x][y].planted == 1 && field[x][y].linked == -1) // 배추가 심어져있고 그룹화 되어있지 않다면
                    grouping(field[x][y], grouped++) // 연결된 배추끼리 그룹화 시켜주고 그룹번호를 1 올려줌

            }
        }
        println(grouped - 1)
    }
}


data class Field(
    var planted: Int, // 배추가 심어졌는지 여부 (아니면 0 맞으면 1)
    val linkedCrops: MutableList<Field> // 연결된 배추의 리스트
) {
    var linked = -1 // 그룹 여부
}

private fun grouping(field: Field, linked: Int) { // 입력받은 배추와 연결된 배추들, 그룹 여부를 파라미터로 받음
    field.linked = linked // 배추가 심어졌으면 그룹화
    field.linkedCrops.forEach { // 그룹화한 배추와 연결된 배추들도
        if (it.linked == -1) { // 그룹화가 되어있지 않다면
            grouping(it, linked) // 재귀함수를 돌면서 같은 그룹으로 만들어줌
        }
    }
}