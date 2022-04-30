/**
 * https://programmers.co.kr/learn/courses/30/lessons/12912
 * 두 정수 사이의 합을 구하는 문제
 * 두 정수 a와 b 주어진다 두 정수를 포함한 사이의 값을 모두 더한 값을 리턴하는 문제
 * a와 b의 대소관계는 정해져 있지 않고 무작위로 입력됨, 두 수가 같을 경우 같은수를 리턴하면됨
 */

class Solution {
    fun solution(a: Int, b: Int): Long {
        var answer: Long = 0

        if (a < b) { // b가 더 큰 경우
            for (i in a..b) { // a 부터 b까지 반복하면서 모든 수를 더해줌
                answer += i
            }
        } else { // a가 더 큰 경우
            for (i in a downTo b) { // b..a로 해도 되나 downTo로 작성하고 싶었음
                answer += i // a부터 역순으로 b까지 모든 수를 더해줌
            }
        }
        return answer
    }
}