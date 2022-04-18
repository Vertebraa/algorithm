import java.util.Scanner

/**
 * https://www.acmicpc.net/problem/10950
 * 반복문을 사용한 특정 횟수만큼 덧셈하기 (A+B -3)
 * 반복문 내부에 테스트 횟수를 지정
 */

fun main(arg: Array<String>) {
    val sc = Scanner(System.`in`)
    val testCase = sc.nextInt() // 테스트 케이스(반복)의 횟수를 입력
    for (test in 1..testCase) { //테스트 케이스(반복)의 횟수 지정
        val num1 = sc.nextInt() // 덧셈할 정수1 입력
        val num2 = sc.nextInt() // 덧셈할 정수2 입력
        println(num1 + num2) // 두 정수의 합 출력
    }
}