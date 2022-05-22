import java.util.LinkedList
import java.util.Queue
import java.util.Scanner

/**
 * https://www.acmicpc.net/problem/1966
 * 큐, 덱 문제 출력 중요도에 따른 프린터 인쇄 소프트웨어를 만들기
 * 예를 들어 큐에 4개의 문서(A B C D)가 있고, 중요도가 2 1 4 3 라면 C를 인쇄하고, 다음으로 D를 인쇄하고 A, B를 인쇄하게 된다.
 * 큐에 있는 문서의 수와 중요도가 주어 졌을떄 M번째 문서가 몇번째로 출력되는지를 출력하는 문제
 * 몇번째 문서인지(index)를 key로 출력 중요도를 priority로 data class를 만들어서 풀이함
 */

fun main() {
    Scanner(System.`in`).use { sc ->

        val testCase = sc.nextInt()

        repeat(testCase) {
            val taskSize = sc.nextInt()
            val targetTaskKey = sc.nextInt() // 몇번째 문서의 출력순서를 찾을 것인가를 key로 정함
            val taskQueue: Queue<Task> = LinkedList()
            for (i in 0 until taskSize) {
                taskQueue.offer(Task(i, sc.nextInt())) // index번호를 key로 문서를 priority로 큐에 넣어줌
            }
            val priorityQueue: Queue<Int> = LinkedList()
            taskQueue
                .sortedByDescending { it.priority } // 문서 중요도를 기준으로 내림차순 정렬함
                .forEach { priorityQueue.offer(it.priority) } // 각 출력물의 중요도를 내림차순 정렬한 후 내로운 큐에 넣어줌

            var printCount = 0
            while (true) {
                val currentPriority = priorityQueue.peek() // 내림차순된 큐의 peek
                val currentTask = taskQueue.peek() // 최초 입력한(= 중요도로 정렬하지 않은) 큐의 peek

                if (currentPriority == currentTask.priority) { // 두 큐의 peek이 같다면
                    priorityQueue.poll()
                    taskQueue.poll()
                    printCount++ // 각각의 큐에서 일치하는 중요도의 문서를 poll하고 프린트 횟수를 ++
                    if (currentTask.key == targetTaskKey) { // 정렬되지 않은 큐의 key(몇번째?)가 찾고자 하는 문서(=입력한 index)와 같다면
                        println(printCount) // 몇번째 출력물인지 출력
                        break
                    }
                } else {
                    taskQueue.offer(taskQueue.poll()) // 위의 조건이 만족 되지 않은 경우 정렬되지 않은 큐를 offer(poll())
                }
            }
        }
    }
}

data class Task(
    val key: Int,
    val priority: Int
)