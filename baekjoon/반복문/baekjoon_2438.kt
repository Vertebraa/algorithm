import java.util.*

/**
 * https://www.acmicpc.net/problem/2438
 * 반복문을 사용한 별 찍기
 * 반복문을 중첩해서 사용하는 문제
 */

fun main(arg: Array<String>) {
    val sc = Scanner(System.`in`)
    val count = sc.nextInt()

    for (i in 1..count) { // 반복 횟수를 제한
        for (j in 1..i) { // 반복 횟수 만큼 별출력 ex)1번째 1개 2번째 2개.. N번째 N개
            print("*")
        }
        println() // 별 출력
    }

}