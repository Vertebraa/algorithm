import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

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
        val s = bf.readLine()
        val st = StringTokenizer(s)
        val num1 = st.nextToken().toInt() // 정수1을 입력받고 Integer 타입으로 바꿔줌
        val num2 = st.nextToken().toInt() // 정수2를 입력받고 Integer 타입으로 바꿔줌
        val sum = (num1 + num2).toString() // 덧셈 결과를 String 타입으로 바꿔줌
        bw.write(sum+"\n") // 반복계산 값을 기록
    }
    bw.flush() // 저장된 값을 전부 출력
    bw.close() // Writer 스트림을 닫음
    bf.close() // Reader 스트림을 닫음
}


