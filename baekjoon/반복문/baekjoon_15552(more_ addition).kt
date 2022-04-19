import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/15552
 * 반복문을 사용한 덧셈 하기 (빠른 계산)
 * Scanner와 print가 아닌 BufferedReader와 BufferedWriter를 사용해 입,출력
 * 반복문 함수 내부에서 코드의 작성위치 (라인)를 찾는데 애먹음
 */

fun main(arg: Array<String>) {
    val bf = BufferedReader(InputStreamReader(System.`in`)) // BufferedReader 스캐너와 비슷한 역할
    val bw = BufferedWriter(OutputStreamWriter(System.`out`)) // BufferedWriter 프린트와 비슷한 역할
    val testCase = bf.readLine().toInt() //테스트 케이스를 읽고 Integer 타입으로 바꿔줌

    for (i in 1..testCase) { // 1회~입력값 만큼의 횟수까지 반복
        val s = bf.readLine().split(" ") // 입력값을 공백 기준으로 나눠서 받음
        var sum = 0 // sum(덧셈결과)의 최초 값
        for (i in s.indices) { // 0번째 부터 입력 size번째 까지의 숫자를 index로 받음
            sum += s[i].toInt() // 반복 종료까지 덧셈
        }
        bw.write("$sum\n") // 반복계산 값을 기록
    }
    bw.flush() // 저장된 값을 전부 출력
    bw.close() // Writer 스트림을 닫음
    bf.close() // Reader 스트림을 닫음
}
