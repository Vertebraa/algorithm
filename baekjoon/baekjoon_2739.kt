import java.util.Scanner

/**
 *https://www.acmicpc.net/problem/2739
 * 반복문을 사용한 구구단 만들기
 */

fun main(arg: Array<String>) {
    val sc = Scanner(System.`in`)
    val dan = sc.nextInt() // 구구단 몇 단인지 입력

    if (dan in 1..9) { // 1~9단 까지 범위를 지정
        for (multi in 1..9) { // 각 단별로 *9 까지 반복
            println("$dan * $multi = ${dan * multi}") // 구구단 값 출력
        }
    }
}

