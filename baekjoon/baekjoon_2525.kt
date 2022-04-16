import java.util.Scanner

/**
 * https://www.acmicpc.net/problem/2525
 * 조건문을 사용한 완료시간 구하기
 * 저번 문제 까지는 println을 여러차례 사용하여 조건 충족시 출력되는 코드를 여러 줄 사용했었음
 * 이번 문제에서는 코드가 길어지거나 반복되는 모양을 피하기 위해 hour과 minute값을 var로 지정해 가변할 수 있게 선언
 * 코드 내부에서 특정 조건하에 hour과 minute의 값이 달라지게 만듬
 * 해당 방법으로 코드 구성하는게 이전 방법보다 깔끔해보임
 */

fun main(arg: Array<String>) {
    val sc = Scanner(System.`in`)
    var (hour, minute) = Pair(sc.nextInt(), sc.nextInt()) // 한 줄에 두개의 정수를 입력하기 위해 Pair 사용
    val cookingTime = sc.nextInt() // 세번째 정수 입력

    if (hour in 0..23 && minute in 0..59 && cookingTime in 0..1000) { // 시간의 범위를 제한
        if (minute + cookingTime >= 60) { // 현재 분과 조리시간이 60을 초과하는 경우 시간의 변화가 생김
            val additionalHour = (minute + cookingTime) / 60 // 추가시간 = 현재 분 + 조리시간을 60으로 나눈 해
            minute = (minute + cookingTime) % 60 // 추가 시간을 제외한 나머지 = 현재 분
            if (hour + additionalHour >= 24) { // 24시 = 0시
                hour = (hour + additionalHour) % 24 // 현재 시간 + 조리 시간이 24시를 초과하는 경우의 시간을 구함
            } else {
                hour += additionalHour // 24시를 넘지 않는 경우 현재 시간과 추가 시간을 더함
            }
        } else {
            minute += cookingTime // 60분을 넘지 않는 경우 현재 분과 조리시간을 더함
        }
        println("$hour $minute") // 계산된 완료 시간을 구함
    }
}