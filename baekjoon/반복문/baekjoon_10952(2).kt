import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

/**
 * https://www.acmicpc.net/problem/10952
 * 반복문을 사용한 두 수 더하기 (A+B -5)
 * for 반복문이 아닌 while과 break를 사용해 특정 조건하에 종료시키는 문제
 * Scanner, println이 아닌 BufferedReader, BufferedWriter를 사용하여 풀이
 */

fun main(arg: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`)) // Scanner와 유사한 역할
    val bw = BufferedWriter(OutputStreamWriter(System.`out`)) // print와 유사한 역할

    while (true) {
        val st = StringTokenizer(br.readLine()) // BufferedReader를 사용해 해당 열의 입력값을 받음
        val num1 = st.nextToken().toInt() // StringTokenizer를 통해 입력받은 값을 Integer 타입으로 바꿔줌 (정수1)
        val num2 = st.nextToken().toInt() //StringTokenizer를 통해 입력받은 값을 Integer 타입으로 바꿔줌 (정수2)
        if (num1 == 0 && num2 == 0) {
            break // 만약 정수1과 정수2에 입력된 값이 둘 다 0일 경우 종료
        }
        bw.write("${num1 + num2}\n") // break가 아닌경우 정수1과 정수2를 덧셈후 출력
    }
    bw.flush()
    bw.close()
}