import java.util.*

/**
 * https://www.acmicpc.net/problem/11022
 * 반복문을 사용한 두 수 더하기
 * 이전 문제와 동일한 문제이지만 출력 양식의 변화만 있음
 */

fun main(arg: Array<String>) {
    val sc = Scanner(System.`in`)
    val testCase = sc.nextInt()

    for (i in 1..testCase) { // testCase의 범위를 제한
        val num1 = sc.nextInt() // 정수1을 입력
        val num2 = sc.nextInt() // 정수2를 입력
        val sum = num1 + num2 // 두 정수를 더함

        println("Case #$i: $num1 + $num2 = $sum") // 양식에 맞춰 덧셈값을 출력
    }
}