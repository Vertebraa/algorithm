import java.util.Scanner

/**
 * https://www.acmicpc.net/problem/10951
 * 반복문을 사용해 두 수 더하기 (A+B -4)
 * 여러개의 테스트 케이스가 존재하지만, 반복 횟수 제한이나 특정 종료 조건이 없는 문제
 * EOF 개념을 이해해야 한다고 하는데 아직 잘 모르겠음
 */

fun main(arg: Array<String>) {
    val sc = Scanner(System.`in`)

    while (sc.hasNext()) { // 입력값이 존재하는 동안 반복 실행
        val num1 = sc.nextInt() // 정수1을 입력 받음
        val num2 = sc.nextInt() // 정수2를 입력 받음
        println(num1 + num2) // 정수1과 2를 더한후 출력
    }
}
