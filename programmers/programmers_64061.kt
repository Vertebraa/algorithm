import java.util.Stack

/**
 * https://programmers.co.kr/learn/courses/30/lessons/64061
 * 프로그래머스 카카오 인턴십 level 1 크레인 인형뽑기
 * 입력으로 인형들이 들어있는 상자 (IntArray)와 몇번째 라인의 인형을 뽑을지 (IntArray)가 주어진다
 * 인형을 뽑아서 1x1 사이즈의 어떤 상자에 차곡차곡 아래부터 쌓는데,
 * 같은 인형이 연속해서 두개가 쌓이면 인형이 떠뜨려 지면서 사라진다
 * 모든 이동이 완료 됐을때 사라진 인형의 총 갯수를 리턴하면 되는 문제
 * 각 라인별로 위부터 순서대로 탐색하면서 0이 아닌경우(인형이 있을때) stack에 넣어주고
 * stack의 peek과 인형이 같은경우 stack을 pop하고 현재칸의 인형을 없애줌, 터진인형 카운트 +2
 * 위의 과정을 반복문을 돌면서 이동을 완료하는 것으로 풀이함
 */

class Solution {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        var pop = 0 // 터진 인형 갯수
        val stack = Stack<Int>() // 1x1의 상자

        for (element in moves) { // moves의 각 element를 돌면서
            for (j in board.indices) { // board의 사이즈만큼 (= 세로길이만큼) 반복
                val character = board[j][element - 1] // 세로로 라인을 탐색하는 좌표를 변수로 만듬
                if (character != 0) { // 해당위치에 인형이 있다면
                    if (stack.isNotEmpty() && stack.peek() == character) { // 스택이 비어있지않고, 가장위의 인형과 현재 넣으려는 인형이 같으면
                        pop += 2 // 터진 인형수 +2
                        stack.pop()
                    } else {
                        stack.push(character) // 스택에 아무것도 없거나 현재인형과 peek이 다르다면 스택에 push
                    }
                    board[j][element - 1] = 0 // 인형을 꺼낸 칸을 상태를 비어있는것으로 바꿔줌
                    break // 계속 넣거나 0으로 바꾸지 않기위해 break
                }
            }
        }
        return pop // 터진 인형 갯수 리턴턴
   }
}
