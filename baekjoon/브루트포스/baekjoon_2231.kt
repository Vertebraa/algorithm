import java.util.Scanner

/**
 * https://www.acmicpc.net/problem/2231
 * 브루트포스 문제 분해합 구하기
 * 분해합은 숫자 n이 있을때 n과 각각의 자릿수를 모두 더해 만든 수 이다.
 * 예를 들어 123의 분해합은 123 + 1 + 2 + 3 = 129 이다
 * 1부터 모든 수를 탐색해도 되지만 분해합의 생성자에 더해질수 있는 최대 수는
 * 세자릿수의 경우 9 + 9 + 9 = 27, 네자릿수의 경우엔 9 + 9 + 9 + 9 = 36 이다 즉, 자릿수 * 9
 * 따라서 생성자 - (자릿수 * 9) 에서 생성자 까지의 범위만 모두 탐색하는게 효율적
 */

fun main() = Scanner(System.`in`).use { sc ->
    val n = sc.nextInt() // 분해합을 입력받음
    val digit = n.toString().length // 자릿수를 찾음 ( 자릿수의 변화가 생기더라도 탐색 범위는 오히려 작아지는 쪽으로만 변화하므로 상관없음)

    val min = n - (digit * 9) // 분해합의 생성자가 등장 할 수 있는 최소 위치
    var answer: Int? = null

    for (i in min..n) { // 최소위치부터 분해합의 위치까지 탐색
        val sum = i + i.toString().map { Character.getNumericValue(it) }.sum() // i로 만든 분해합
        if (sum == n) { // i로 만든 분해합이 입력과 같다면
            answer = i // 해당 수를 변수에 담아줌
            break // 가장 작은 생성자 = 처음 만나는 생성자 이므로 break
        }
    }
    println(answer ?: 0) // 생성자를 출력하고 없다면 0 출력
}