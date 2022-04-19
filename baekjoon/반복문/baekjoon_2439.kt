import java.util.*

/**
 *  https://www.acmicpc.net/problem/2438
 *  반복문을 사용한 별 찍기
 *  각 행별로 별을 한개씩 늘려가는 형태로 출력
 *  각행에 출력되는 별은 우측으로 정렬하여 출력
 */

fun main(arg: Array<String>){
    val sc = Scanner(System.`in`)
    val count = sc.nextInt()

    for (i in 1..count) { // 반복 횟수를 제한
        for (j in count downTo 1) { // i는 1부터 반복 j는 5부터 반복 이후 이래 조건문 실행
            print(
                if (i >= j) "*" // i가 j보다 크거나 같을 때 *출력
                else " " // 아닌경우 공백 출력
            )
        }
        println() // 반복 완료 후 출력
    }
}