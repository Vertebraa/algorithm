import java.util.LinkedList
import java.util.Queue
import java.util.Scanner

/**
 * https://www.acmicpc.net/problem/2178
 * 그래프와 순회 문제 미로탐색
 * 0과 1로 이뤄진 미로를 입력받아 생성함 1은 갈 수 있는 곳이고 0은 갈 수 없는 곳임
 * 좌표 0,0 에서 m,n 까지 이동할 때 (좌 상단에서 우 하단까지) 가장 짧게 갈 수 있는 루트를 탐색 하는 문제
 * 미로의 모든 칸을 연결하고 해당 칸이 1인 경우에만 이동하면서 목적지에 도착하면 이동 횟수를 출력하는 방식으로 풀이함
 * BFS탐색 방법 사용
 */

fun main() {
    val mazeMap = createMazeMapFromSystem()
    linkAroundMaze(mazeMap)
    val count = calculateMoveCount(mazeMap[0][0], mazeMap.last().last())

    print(count)
}

private fun createMazeMapFromSystem(): Array<List<Maze>> {
    return Scanner(System.`in`).use { sc ->
        val vertical = sc.nextInt() // 미로의 세로 사이즈
        val horizontal = sc.nextInt() // 미로의 가로 사이즈
        Array(vertical) {
            sc.next()
                .map { Character.getNumericValue(it) } // 입력이 구분없이 들어오기 때문에 각자리의 숫자로 리스트를 만듬
                .map { Maze(it, mutableListOf()) } // 위에서 만든 리스트로 data class 리스트를 다시 만들어줌
        }
    }
}

private fun linkAroundMaze(mazeMap: Array<List<Maze>>) { // 미로의 모든 칸을 연결하는 함수
    for (y in mazeMap.indices) {
        for (x in mazeMap[y].indices) {
            val currentLocation = mazeMap[y][x]
            mazeMap[y].getOrNull(x + 1)
                ?.let { right -> link(currentLocation, right) }

            mazeMap.getOrNull(y + 1)?.get(x)
                ?.let { down -> link(currentLocation, down) }
        }
    }
}

private fun calculateMoveCount( // 이동 횟수를 계산 하는 함수
    start: Maze, // 출발위치
    destination: Maze // 도착위치
): Int {
    val visitSet = hashSetOf<Maze>()
    var count = 1 // 첫 번째 위치도 카운트 함
    val routeQueue: Queue<Maze> = LinkedList()
    visitSet.add(start) // 첫 번째 방을 방문여부를 확인 하는 set에 넣어줌
    routeQueue.offer(start) // 첫 번째 방을 Queue에 넣어줌
    while (routeQueue.isNotEmpty()) {
        count++ // 이동횟수 ++
        val nextRouteQueue: Queue<Maze> = LinkedList() // 다음 이동에 방문할 방들이 들어갈 Queue
        while (routeQueue.isNotEmpty()) {
            val currentPosition = routeQueue.poll()
            currentPosition.route // 현재 보고있는 위치와 연결된 방들을 돌면서
                .filter { it.path == 1 && visitSet.contains(it).not() } // 다음 위치 길이고, 방문한 적이 없었다면
                .forEach {
                    visitSet.add(it) // 방문한 적이 있다 (= set에 넣어줌)
                    nextRouteQueue.offer(it) // 다음에 방문할 방에 넣어줌
                    if (it == destination) { // 만약 현재위치가 목적지라면
                        nextRouteQueue.clear() // 다음에 방문할 방을 비워줌 (반복문 조건 제거)
                        routeQueue.clear() // 현재 방문중인 방들도 비워줌 (반복문 조건 제거)
                        return@forEach // 목적지에 도착 했으므로 forEach 종료
                    }
                }
        }
        routeQueue.addAll(nextRouteQueue) // 도착하지 못했다면 다음에 방문할 방들을 현재 방문중인 방 Queue에 넣어줌
    }
    return count // 총 이동 횟수 리턴
}

private fun link(maze1: Maze, maze2: Maze) { // 미로의 현재 이동중인 방과 다음 방을 연결하는 함수
    maze1.route.add(maze2)
    maze2.route.add(maze1)
}

data class Maze( // 길인지 벽인지 여부, 연결된 방들을 data class로 묶어줌
    val path: Int,
    val route: MutableList<Maze>
)