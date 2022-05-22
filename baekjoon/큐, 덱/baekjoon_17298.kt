import java.util.Deque
import java.util.LinkedList
import java.util.Scanner

/**
 * https://www.acmicpc.net/problem/18258
 * 큐, 덱 문제 정수를 저장하는 큐를 구현하고 입력으로 주어지는 명령을 처리하도록 하는 문제
 * 기존에 사용하는 명령어와 다른 종류의 명령어가 제법 많이 등장함
 * 큐의 입 출력 방식은 FIFO(선입선출) 방식이란걸 이해함
 */

fun main() {
    val sc = Scanner(System.`in`)
    val queue: Deque<Int> = LinkedList()
    val n = sc.nextInt()
    val sb = StringBuilder()

    for (i in 0 until n) {
        when (sc.next()) {
            "push" -> queue.offer(sc.nextInt()) // 다음에 오는 문자열이 push 인경우 queue에 다음 숫자를 넣어줌
            "pop" -> sb.appendWithLn(if (queue.isEmpty()) -1 else queue.removeFirst()) // 큐는 pop했을 시 먼저 들어간게 먼저 나옴 removeFirst 는 스택의 pop과 같은 기능
            "size" -> sb.appendWithLn(queue.size) // 큐의 size를 스티링 빌더에 넣어줌
            "empty" -> sb.appendWithLn(if (queue.isEmpty()) 1 else 0) // 큐가 비어있다면 0 아니면 1 을 스트링 빌더에 넣어줌
            "front" -> sb.appendWithLn(if (queue.isEmpty()) -1 else queue.first) // 큐가 비어있다면 -1 큐의 가장 앞의 수를 스트링 빌더에 넣어줌
            "back" -> sb.appendWithLn(if (queue.isEmpty()) -1 else queue.last) // 큐가 비어있다면 -1 큐의 가장 뒤의 수를 스트링 빌더에 넣어줌
        }
    }
    println(sb) // 스트링 빌더 출력
}

private fun StringBuilder.appendWithLn(any: Any): StringBuilder {
    return append(any).append('\n') // 개행하여 append하는 확장함수
}