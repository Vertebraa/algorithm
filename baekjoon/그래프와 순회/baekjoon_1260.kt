import java.util.LinkedList
import java.util.Queue
import java.util.Scanner

/**
 * https://www.acmicpc.net/problem/1260
 * 그래프와 순회 문제 DFS로 탐색한 결과와 BFS로 탐색한 결과 두가지 케이스를 출력하는 문제
 * 기존에 풀이 했던 대로 data class 내부에 방문 여부를 Boolean으로 지정할 결우
 * 두 함수에서 함께 접근하면서 나중에 불린 함수의 결과가 이상해짐,
 * 그렇기 때문에 함수 작성시 각각 이전 방문 여부를 확인 할 수 있는 set을 만들고 contains 함수를 사용해서 확인함
 *
 * 탐색 과정에서 mutableSet을 만든 이유는 bfsList에서 contains로 바로 검사해도 해당 코드에선 문제가 없지만,
 * list에서의 contains는 탐색하려는 객체와 포함되어 있는 일치하는 객체가 만날때 까지 탐색을 해야한다 (시간 복잡도 O(n))
 * 하지만 hashSet의 경우 객체의 해쉬코드를 기반으로 나누기 연산자를 통해 얻은 index에 저장하기 떄문에 무작위 순서로 저장되더라도,
 * 탐색하려는 객체 역시 해쉬코드를 통해 index 위치로 직접 접근이 가능해서 불필요한 연산을 줄이는 장점이 있어서 사용했음 (시간 복잡도 O(상수))
 */

fun main(): Unit = Scanner(System.`in`).use { sc ->
    val nodes = (1..sc.nextInt()).map { Node(it, mutableListOf()) } // 1부터 입력값까지를 ID로 갖는 data class 리스트를 만듬
    val linkCount = sc.nextInt() // 연결 간선의 갯수
    val startNodeId = sc.nextInt() // 시작하는 정점의 번호

    repeat(linkCount) {
        val front = nodes[sc.nextInt() - 1] // 리스트의 index 이므로 입력받은 정점 - 1 번
        val back = nodes[sc.nextInt() - 1]
        front.linked.add(back) // 입력 받은 두 정점을 서로 연결해줌
        back.linked.add(front)
    }

    nodes.forEach {
        it.linked.sortBy { linkedNode -> linkedNode.nodeId }
    } // 정점의 번호 (id)를 기준으로 오름차순 정렬함, 문제에서 여러 정점이 연결된 경우 작은 숫자부터 탐색하라는 조건이 있었기 때문,

    val startNode = nodes[startNodeId - 1] // 시작정점
    val dfsList = getNodeVisitPathByDfs(startNode)
    println(dfsList.joinToString(separator = " ")) // 리스트의 각 객체를 모아서 문자열로 만들고 separator로 구분함

    val bfsList = getNodeVisitPathByBfs(startNode)
    println(bfsList.joinToString(separator = " ")) // 리스트의 각 객체를 모아서 문자열로 만들고 separator로 구분함
}

private fun getNodeVisitPathByDfs(startNode: Node): List<Int> {
    fun dfs(node: Node, dfsList: MutableList<Int>, visited: MutableSet<Int>) {
        dfsList.add(node.nodeId) // 현재 보고있는 정점의 id를 탐색한 리스트에 넣어줌
        visited.add(node.nodeId) // 탐색여부를 검사하는 set에도 넣어줌
        node.linked.forEach { // 현재 정점에 연결되어 있는 노드를 돌면서
            if (visited.contains(it.nodeId).not()) { // 탐색한적이 있던 정점이 아니라면
                dfs(it, dfsList, visited) // 해당 정점을 시작정점으로 재귀함수를 돌면서 탐색함
            }
        }
    }
    val dfsList = mutableListOf<Int>() // DFS로 탐색한 정점의 id를 저장할 리스트
    val visited = mutableSetOf<Int>() // 이미 탐색한 정점의 id를 저장할 set
    dfs(startNode, dfsList, visited) // 시작 정점과, 탐색한 객체를 저장할 리스트, 탐색 여부 검사용 set을 사용해 탐색 (43번)
    return dfsList // 완성된 탐색 리스트를 리턴
}

private fun getNodeVisitPathByBfs(visitStartNode: Node): List<Int> {
    val bfsList = mutableListOf<Int>() // BFS로 탐색한 정점의 id를 저장할 리스트
    val queue: Queue<Node> = LinkedList()
    val visited = mutableSetOf<Int>() // 이미 탐색한 정점의 id를 저장할 set

    visited.add(visitStartNode.nodeId) // 탐색여부를 검사할 set에 시작정점의 id를 넣어줌
    queue.offer(visitStartNode) // 시작 정점과 연결된 정점의 정보를 Queue에 넣음
    while (queue.isNotEmpty()) {
        val hold = queue.poll()
        bfsList.add(hold.nodeId) // 리스트에 현재 보고있는 정점(Queue의 poll)의 id를 넣어줌
        hold.linked.forEach { // 현재 보고있는 정점에 연결된 정점들을 돌면서
            if (visited.contains(it.nodeId).not()) { // 탐색한적이 있는 정점이 아니라면 (= 정점의 id가 set에 없다면)
                visited.add(it.nodeId) // 탐색 여부를 저장하는 set에 넣어줌
                queue.offer(it)  // 연결된 정점의 정보를 Queue에 넣어줌
            }
        }
    }
    return bfsList // 완성된 탐색 리스트 리턴
}

data class Node(
    val nodeId: Int,
    val linked: MutableList<Node>
)