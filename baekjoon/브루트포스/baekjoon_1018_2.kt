import java.util.Scanner

/**
 * https://www.acmicpc.net/problem/1018
 * 브루트포스 문제 체스판 다시 칠하기
 * n개의 줄에 m개의 B 혹은 W가 주어진다 8x8 사이즈의 체스판을 올바르게 만드는데
 * 필요한 최소 수정 횟수를 출력하는 문제
 * 흑백이 올바르게 배치된 체스판은 어느 위치에 등장하든 상관없음
 */

fun main() = Scanner(System.`in`).use { sc ->
    val verticalSize = sc.nextInt() // 세로로 몇줄
    val horizontalSize = sc.nextInt() // 가로로 몇줄줄    val chessBoard = Array(verticalSize) {sc.next().toCharArray()}

    var minCount = Int.MAX_VALUE
    for (i in 0 until verticalSize -7) { // 좌표 (x,0~7)
        for (j in 0 until horizontalSize - 7) { // 좌표 (0~7,y)
            arrayOf('W','B').forEach { currentColor -> // W부터 시작하는 경우와 B부터 시작하는 경우 둘 다 탐색
                var yColor = currentColor
                var count = 0
                for (y in i until i + 8) { // 세로로 8칸 반복
                    var xColor = yColor // 좌표 (x, y)의 색을 같게 해줘야함
                    for (x in j until j + 8) { // 가로로 8칸 반복
                        if (chessBoard[y][x] != currentColor) { // 색이 다른 경우 만큼 (= 수정해야 하는 횟수)
                            count++ // 카운트 ++
                        }
                        xColor = if (xColor == 'W') 'B' else 'W'
                    }
                    yColor = if (yColor == 'W') 'B' else 'W' // 다음줄의 첫번 째 색을 이전 줄과 달라야 하므로 바꿔줌
                }
                minCount = minOf(minCount, count) // 각 반복마다 최소 수정횟수를 저장함
            }
        }
    }
    println(minCount)
}