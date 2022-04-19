import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2741
 * n 숫자 찍기 (역순)
 * Scannner, println대신 BufferedReader,BufferedWriter 사용
 */

fun main (arg: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`)) // Scanner와 유사한 역할
    val bw = BufferedWriter(OutputStreamWriter(System.`out`)) // Writer와 유사한 역할
    val count = br.readLine().toInt() // 입력한 행을 읽고 Integer타입으로 변환
    for (i in count downTo 1) { // 입력한 행의 Integer값을 읽고 역순으로 반복
        br.close() // 입력 스트림 종료
        bw.write("$i\n") // 반복 실행한 값들을 개행하여 기록
    }
    bw.flush() // 기록된 값들을 전부 출력
    bw.close() // 출력 스트림 종료
}