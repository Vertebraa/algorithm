import java.util.*

/**
 * https://www.acmicpc.net/problem/8393
 * 조건문을 사용한 합 구하기
 * 1부터 입력한 값을 포함한 사이의 모든 숫자의 합을 구하는 문제
 */

fun main(arg: Array<String>) {
    val sc = Scanner(System.`in`)
    val num = sc.nextInt() // 정수를 입력

    var sum = 0 // 최초 덧셈 전 sum의 값

    for (i in 1..num) { // 1부터 입력값 까지 반복
        sum = (sum + i) // 최초 sum  값과 반복문속 i 값을 반복종료까지 덧셈
    }

    println(sum) // 최종 덧셈값 출력
}
