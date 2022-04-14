import java.util.Scanner

/**
 * https://www.acmicpc.net/problem/1000
 *입력 받은 두 숫자 더하기 문제
 */

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val number1 = sc.nextInt() // 첫 번째 정수를 입력 받는다
    val number2 = sc.nextInt() // 두 번째 정수를 입력 받는다
    val sumResult = number1 + number2 // 입력받은 두 수를 더한다
    println(sumResult) // 더해진 결과물을 출력한다
}