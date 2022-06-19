/**
 * https://programmers.co.kr/learn/courses/30/lessons/86051
 * 0 부터 9 사이의 숫자가 들어있는 배열이 주어진다. 입력 받은 배열에는 중복된 수가 없음
 * 이 배열에 들어있지 않은 0 ~ 9 사이의 숫자를 찾아서 모두 더하는 문제
 * 0은 값과 관계 없으므로 1부터 9까지 숫자가 들어간 set을 만들고
 * 입력 받은 배열의 각 숫자를 set에서 remove하는 것으로 풀이함
 */

class Solution {
    fun solution(numbers: IntArray): Int {
        val arr = mutableSetOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9)
        for (i in numbers.indices) {
            arr.remove(numbers[i]) // arr에서 입력 받은 배열의 정수와 일치하는 수를 제거함
        }
        return arr.sum() // 남은 수 (= 배열에 없던 수)를 모두 더해서 리턴
    }
}