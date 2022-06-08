/**
 * https://programmers.co.kr/learn/courses/30/lessons/12940
 * 최대공약수와 최소공배수를 구하는 문제
 * 유클리드 호제법을 사용해 두 정수의 나머지가 0일때 까지 재귀함수를 돌려서 최대공약수를 구함
 * 두 정수의 곱셈 결과를 최대공약수로 나눠서 최소 공배수를 구함
 * 배열에 최대공약수와 최소공배수 순서로 담아서 풀이함
 */

fun main() { // 함수 테스트용 main
    val test = Solution()
    val a = 3
    val b = 12
    print(test.solution(a, b).joinToString(separator = ", ", "[", "]")) // 출력양식 [3, 12]가 나와야함
}

private class Solution {
    fun solution(n: Int, m: Int): IntArray {
        return intArrayOf(gcd(n, m), lcm(n, m))
    }
    private fun gcd(n: Int, m: Int): Int { // 유클리드 알고리즘
        val r = n % m // 두 정수를 나누기 연산하여 결과가 0이라면
        return if (r == 0) {
            m // 나눗셈의 제수가 최대공약수
        } else { // 나머지가 있는경우 제수와 나머지로 나머지가 0이 될때까지 재귀
            gcd(m, r)
        }
    }

    private fun lcm(n: Int, m: Int): Int { // 최소공배수
        val lcm = (n * m) / gcd(n, m) // 두정수를 곱한후 그 값을 최대공약수로 나눔
        return lcm
    }
}
