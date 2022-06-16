/**
 * https://programmers.co.kr/learn/courses/30/lessons/70128
 * 두 배열 a와 b의 내적을 리턴하는
 * 내적을 구하는 방법은 두 개의 배열을 입력받고 각 배열의 동일한 인덱스의 수를 곱셈한다 그렇게 나온 모든 값을 더한것이 내적
 */

class Solution {
    fun solution(a: IntArray, b: IntArray): Int {
        val set = mutableListOf<Int>()

        for (i in a.indices) { // 두 배열의 size는 같음
            set.add(a[i] * b[i]) // a와 b의 i번째 수를 곱해서 set에 넣어줌
        }
        return set.sum() // set에 저장된 값들의 합을 리턴
    }
}