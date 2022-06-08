import java.util.*

/**
 * https://www.acmicpc.net/problem/11725
 * 트리문제 트리의 부모 찾기 루트가 없는 트리가 주어지고 이 트리의 루트를 항상 1이라고 가정한다.
 * 입력으로 노드의 갯수와 각 연결의 정보가 주어짐
 * 입력을 바탕으로 완성한 트리의 2번 부터 n번까지 각 노드의 부모를 순서대로 출력하면됨 예) 2번노드의 부모, 3번노드의 부모...n번 노드의 부모
 * 노드의 id, 연결된 노드, 부모 노드를 기본생성자로 가진 data class를 만듬
 * 입력대로 연결된 트리를 만들고 각 노드를 돌면서 해당 노드의 부모노드 정보를 입력해준다 (DFS - 재귀함수 사용)
 * 그리고 2번부터 이후 노드들을 돌면서 각각의 부모노드를 출력하는 것으로 풀이함
 */

fun main() = Scanner(System.`in`).use { sc ->
    val nodeCount = sc.nextInt() // 노드의 개수, 1부터 오름차순
    val nodeMap = mutableMapOf<Int, Node>()

    for (i in 1..nodeCount) {
        nodeMap[i] = Node(i, mutableListOf(), null) // 노드의 id에 1부터 순서 대로 넣어줌
    }

    val linkCount = nodeCount - 1 // 문제에서 제시한 연결의 수
    repeat(linkCount) {
        val node1 = nodeMap[sc.nextInt()] // 입력 받은 수를 id로 갖는 node 1
        val node2 = nodeMap[sc.nextInt()] // 입력 받은 수를 id로 갖는 node 2
        if (node1 != null && node2 != null) {
            node1.childrenNodeList.add(node2) // node1의 연결된 노드 리스트에 node2를 넣어줌
            node2.childrenNodeList.add(node1) // node2의 연결된 노드 리스트에 node1을 넣어줌
        }
    }

    val root = nodeMap[1] // 문제에서 제시한 루트
    val parentList = mutableListOf<Int>() // 부모 노드들의 id를 담을 리스트
    if (root != null) { // 루트노드1의 get으로 가져온 값이 null이 아니라면,
        linkParent(root, BooleanArray(nodeCount + 1)) // 루트노드부터 연결된 모든 노드의 부모노드 정보를 넣어줌
        for (i in 2..nodeCount) { // 2번 노드부터 부모 노드가 null이 아니라면 부모 노드id 리스트에 각노드의 부모노드 id를 넣어줌
            nodeMap[i]?.parentNode?.let { parentList.add(it.nodeId) }
        }
    }
    parentList.forEach { println(it) } // 완성된 리스트를 출력함
}

private fun linkParent(
    node: Node,
    visitedNodeId: BooleanArray, // 방문여부를 확인할 BooleanArray 여부확인을 하지 않으면 서로 상호 연결되어있기 때문에 무한하게 서로 탐색함
) {
    visitedNodeId[node.nodeId] = true // 현재 노드 id를 index로 접근, 해당위치의 방문여부를 true로 바꿔줌
    node.childrenNodeList.forEach { linkedNode -> // 현재 노드의 연결된 노드들을 돌면서
        if (visitedNodeId[linkedNode.nodeId].not()) { // 현재 노드에 연결된 노드가 방문한적이 없다면
            linkedNode.parentNode = node // 연결된 노드의 부모노드의 현재노드를 넣어줌
            linkParent(linkedNode, visitedNodeId) // 연결된 노드를 기준으로 재귀함수를 돌면서 모든 노드들의 부모노드 정보를 넣어줌
        }
    }
}

data class Node(
    val nodeId: Int, // 현재 노드의 id
    val childrenNodeList: MutableList<Node>, // 현재 노드와 연결된 노드들의 정보
    var parentNode: Node? // 부모노드
)