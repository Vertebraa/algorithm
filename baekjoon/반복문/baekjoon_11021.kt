import java.util.*

/**
 * https://www.acmicpc.net/problem/11021
 * 반복문을 사용한 두 수 더하기
 * 출력값에 문자열과 반복 횟수 그리고 덧셈값을 출력하는 문제
 */

fun main(arg: Array<String>) {
    val sc = Scanner(System.`in`)
    val testCase = sc.nextInt()


    for (i in 1..testCase) { // 테스트 횟수를 제한

        val num1 = sc.nextInt() // 정수1을 입력
        val num2 = sc.nextInt() // 정수2를 입력
        val sum = num1 + num2 // 정수1과 2를 더함

        println("Case #${i}: $sum") // 양식과 덧셈결과를 출력
    }
}