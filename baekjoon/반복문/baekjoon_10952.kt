import java.util.*

/**
 * https://www.acmicpc.net/problem/10952
 * 반복문을 사용한 두 수 더하기 (A+B -5)
 * for 반복문이 아닌 while과 break를 사용해 특정 조건하에 프로그램을 종료시키는 문제
 */

fun main(arg: Array<String>) {
    val sc = Scanner(System.`in`)

    while (true) { // 아래 코드가 true 인 경우 (break가 아닐 때) 반복 실행
        val num1 = sc.nextInt() // 정수1을 입력
        val num2 = sc.nextInt() // 정수2를 입력
        if (num1 == 0 && num2 ==0) // 정수1과 2에 입력된 값이 둘 다 0일 경우
            break // while 반복 종료, 탈출
        println(num1 + num2) // 조건문 충족(break)가 아닌 경우 덧셈 값 출력
    }
}
