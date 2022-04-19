import java.util.Scanner

/**
 * https://www.acmicpc.net/problem/2753
 * 조건문을 사용해 윤년 구하기
 */

fun main(arg: Array<String>) {
    val sc = Scanner(System.`in`)
    val year = sc.nextInt() // 연도를 입력
    if (year in 1..4000) { //연도의 범위를 제한
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            println(1) // 윤년의 조건을 제시, 부합할 경우 1을 출력

        } else { // 윤년이 아닐경우 0을 출력
            println(0)
        }
    }


}