import java.util.LinkedList
import java.util.Queue
import java.util.Scanner

/**
 * https://www.acmicpc.net/problem/2606
 * 그래프와 순회 문제 모체를 통한 바이러스 감염 PC의 수 출력하기
 * N대의 PC중 M대의 PC가 네트워크로 연결되어 있다
 * PC 1과 연결된 모든 PC가 바이러스에 감염된다고 할 때
 * 입력으로 주어진 연결 구조에서 바이러스에 감염된 PC의 수를 출력 (모체는 감염 수에 포함 시키지 않음)
 * BFS로 풀이함
 */

fun main() = Scanner(System.`in`).use { sc ->
    val pcSize = sc.nextInt() // 전체 PC의 수
    val linkedSize = sc.nextInt() // 연결된 PC의 수
    val pcMap = mutableMapOf<Int, Pc>() // 특정 PC와 연결된 PC의 데이터를 Map으로 만듬

    for (i in 1..pcSize) {
        pcMap[i] = Pc(i, mutableListOf()) // 1번 부터 N번 까지를 Map으로 생성
    }

    repeat(linkedSize) {
        val hostPc = pcMap[sc.nextInt()] // 연결된 PC1
        val guestPc = pcMap[sc.nextInt()] // 연결된 PC2
        if (hostPc != null && guestPc != null) {
            hostPc.linkedPcList.add(guestPc) // PC1의 연결된 PC리스트에 2를 넣어줌
            guestPc.linkedPcList.add(hostPc) // PC2의 연결된 PC리스트에 1을 넣어줌
        } // 입력으로 받는 연결 구조를 서로 연결함
    }

    val queue: Queue<Pc> = LinkedList() // 감염여부를 확인 하기 위한 Queue를 만듬

    pcMap[1]?.let { queue.offer(it) } // PC1이 null이 아닌경우 실행
    while (queue.isNotEmpty()) { // Queue가 비어있지 않은경우
        val pc = queue.poll() // Queue의 첫번째를 꺼냄
        pc.isInfected = true // 감염 여부를 true로 바꿔주고
        pc.linkedPcList.forEach { // 연결된 다른 PC들을 검사
            if (it.isInfected.not()) { // 감염되지 않았다면
                queue.offer(it) // Queue에 맨뒤로 넣어줌
            }
        }
    }

    val count = pcMap.values.count { it.isInfected } - 1 // Map의 value가 감염된경우의 수를 카운트함
    println(count)
}


data class Pc(
    val pcId: Int,
    val linkedPcList: MutableList<Pc>
) {
    var isInfected: Boolean = false // 최초 감염 여부를 false로 지정한다
}