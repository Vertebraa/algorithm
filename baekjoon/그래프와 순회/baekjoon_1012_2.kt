import java.util.*

/**
 * https://www.acmicpc.net/problem/1012
 * 그래프와 순회 문제 유기농 배추
 * M*N 사이즈의 밭이 있다. 밭에 배추가 심어져 있으면 1 그렇지 않으면 0 으로 표기한다 (작물의 위치는 좌표로 입력받음)
 * 배추흰지렁이 한마리는 연결된 배추의 해충은 잡아 먹지만 연결되어 있지 않은 배추의 해충은 잡을 수 없다
 * 입력받은 크기의 밭에 연결되어 있는 배추들을 해충으로부터 지키려면 총 몇마리의 지렁이가 필요한지 구하는 문제
 * BFS 탐색방법으로 풀이
 */

fun main() = Scanner(System.`in`).use { sc ->
    val testCase = sc.nextInt()

    for (i in 0 until testCase) {
        val horizontalSize = sc.nextInt()
        val verticalSize = sc.nextInt()
        val crops = sc.nextInt()
        val field = Array(horizontalSize) {
            Array(verticalSize) {
                Field(0, mutableListOf())
            }
        }

        repeat(crops) {
            val coordinateX = sc.nextInt()
            val coordinateY = sc.nextInt()
            field[coordinateX][coordinateY].planted = 1
        }

        for (x in 0 until horizontalSize) {
            for (y in 0 until verticalSize) {
                val current = field[x][y]
                if (current.planted != 1) { // 현재 배추가 심어져 있지 않으면 continue
                    continue
                }

                val bottom = field[x].getOrNull(y + 1) // 아래 블럭([x][y + 1])을 get하거나 없으면 null 반환
                if (bottom?.planted == 1) { // 아래 블럭에 배추가 심어져 있으면
                    linkField(current, bottom) // 현재 블럭과 아래 블럭을 연결해줌
                }

                val right = field.getOrNull(x + 1)?.get(y) // 오른쪽 블럭([x + 1][y])을 get하거나 없으면 null 반환
                if (right?.planted == 1) { // 오른쪽 블럭에 배추가 심어져 있으면
                    linkField(current, right) // 현재 블럭과 오른쪽 블럭을 연결해줌
                }
            }
        }

        var groupNumber = 1 // 밭의 번호
        val queue: Queue<Field> = LinkedList()
        for (x in 0 until horizontalSize) {
            for (y in 0 until verticalSize) {
                if (field[x][y].planted == 1 && field[x][y].groupNumber == -1) { // 배추가 심어져 있고 밭의 번호가 메겨지지 않았다면
                    field[x][y].groupNumber = groupNumber // 위의 저장된 밭의 번호를 현재밭의 번호로 지정
                    queue.offer(field[x][y]) // Queue에 현재 밭을 넣어줌
                    while (queue.isNotEmpty()) { // Queue가 비어있지 않다면
                        val hold = queue.poll() // Queue에 들어있는 가장 앞 밭을 변수화
                        hold.linkedCrops.forEach { // Queue에 들어간 밭과 연결된 밭을 돌면서
                            if (it.groupNumber == -1) { // 밭의 번호가 메겨지지 않았다면
                                it.groupNumber = groupNumber // 위에 저장된 밭의 번호를 넣어줌
                                queue.offer(it) // 연결된 밭을 Queue에 넣어줌
                            }
                        }
                    }
                    groupNumber++ // 다음 연결된 블럭들의 밭 번호
                }
            }
        }
        println(groupNumber - 1)
    }
}

private fun linkField(field1: Field, field2: Field) { // 두 블럭을 연결하는 함수, 코드중복이 여러번 발생해서 만듬
    field1.linkedCrops.add(field2)
    field2.linkedCrops.add(field1)
}

data class Field(
    var planted: Int,
    val linkedCrops: MutableList<Field>,
) {
    var groupNumber = -1
}
