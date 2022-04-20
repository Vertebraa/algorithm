import java.util.*

/**
 * https://www.acmicpc.net/problem/10871
 * 반복문을 사용한 x(cutLine)보다 작은수 출력하기
 * 반복문 안에 변수를 만들어서 반본문 횟 수만큼 수를 입력받음
 * 이후 조건문을 사용해 x보다 입력값이 작은 경우에만 출력하도록 함
 */

fun main(arg: Array<String>) {
    val sc = Scanner(System.`in`)
    val numbers = sc.nextInt()
    val cutLine = sc.nextInt()


    for (i in 0 until numbers) { // 반복 횟수를 제한
        val number = sc.nextInt() // 정수로된 수열을 입력받음
        if (number < cutLine) { // 수열의 각 정수값이 cutLine 보다 작은경우
            print("$number ") // 해당 값을 출력 + 각 값뒤에는 공백이 온다
        }
    }
}
