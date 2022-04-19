import java.util.Scanner

/**
 * https://www.acmicpc.net/problem/10869
 * 입력된 두 숫자를 사용한 사칙연산 문제
 */
fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val num1 = sc.nextInt() // 첫 번째 정수를 입력함
    val num2 = sc.nextInt() // 두 번째 정수를 입력함
    val sum = num1 + num2 // 첫 번째 정수와 두 번째 정수를 더함
    val minus = num1 - num2 // 첫 번째 정수와 두 번째 정수를 뺌
    val multi = num1 * num2 // 첫 번째 정수와 두 번째 정수를 곱함
    val div = num1 / num2 // 첫 번째 정수와 두 번째 정수를 나눔
    val remain = num1 % num2 // 첫 번째 정수와 두 번째 정수를 나누기 후 나머지
    println(sum) // 덧셈 값을 출력
    println(minus) // 뺄셈 값을 출력
    println(multi) // 곱셈 값을 출력
    println(div) // 나누기 값을 출력
    println(remain) // 나머지 값을 출력

}

