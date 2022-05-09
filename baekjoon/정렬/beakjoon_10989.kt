import java.io.*

/**
 * https://www.acmicpc.net/problem/10989
 * 정렬 문제 입력된 숫자들을 오름차순으로 출력 시키는 문제
 * 카운팅 정렬을 사용해서 시간을 최소화 시키는 문제지만
 * BufferedReader와 BufferedWrite를 사용해도 시간제한내에 풀이가 가능하다
 */

fun main(arg: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val array = IntArray(n)

    for (i in 0 until n) {
        array[i] = br.readLine().toInt()
    }
    br.close()
    array.sort()
    for (i in 0 until n) {
        bw.write("${array[i]}\n")
    }
    bw.flush()
    bw.close()
}