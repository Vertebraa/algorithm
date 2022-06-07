/**
 * https://www.boostcourse.org/selfcheck/lecture/1410049?isDesc=false
 * 부스트코스 자가진단 문제
 * 배열안에 있는 각 정수들이 중복해서 등장한 경우 몇번씩 등장했는지 출력하는 함수를 작성하시오
 * hashMap을 사용해서 각 정수를 key로 중복 횟수를 value로 지정해서 풀이함
 */

fun main() { // 예제
    val arr = arrayOf(3, 4, 4, 2, 2, 5, 2, 5, 5)
    val sol = Solution()
    val answer = sol.solution(arr)
    println(answer.contentToString())
}

class Solution {
    fun solution(arr: Array<Int>): IntArray {
//    val result = arr.distinct()
//        .map { number -> arr.count { it == number } }
//        .filter { it > 1 }
//
//    return if (result.isNotEmpty()) {
//        result.toIntArray()
//    } else {
//        intArrayOf(-1)
//    }
        val map = hashMapOf<Int, Int>() // key(정수), value(중복횟수)
        for (element in arr) {
            map[element] = (map[element] ?: 0) + 1
        // 입력받은 배열의 원소의 value가 0이라면 (= 등장한적이 없다면) 1을 더해주고 등장한적이 있다면 +1
        }

        val answer = mutableListOf<Int>()
        val eachElements = arr.distinct() // 각원소들의 중복을 제거한 배열 (key)
        for (element in eachElements) {
            val currentElement = map[element] // 해당 key로 꺼내온 Map의 value를 변수화
            if (currentElement != null && currentElement > 1) { // null 인지 확인, 중복 횟수가 1을 초과한다면
                answer.add(currentElement) // answer 리스트에 넣어줌
            }
        }

        if (answer.isEmpty()) { // answer 리스트가 비어있다면 (중복된 원소가 없는 경우)
            answer.add(-1) // 리스트에 -1 을 넣어줌
        }
        return answer.toIntArray() // 리스트를 Int타입 배열로 바꿔서 리턴턴    }
}
