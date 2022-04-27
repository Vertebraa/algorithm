import java.io.*

/**
 * https://www.acmicpc.net/problem/11720
 * 문자열 문제 숫자의 합 구하기
 * 공백으로 나눠지지 않은(연속된) 숫자를 분리시켜 합을 구하면된다
 * 예를 들어 12345의 경우 1만2천3백4십5로 인식되지 않게 해야함
 * 정수를 입력받을 수 있는 CharArray로 만들어서 풀이함
 */

fun main(arg: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val testCase = br.readLine() // 연속된 숫자의 길이
    val eachNumbers = CharArray(testCase.toInt()) // 입력받은 숫자를 쪼개서 하나씩 담을 Array

    var sum = 0
    for (i in 0 until testCase.toInt()) {
        eachNumbers[i] = br.read().toChar() // 숫자를 낱개로 쪼개서 index에 한개씩 set함
        sum += Character.getNumericValue(eachNumbers[i]) // 반복 횟수만큼 각 index값을 더해줌
    }
    println(sum) // 마지막에 저장된 index의 합을 출력
    br.close()
}