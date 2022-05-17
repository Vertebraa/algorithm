/**
 * https://programmers.co.kr/learn/courses/30/lessons/77884
 * left 부터 right 사이 각 정수들의 약수를 구한다.
 * 각 정수의 약수의 갯수가 짝수라면 더하고 홀수면 뺀다.
 * 마지막에 더하고 뺀 수를 리턴하는 문제
 */

class Solution {
    fun solution(left: Int, right: Int): Int {
        var answer: Int = 0

        for(i in left..right) { // left부터 right까지 숫자들을 탐색함
            var count = 0
            for(j in 1..i) {
                if (i % j == 0) { // 현재 보고있는 정수가 1이외에 다른 수로 나누어 진다면 (= 약수가 있다면)
                    count++ // 약수 카운트 ++
                } // 소수일 경우에도 약수는 2개가 존재
            }
            if (count % 2 == 0) { // 약수의 갯수가 짝수라면
                answer += i // answer에 덧셈
            } else { // 홀수라면
                answer -= i // answer에 뺄셈
            }

        }
        return answer // 마지막에 저장된 answer값 리턴
    }
}