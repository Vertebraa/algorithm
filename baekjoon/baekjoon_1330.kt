import java.util.Scanner

/**
 * https://www.acmicpc.net/problem/1330
 * 조건문을 사용한 두 수 비교하기
 */

fun main(arg: Array<String>) {
    val sc = Scanner(System.`in`)
    val numA = sc.nextInt() // 첫 번째 숫자를 입력
    val numB = sc.nextInt() // 두 번째 숫자를 입력
    if (-10000 <= numA && numB <= 10000) { // 각각의 숫자들의 범위

        if (numA > numB) // A가 B보다 큰경우 >를 출력
            println(">")
        else if (numA < numB) // B가 A보다 큰경우 <를 출력
            println("<")
        else println("==") // 이외의 경우 (= 두 수가 같을 경우) == 를 출력
    }
}

}