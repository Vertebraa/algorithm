/**
 * https://programmers.co.kr/learn/courses/30/lessons/12954
 * x만큼 간격이 있는 n개의 숫자
 * x의 인풋범위가 - 1천만 ~ 1천만이고 n의 인풋 범위가 1000 이므로 Int타입의 max value를 넘어갈수 있음
 * 때문에 long 타입으로 풀이함 입력값은 Int타입으로 들어오기 때문에 long으로 타입 변환하는 과정이 있어야만함
 */


fun main() {
    val x = 2
    val n = 5
    val test = Solution()

    test.solution(x, n).forEach { println(it) } // 2 4 6 8 10이 나와야함
}

class Solution {
    fun solution(x: Int, n: Int): LongArray {
        val answer = LongArray(n)
        var sum = x.toLong() // Int로 받은 정수를 Long타입으로 만들어서 mutable 변수에 담아줌
        for (i in 0 until n) { // n번 반복하면서
            answer[i] = sum // 배열에 넣어주고
            sum += x // 반복문 종료 전에 변수에 x를 더해줌
        }
        return answer

        // return Array<Long>(n) {i -> x.toLong() * (i + 1)}.toLongArray() 이렇게도 작성 가능

    }
}