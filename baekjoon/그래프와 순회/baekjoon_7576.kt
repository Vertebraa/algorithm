import java.util.LinkedList
import java.util.Queue
import java.util.Scanner

/**
 * https://www.acmicpc.net/problem/7576
 * 그래프와 순회 문제 토마토 상자안에 있는 토마도가 모두 익는데까지 걸리는 시간을 출력하는문제
 * M*N 사이즈의 토마토 상자의 각 칸을 0, 1, -1 로 표기함
 * 0은 익지 않은 토마토 1은 익은 토마토 -1은 빈칸을 의미함
 * 익은 토마토의 상하좌우 4방향에 익지 않은 토마토가 있다면 하루가 지난 후 익은 상태가됨
 * 연결되지 않은 토마토는 익지 않는다고 할 때 상자에 토마토가 모두 익는데 걸리는 시간을 출력하면 된다
 * 만약 빈칸으로 둘려 쌓이는 등 익지않은 토마토가 존재하는 경우에는 -1을 출력함
 * BFS 탐색방법으로 풀이함
 */

fun main() = Scanner(System.`in`).use { sc ->
    val horizontalSize = sc.nextInt() // 상자의 가로사이즈
    val verticalSize = sc.nextInt() // 상자의 세로사이즈
    val tomatoBox = Array(verticalSize) {
        Array(horizontalSize) {
            Tomato(sc.nextInt(), mutableListOf()) // 토마토의 익었는지 여부, 연결될 토마토가 들어갈 리스트
        }
    }

    for (y in 0 until verticalSize) {
        for (x in 0 until horizontalSize) {
            val currentTomato = tomatoBox[y][x]

            tomatoBox[y]
                .getOrNull(x + 1) // 토마토 상자의 [y],[x + 1]위치가 null이 아니라면 (= x + 1 < horizonSize)
                ?.let { rightTomato -> link(currentTomato, rightTomato) } // 오른 쪽에 있는 토마토와 현재 토마토를 상호 연결해줌

            tomatoBox
                .getOrNull(y + 1)?.get(x) // 토마토 상자의 [y + 1][x]위치가 null이 아니라면 (= y + 1 < verticalSize)
                ?.let { bottomTomato -> link(currentTomato, bottomTomato) } // 아래쪽에 있는 토마토와 현재 토마토를 상호 연결해줌
        }
    }

    val todayTomatoQueue: Queue<Tomato> = LinkedList()
    for (y in 0 until verticalSize) {
        for (x in 0 until horizontalSize) {
            if (tomatoBox[y][x].state == 1) {
                todayTomatoQueue.offer(tomatoBox[y][x])
            } // queue를 만들고 익은 토마토를 전부 넣어줌
        }
    }

    var days = -1
    while (todayTomatoQueue.isNotEmpty()) { // 오늘 익은 토마토를 넣은 queue가 비어있지 않다면
        val tomorrowTomatoQueue: Queue<Tomato> = LinkedList() // 내일 익을 토마토를 넣을 queue를 만듬
        while (todayTomatoQueue.isNotEmpty()) { // 오늘 익은 토마토를 넣은 queue가 비어있지 않다면
            val hold = todayTomatoQueue.poll()
            hold.linked // 오늘 익은 토마토가 담긴 queue의 poll과 연결된 주변 토마토를 돌면서
                .filter { it.state == 0 } // 익지 않은 토마토만 필터링
                .forEach { // 각 연결된 익지않은 토마토들을
                    it.state = 1 // 상태를 '익음'으로 바꿔줌
                    tomorrowTomatoQueue.offer(it) // 내일 익을 토마토 queue에 넣어줌
                }
        }
        todayTomatoQueue.addAll(tomorrowTomatoQueue) // 내일 익을 토마토 queue에 저장된 것들을 오늘 익어있는 토마토 queue에 넣어줌
        days++ // 날짜 ++
    } // while문을 두개 사용해야 상자에 익은 토마토가 여러개 들어있는 경우에도 날짜 카운트가 여러번 올라가는걸 방지 할 수 있음

    var isAllRipe = true // 토마토가 전부 익었는가?
    for (y in 0 until verticalSize) {
        for (x in 0 until horizontalSize) {
            if (tomatoBox[y][x].state == 0) { // 익지 않은게 있다면
                isAllRipe = false // 모두익지 않았음
                break
            }
        }
        if (isAllRipe.not()) {
            break
        }
    }

    if (isAllRipe.not()) { // 익지 않은 토마토가 존재하면 -1 출력
        println(-1)
    } else {
        println(days) // 모두익었다면 걸린 날짜 출력
    }
}

private fun link(tomato1: Tomato, tomato2: Tomato) {
    tomato1.linked.add(tomato2)
    tomato2.linked.add(tomato1)
}

data class Tomato(
    var state: Int,
    val linked: MutableList<Tomato>
)