import java.util.Scanner

/**
 * https://www.acmicpc.net/problem/2588
 * 세자릿수 곱셈에서 각 라인의 값 구하기
 */

fun main(arg: Array<String>) {
    val sc = Scanner(System.`in`)
    val num1 = sc.nextInt() // 첫 번째 정수를 입력
    val num2 = sc.nextInt() // 두 번째 정수를 입력
    val line1 = num1 * (num2 % 10) //일의 자릿 값 추출후 첫 번째 정수와 곱셈
    val line2 = num1 * (num2 % 100 / 10) // 십의 자릿 값 추출후 첫 번째 정수와 곱셈
    val line3 = num1 * (num2 / 100) // 백의 자릿 값 추출후 첫 번째 정수와 곱셈
    val line4 = num1 * num2 // 두 수의 곱셈 결과 출력
    println(line1)
    println(line2)
    println(line3)
    println(line4)
}