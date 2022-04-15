import java.util.Scanner

/**
 * https://www.acmicpc.net/status?user_id=sksk11power&problem_id=14681&from_mine=1
 * 조건문을 사용하여 사분면 고르기
 */

fun main(arg: Array<String>) {
    val sc = Scanner(System.`in`)
    val x = sc.nextInt()
    val y = sc.nextInt()

    if (-1000 <= x && x <= 1000) { // x값의 범위를 제한
        if (-1000 <= y && y <= 1000) { // y값의 범위를 제한
            if (0 < x) {
                if (0 < y) { // x가 양수이고 y가 양수일 때 1을 출력
                    println("1")
                }
                if (0 > y) { // x가 양수이고 y가 음수일 때 4를 출력
                    println("4")
                }
            }
            if (0 > x) {
                if (0 < y) { // x가 음수이고 y가 양수일 때 2를 출력
                    println("2")
                }
                if (0 > y) { // x가 음수이고 y가 음수일 때 3를 출력
                    println("3")
                }
            }
        }
    }
}
