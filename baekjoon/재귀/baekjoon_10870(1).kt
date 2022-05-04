import java.util.Scanner

/**
 * https://www.acmicpc.net/problem/10870
 * 재귀함수를 사용해서 피보나치 수열을 출력하라
 * 피보나치 수열은 0번째 자리는 0 1번째 자리는 1로 시작하는 수열로 2번째 자리부터는 앞의 두 수의 합으로 이루어진다 (n번째 까지)
 * n이 17일 경우 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597
 * 재귀함수의 원리의 이해도가 부족해서 일반 반복문으로 풀이해봄
 * 아래 주석의 재귀함수는 추가 학습 및 검색을 통해 작성함
 */

fun main(arg: Array<String>) {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val fibonacci = IntArray(n + 1) // 0번째 부터 n번째 까지 이므로 n보다 1개 더 큰 size의 빈 array를 만듬

    for (i in 0 until fibonacci.size) {
        when(i) {
            0 -> fibonacci[0] = 0 // 0번째 값은 불변
            1 -> fibonacci[1] = 1 // 1번째 값은 불변
            else -> fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2] // 앞선 두 수의 합이 수열의 2번째부터 값
        }
    }
    println(fibonacci[n])
}

//private fun fibonacci(N: Int): Int = when (3) {
//    0 -> 0
//    1 -> 1
//    else -> fibonacci(N - 1) + fibonacci(N - 2)
//}

// n == 5 fibonacci 4(=3) + fibonacci 3(=2)
// n == 4 fibonacci 3(=1+0+1) + fibonacci 2(=1+0) == 3
// n == 3 fibonacci 2(=1+0) + fibonacci 1(=1)
// n == 2 fibonacci 1(=1) + fibonacci 0(=0)
// n == 1 1
// n == 0 0