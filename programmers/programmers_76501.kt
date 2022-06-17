/**
 * https://programmers.co.kr/learn/courses/30/lessons/76501
 * 음양 더하기
 * 정수가 들어있는 배열을 입력 받고, 정수들의 음양 여부가 들어있는 Boolean배열이 입력된다.
 * Boolean배열의 n번째가 참이면 정수 배열의 n번째 수는 양수, 거짓이면 음수
 * 음양 여부를 반영한 후 정수배열의 모든 수를 더해서 리턴하는 문제
 */

class Solution {
    fun solution(absolutes: IntArray, signs: BooleanArray): Int {
        var answer: Int = 0

        for (i in absolutes.indices) { // 두 배열의 크기는 같음, 정수배열 크기만큼 탐색
            if (signs[i]) { // Boolean배열의 i번째가 참이면 (=양수면)
                answer += absolutes[i] // answer에 더해줌
            } else { // 음수면
                answer -= absolutes[i] // answer에서 빼줌 ( * -1을 해서 더해줘도됨)
            }
        }
        return answer
    }
}