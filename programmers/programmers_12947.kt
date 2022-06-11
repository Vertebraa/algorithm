/**
 * https://programmers.co.kr/learn/courses/30/lessons/12947
 * 정수 x가 하샤드 수 인지 판별하는 문제
 * 하샤드 수는 2자릿수 이상의 정수의 각 자릿수를 더한값을 제수로 원래 정수를 나눴을때 나누어 떨어지는 수를 말한다.
 * 예를 들어 12는 자릿수의 합이 3이고, 12를 3으로 나눴을때 나머지가 없기 떄문에 하샤드 수이다.
 * 11의 경우 각 자릿수의 합은 2이고, 11을 2로 나누면 나머지가 1이기 때문에 하샤드 수가 아니다.
 */

fun main() { // 테스트용 main
    val x = 12
    val test = Solution()

    print(test.solution(x)) // true가 나와야함
}


class Solution {
    fun solution(x: Int):Boolean {

        var answer = true // 하샤드 수 인지 여부, 초기엔 true로 지정
        if (x % sumOfEach(x) != 0) { // 각 자릿수의 합으로 나눈 나머지가 0이 아니면
            answer = false // 하샤드 수 아님
        }
        return answer // 위의 조건에 걸리지 않았다면 하샤드 수이다.
    }
    private fun sumOfEach(x: Int): Int {
        var n = x
        var sum = 0
        while (n > 0) {
            sum += n % 10 // 정수를 10으로 나눈 값을 sum 변수에 더해줌
            n /= 10 // 그리고 정수를 10으로 나눈값을 다음번에 나눗셈할 피제수로 바꿔줌
        }
        return sum
    }
}