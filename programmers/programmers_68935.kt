/**
 * https://programmers.co.kr/learn/courses/30/lessons/68935
 * 입력받은 정수를 3진수로 바꾸고 각 자릿수를 뒤집은 다음에 다시 10진수로 바꿔서 출력하는 문제
 * 3진수로 변환 하는 방법을 몰랐는데 검색을 통해 알게됨,
 * 3진수를 10진수로 바꾸는 방법도 알게됨
 * Int.toString(n) -> 정수를 n진수로 바꿔줌,  .toInt(n) -> n진수를 10진수로 바꿔줌
 */


class Solution {
    fun solution(n: Int): Int {
        return n.toString(3).reversed().toInt(3)
    }
}