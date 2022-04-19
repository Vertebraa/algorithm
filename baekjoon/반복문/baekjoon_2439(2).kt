import java.io.*

/**
 *  https://www.acmicpc.net/problem/2438
 *  반복문을 사용한 별 찍기
 *  각 행별로 별을 한개씩 늘려가는 형태로 출력
 *  각행에 출력되는 별은 우측으로 정렬하여 출력
 *  Scanner, println 대신 BufferedReader, BufferedWriter 사용
 */

fun main(arg: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`)) // Scanner와 유사한 역할
    val bw = BufferedWriter(OutputStreamWriter(System.`out`)) // print와 유사한 역할
    val count = br.readLine().toInt() // 해당열의 값을 입력받고 Integer 로 바꿔줌

    for (i in 1..count) { // 반복 횟수를 제한
        for (j in count downTo 1) { // i는 1부터 반복 j는 5부터 반복 이후 이래 조건문 실행
            bw.write( // 각 행별 계산 값을 기록
                if (i >= j) "*" // i가 j보다 거나 같을때 * 출력
                else " " //아닌경우 공백
            )
        }
        bw.write("\n") // 개행하여 각 반복 값을 출력
    }
    br.close() // 입력 스트림 종료
    bw.flush() // 기록한 계산값 출력
    bw.close() // 출력 스트림 종료

}