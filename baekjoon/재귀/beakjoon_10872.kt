import java.util.Scanner

/**
 * https://www.acmicpc.net/problem/10872
 * 재귀함수를 사용해서 N!을 출력하는 문제
 * !(팩토리얼) = n부터 1까지에 있는 모든 숫자를 곱한것 ex) 4! = 4 * 3 * 2 * 1
 * 재귀함수의 원리의 이해도가 부족해서 일반 반복문으로 풀이해봄
 * 아래 주석의 재귀함수는 추가 학습 및 검색을 통해 작성함
 */

fun main(arg: Array<String>) {
    val sc = Scanner(System.`in`)
    val inputNumber = sc.nextInt()
    val result = factorialCalculator(inputNumber)

    println(result)
}

private fun factorialCalculator(n: Int): Int {
    var factorial = 1 // 곱셈을 해야하지 때문에 1로 초기화
    for (i in 0 until n) {
        factorial *= (n - i) // n이 4일때 1 * 4가 저장되고 이후에 4 * 3...24 * 1 까지 반복

    }
    return factorial // 마지막에 저장된 factorial값 리턴
}
//
//private fun factorialCalculator(n: Int): Int = when(n) {
//    0 -> 1
//    else -> n * factorialCalculator(n - 1)
//}
