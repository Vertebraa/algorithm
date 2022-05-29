import java.util.Deque
import java.util.LinkedList

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42840
 * 프로그래머스 브루트포스 문제 모의고사 최다 정답자 출력하기
 * 3명의 사람이 각자의 패턴대로 정답을 찍는다고 가정했을 때 가장 정답을 많이 맞춘사람을 오름차순해서 리턴
 * n개의 정답이 배열 형태로 입력된다. 최다 정답이 복수일경우 오름차순 배열로 리턴
 */

class Solution {
    fun solution(answers: IntArray): IntArray {
        val scoreList = listOf(
            1 to calculateScore(answers, listOf(1, 2, 3, 4, 5)), // 1번 수험자의 찍기 패턴
            2 to calculateScore(answers, listOf(2, 1, 2, 3, 2, 4, 2, 5)), // 2번 수험자의 찍기 패턴
            3 to calculateScore(answers, listOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)) // 3번 수험자의 찍기 패턴
        )

        val max = scoreList.maxOf { it.second } // 각 수험자의 점수중 최고 점수를 변수로 만듬

        return scoreList
            .filter { it.second == max } // 최고 점수로 filter
            .map { it.first } // 그 다음 각 수험자의 번호로 리스트를 만듬
            .toIntArray() // 마지막으로 배열에 담아줌
    }

    private fun calculateScore(
        answers: IntArray, // 정답을 배열로 받음
        pattern: List<Int> // 찍기 패턴을 리스트로 받음
    ): Int {
        val deque: Deque<Int> = LinkedList(pattern) // 패턴으로 덱을 만듬
        var score = 0
        for (answer in answers) {
            if (answer == deque.peek()) { // 정답 배열과 찍기 패턴이 일치하면
                score++ // 1점 추가
                deque.offerLast(deque.pollFirst()) // 다음 정답 비교를 위해 패턴 덱의 첫번째를 뒤로 보내줌
            } else {
                deque.offerLast(deque.pollFirst()) // 틀린 경우에도 다음 정답 비교를 위해 패턴 덱의 첫번째를 뒤로 보내줌
            }
        }
        return score // 총 점수를 리턴
    }
}