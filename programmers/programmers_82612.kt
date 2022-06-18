/**
 * https://programmers.co.kr/learn/courses/30/lessons/82612
 * 놀이기구의 이용료 price가 주어지고 타고 싶은 횟수 count가 주어짐
 * 놀이기구 이용 요금은 price * n번으로 책정됨 ex)첫 번째 price * 1, 두 번째 price * 2, ... N번째 price * N
 * 현재 소지금 money가 주어질 때 타고 싶은 만큼 놀기구를 타려면 부족한 금액을 리턴하는 문제
 * 만약 소지금이 충분하다면 0을 리턴
 */

class Solution {
    fun solution(price: Int, money: Int, count: Int): Long {
        var totalCost: Long = 0
        for (i in 1..count) { // 타고싶은 횟수 만큼 1씩 늘려가면서 반복
            totalCost += price * i // 회차별 요금을 반복하면서 총 요금에 더해줌
        }
        return if (money > totalCost) { // 총 요금보다 소지금이 많다면
            0 // 0 리턴
        } else { // 부족하다면
            totalCost - money // 부족한 금액을 리턴
        }
    }
}