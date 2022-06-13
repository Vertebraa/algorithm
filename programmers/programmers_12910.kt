/**
 * https://programmers.co.kr/learn/courses/30/lessons/12910
 * array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 리턴하는 문제
 * 만약 divisor로 나누어 떨어지는 수가 없다면 -1을 배열에 담아 리턴한다
 */

class Solution {
    fun solution(arr: IntArray, divisor: Int): IntArray {
        val answer = arr.filter { it % divisor == 0 }.sorted().toIntArray()
        // array에서 divisor로 나누어 지는 수만 filter해 리스트로 만들고, 정렬한 후에, intArray로 타입을 바꿔줌
        return if (answer.isNotEmpty()) { // answer가 비어있지 않다면 (= 나누어 떨어지는 수가 있다면)
            answer // answer 리턴
        } else { // answer가 비어있다면 (= 나누어 떨어지는 수가 없다면)
            IntArray(1) {-1} // -1 을 배열에 담아 리턴
        }
    }
}
