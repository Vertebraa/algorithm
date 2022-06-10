/**
 * https://programmers.co.kr/learn/courses/30/lessons/42748
 * 입력받은 배열의 commands[0]번째 부터 commands[1]번째 까지 자르고 오름 차순정렬했을 때,
 * 배열의 commands[2]번째 숫자를 리턴하는 문제
 * slice함수를 몰라서 muatableList를 만들고 자른 숫자들을 리스트에 담은 후 리스트를 정렬해서 풀이함
 */


class Solution {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        val answer = mutableListOf<Int>()

        for (i in commands.indices) {
            val start = commands[i][0] - 1 // 자른 배열의 시작 위치
            val end = commands[i][1] - 1 // 자른 배열의 끝나는 위치
            val pick = commands[i][2] - 1 // 자른 배열에서 찾아야 하는 위치 (= 모두 index로 접근해야 하므로 -1)
            val arr = mutableListOf<Int>() // 앞뒤 숫자를 잘라서 만들 리스트

            for (j in start..end) {
                arr.add(array[j]) // 시작점부터 끝나는 위치까지 각 숫자를 리스트에 넣어줌
            }
            arr.sort() // 리스트를 정렬
            answer.add(arr[pick]) // 각 반복마다 찾은 수를 정답 리스트에 넣어줌
            arr.clear() // 반복 마다 잘라서 만든 배열 비워줌
        }
        return answer.toIntArray() // IntArray로 타입 변경하여 리턴
    }
}

//class Solution {
//    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
//        val answer = mutableListOf<Int>()
//
//        for (i in 0 until commands.size) {
//            val start = commands[i][0] - 1
//            val end = commands[i][1] - 1
//            val pick = commands[i][2] - 1
//            val arr = array.slice(IntRange(start,end)).sorted()
//            answer.add(arr[pick])
//        }
//        return answer.toIntArray()
//    }
//}
