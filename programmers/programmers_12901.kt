/**
 * https://programmers.co.kr/learn/courses/30/lessons/12901
 * 2016년의 a월 b일의 요일을 구하는 문제
 * 1월 1일은 금요일이고 2016년은 윤년이다라는 정보를 문제에서 제공함
 * 1월 1일은 금요일이기 때문에 목요일부터 시작하는 요일 배열을 만들고 (각 요일을 index로 접근하기 위해)
 * 각 월별 일수를 배열로 만들고 [a월의 전월까지 모든일수의 합 + b]을 7로 나눈 나머지를
 * index 번호로 요일을 get해서 풀이함
 */

fun main() { // solution 테스트용 main
    val test = Solution()
    val a = 5
    val b = 24
    print(test.solution(a, b)) // TUE가 나와야 함
}

private class Solution {

    fun solution(a: Int, b: Int): String {
        val dayOfWeek = arrayOf("THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED") // 1월 1일이 금요일 이므로 목요일부터 생성 (index로 접근하기 위해)
        val sizeOfMonth = intArrayOf(31, 29, 31, 30 ,31, 30, 31, 31, 30, 31, 30, 31) // 윤년의 각 월별 일수를 배열로 만듬
        var dayCount = b // a월의 b일을 찾는 것이기 때문에 b일을 기본값으로 변수를 만듬
        for (i in 0 until a - 1) {
            dayCount += sizeOfMonth[i] // a월의 전월 까지의 각 월별일수를 모두 더해줌
        }
        val target = dayCount % 7 // 위에 합산된 월별 일수를 7로 나눈 나머지
        return dayOfWeek[target] // 를 index번호로 get한 요일을 리턴
    }
}