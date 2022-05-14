import java.io.*
import java.util.StringTokenizer

/**
 * https://www.acmicpc.net/problem/1764
 * 집합과 맵 문제 듣지도 보지도 못한 사람을 출력 하는 문제
 * n명의 들어보지 못한 사람과 m명의 본적없는 사람이 입력됨
 * 이중 듣지도 보지도 못한 사람의 수와 이름을 출력하는 문제 (이름은 오름 차순으로 정렬)
 * 두 명단엔 중복이 없으므로 hashSet을 사용하고 contains로 탐색하여 풀이함
 */

fun main(arg: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val neverHeard = hashSetOf<String>() // 들어보지 못한 사람들의 hashSet

    for (i in 0 until n) {
        neverHeard.add(br.readLine()) // 입력 순으로 hashSet에 저장
    }
    val sb = StringBuilder()
    val list = mutableListOf<String>() // 듣도 보도 못한 사람이 들어갈 list를 만듬
    for (i in 0 until m) {
        val neverSeen = br.readLine()
        if (neverHeard.contains(neverSeen)) { // 들어보지 못한 사람들의 set에 보지못한 사람이 contains되어 있다면
            list.add(neverSeen) // 해당 사람을 듣도보도 못한 사람에 add해줌
        }
    }
    sb.append(list.size)
    sb.append("\n")
    list.sort()
    list.forEach { sb.append("$it\n") }
    println(sb.toString())
}