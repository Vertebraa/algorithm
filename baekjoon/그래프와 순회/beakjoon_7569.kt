import java.util.LinkedList
import java.util.Queue
import java.util.Scanner

/**
 * https://www.acmicpc.net/problem/7569
 * 그래프와 순회 문제 토마토 상자안에 있는 토마토가 모두 익는데까지 걸리는 시간을 출력하는문제 (2)
 * 이전문제와 동일하지만 이번에는 토마토 상자가 여러 층으로 쌓여 있음
 * 또, 익은 토마토의 영향력이 상하좌우 4방향에서 윗층 아랫층으로 6방향으로 늘어남
 * 기본적으로 풀이 방법은 앞 문제와 동일하지만 3차원 배열로 z축 상에 있는 다른 상자를 추가하고,
 * 상자 더미의 모든 칸을 연결 시킨 후 BFS 탐색 방법으로 풀이함
 */

fun main() = Scanner(System.`in`).use { sc ->
    val horizontal = sc.nextInt() // 상자의 가로사이즈
    val vertical = sc.nextInt() // 상자의 세로사이즈
    val storey = sc.nextInt() // 상자가 몇겹으로 쌓여있나
    val tomatoBox = Array(storey) { // storey층으로 쌓인
        Array(vertical) { // 세로 vertical칸
            Array(horizontal) { // 가로 horizontal칸의 상자
                Tomato(sc.nextInt(), mutableListOf())
            }
        }
    }
    for (z in 0 until storey) {
        for (y in 0 until vertical) {
            for (x in 0 until horizontal) {
                val currentTomato = tomatoBox[z][y][x]

                tomatoBox[z][y].getOrNull(x + 1) // 현재 칸과 오른쪽 칸을 상호 연결
                    ?.let { rightTomato -> link(currentTomato, rightTomato) }

                tomatoBox[z].getOrNull(y + 1)?.get(x) // 현재 칸과 아래쪽 칸을 상호 연결
                    ?.let { bottom -> link(currentTomato, bottom) }

                tomatoBox.getOrNull(z + 1)?.get(y)?.get(x) // 현재 칸과 아래층의 칸을 상호 연결
                    ?.let { under -> link(currentTomato, under) }
            }
        }
    }

    val todayRide: Queue<Tomato> = LinkedList() // 오늘 익어있는 토마토가 들어갈 Queue

    for (z in 0 until storey) {
        for (y in 0 until vertical) {
            for (x in 0 until horizontal) {
                if (tomatoBox[z][y][x].state == 1) {
                    todayRide.offer(tomatoBox[z][y][x])
                } // 모든 칸을 훑으면서 익은 토마토가 있으면 모두 todayRide Queue에 넣어줌
            }
        }
    }
    var days = -1
    while (todayRide.isNotEmpty()) { // 익은 토마토가 여러개 있을때 날짜계산에 오차가 생기지 않기 위해 이중 While
        val tomorrowRide: Queue<Tomato> = LinkedList() // 내일 익을 토마토가 들어갈 tomorrowRide Queue를 만듬
        while (todayRide.isNotEmpty()) {
            val rideTomato = todayRide.poll() // todayRide Queue에 poll을 변수에 담음
            rideTomato.linked // todayRide Queue에 poll과 연결된 토마토를 돌면서
                .filter { it.state == 0 } // 익지 않은 토마토만 필터링
                .forEach { // 익지 않은 토마토들을 돌며
                    it.state = 1 // 상태를 '익음'으로 바꿔주고
                    tomorrowRide.offer(it) // 내일 익을 토마토가 들어갈 tomorrowRide Queue에 넣어줌
                }
        }
        todayRide.addAll(tomorrowRide) // 그리고 오늘 익은 토마토 Queue에 넣어주고
        days++ // 날짜 ++
    }
    var isAllRide = true // 토마토가 모두 익었는가
    for (z in 0 until storey) {
        for (y in 0 until vertical) {
            for (x in 0 until horizontal) { // 모든 칸들을 탐색하면서
                if (tomatoBox[z][y][x].state == 0) { // 익지 않은 토마토가 남아있다면
                    isAllRide = false // '토마토가 모두 익었는가?'는 false가 됨 (=모두 익지 않았음)
                    break
                }
            }
            if (isAllRide.not()) {
                break
            }
        }
        if (isAllRide.not()) {
            break
        }
    }
    if (isAllRide.not()) { // 토마토가 모두 익지 않았다면 -1 출력
        println(-1)
    } else { // 모두 익었다면 걸린 기간 출력
        println(days)
    }
}


private fun link(tomato1: Tomato, tomato2: Tomato) { // 두 칸을 상호 연결해주는 함수
    tomato1.linked.add(tomato2)
    tomato2.linked.add(tomato1)
}

data class Tomato( // 토마토가 익었는지 여부, 연결된 토마토의 정보가 들어갈 리스트가 들어갈 data class
    var state: Int,
    val linked: MutableList<Tomato>
)