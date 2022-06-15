/**
 * https://programmers.co.kr/learn/courses/30/lessons/12977
 * 주어진 배열에 담긴 숫자중 3개를 골라서 더했을 때 소수가 되는 경우의 수를 구하는 문제
 * 소수인지 구하는 함수를 만들고 모든 경우의 수를 탐색하며
 * 3개의 숫자의 합이 소수인 경우 카운트를 더해주는 식으로 풀이함
 */

class Solution {
    fun solution(nums: IntArray): Int {
        var primeCount = 0
        for (i in nums.indices) { // 꺼낼 수 있는 세개의 정수 조합의 모든 경우의 수를 탐색
            for (j in i + 1 until nums.size) {
                for (k in j + 1 until nums.size) {
                    if (isPrimeNumber(nums[i] + nums[j] + nums[k])) { // 배열에서 세개의 정수를 뽑아서 더한 값이 소수라면
                        primeCount++ // 소수 카운트 ++
                    }
                }
            }
        }
        return primeCount
    }
}

private fun isPrimeNumber(n: Int): Boolean {
    var i = 2 // 소수에는 1이 포함 되지 않으므로 2부터

    while (i * i <= n) { // 정수의 제곱근 까지만 탐색하면 소수인지 판별이 가능하다
        if (n % i++ == 0) { // i를 1씩 늘려가면서 i로 n을 나웠을 때 나머지가 없다면 (= 1과 자신이외에 다른 수로 나눠진다면)
            return false // 소수가 아니다
        }
    }
    return true
}