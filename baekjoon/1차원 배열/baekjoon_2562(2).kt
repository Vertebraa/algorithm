import java.io.*
import java.util.*

/**
 * https://www.acmicpc.net/problem/2562
 * 1차원 배열문제 IntArray를 사용해서 풀이함
 * Scaaner, Print 대신 BufferedReader, BufferedWriter를 사용해서 풀이함
 * StringTokenizer를 반복문 밖에 지정해서 첫번째 이후 자연수를 읽지 못해 에러가 났었음
 * 코드 작성 위치를 정확히 잡는 연습이 필요함
 */

fun main(arg: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val array = IntArray(9) // Array의 사이즈를 제한

    for (i in 0 until 9) {
        val st = StringTokenizer(br.readLine())
        array[i] = st.nextToken().toInt() // Array의 각 index에 자연수를 set함
    }
    var count = 0 // 최초 count의 변수 값
    var max = 0 // 최초 max의 변수 값

    for (i in 0 until 9) { // 반복 횟수 제한
        if (max < array[i]) {
            max = array[i] // max의 값이 해당 반복회차에 입력된 자연수보다 클 경우 해당값으로 max를 초기화
            count = i + 1 // 위의 조건 충족시 count를 해당 회차의 i값 + 1 후 count 변수값 초기화
        }
    }
    bw.write("$max\n") // 최종 max값 기록
    bw.write("$count") // 최총 count값 기록
    bw.flush() // 기록된 값을 모두 출력
    bw.close() // Write 스트림 종료
}