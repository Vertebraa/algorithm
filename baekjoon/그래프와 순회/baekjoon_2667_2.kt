import java.util.Scanner

/**
 * https://www.acmicpc.net/problem/2667
 * 그래프와 순회 문제 단지 번호 붙이기
 * N*N 사이즈의 0과 1로 이루어진 정사각형 모양의 지도가 있다
 * 1은 집이 있는곳 0은 공터이다 상하좌우 방향에 다른 집이 있다면 연결된 경우이고, 연결된 집들은 하나의 단지를 이룬다
 * 지도내에 각 연결된 집들을 단지로 묶고 총 단지의 갯수와 단지별 집의 수를 오름차순으로 출력하는 문제
 * DFS 방법으로 풀이함
 */

fun main() = Scanner(System.`in`).use { sc ->
    val n = sc.nextInt()
    val map = Array(n) { sc.next().toCharArray().map { Land(it, mutableListOf()) } } // n*n 사이즈의 집과 공터가 있는 지도

    for (y in 0 until n) {
        for (x in 0 until n) {
            if (x + 1 < n && map[y][x].type == '1' && map[y][x + 1].type == '1') { // 가로로 탐색하면서 붙어있는 집을 연결해줌
                map[y][x].linkedHouseList.add(map[y][x + 1])
                map[y][x + 1].linkedHouseList.add(map[y][x])
            }
            if (y + 1 < n && map[y][x].type == '1' && map[y + 1][x].type == '1') { // 세로로 탐색하면서 붙어있는 집을 연결해줌
                map[y + 1][x].linkedHouseList.add(map[y][x])
                map[y][x].linkedHouseList.add(map[y + 1][x])
            }
        }
    }
    var groupNumber = 1
    for (y in 0 until n) {
        for (x in 0 until n) {
            if (map[y][x].type == '1' && map[y][x].groupNumber == -1) { // 블럭에 집이 있고 단지 번호가 -1인 경우
                grouping(map[y][x], groupNumber) // 각 블럭을 돌면서 연결된 집끼리 위에 저장된 단지 번호를 지정해줌
                groupNumber++ // 다음 단지의 번호
            }
        }
    }


    val housesSize = mutableListOf<Int>() // 각 단지별 집의 수를 저장하기 위한 리스트
    for (i in 1 until groupNumber) { // 1번 단지 부터 마지막 단지번호 - 1 까지
        var count = 0
        for (y in 0 until n) {
            for (x in 0 until n) {
                if (map[y][x].groupNumber == i) { // 단지 번호가 공통된 집들을 탐색 할때 마다
                    count++ // 카운트++
                }
            }
        }
        housesSize.add(count) // 리스트에 단지 번호별 집의 수 add
    }
    housesSize.sort() // 오름차순 정렬
    println(housesSize.size) // 단지의 갯수 출력
    housesSize.forEach { println(it) } // 단지별 집의 수를 오름차순 정렬한 리스트 출력
}


private data class Land( // 각 토지블럭의 데이터를 data class로 묶어줌
    val type: Char, // 집인가, 공터인가
    val linkedHouseList: MutableList<Land> // 연결된 집의 정보
) {
    var groupNumber: Int = -1 // 단지번호, 지정되지 않았다면 -1
}


private fun grouping(land: Land, groupNumber: Int) {
    land.groupNumber = groupNumber // 각 블럭의 단지번호를 파라미터로 받은 단지번호로 지정해줌
    land.linkedHouseList.forEach { // 각 블럭에 있는 집에 연결된 집들을 순회하며
        if (it.groupNumber == -1) { // 연결된 집의 단지번호가 지정되지 않았다면
            grouping(it, groupNumber) // 재귀함수를 돌면서 각 집의 단지번호를 정해줌
        }
    }
}