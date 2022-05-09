import java.util.Scanner

/**
 * https://www.acmicpc.net/problem/2750
 * 정렬문제 수 정렬하기
 * 입력된 n개의 숫자를 오름차순으로 정리하는 문제
 * sort()를 사용해서 풀면 간단하지만 거품정렬 방식으로 직접 작성하여 풀이함
 */

fun main(arg: Array<String>) {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val inputArray = IntArray(n)

    for (i in 0 until n) { // array안에 무작위 숫자 n개를 입력
        inputArray[i] = sc.nextInt()
    }
    for (i in 0 until n) {
        for (j in 0 until  n - 1) {
            if (inputArray[j] > inputArray[j + 1]) { // 현재 j번째 숫자가 뒤에 오는 숫자보다 값이 크다면
                val temp = inputArray[j] // 현재 j값을 저장
                inputArray[j] = inputArray[j + 1] // 뒤에오는 수(더 작은수)를 j에 넣어줌
                inputArray[j + 1] = temp // 기존 j에 값을 뒤에 넣어줌
                // 한칸씩 뒤의 숫자와 비교해서 자리를 바꾸는 방법으로 모든 수가 정렬될 때 까지 반복함
            }
        }
    }
    inputArray.forEach { println(it) }
}

