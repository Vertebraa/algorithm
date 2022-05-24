import java.util.Deque
import java.util.LinkedList
import java.util.Scanner

/**
 * https://www.acmicpc.net/problem/10866
 * 큐, 덱 문제 덱을 구현하고 입력받은 명령을 처리하기
 * 이전 스택 구현 문제와 동일하게 풀이함
 */
fun main() {Scanner(System.`in`).use { sc ->
    val deque: Deque<Int> = LinkedList()
    val n = sc.nextInt()
    val sb = StringBuilder()

    for (i in 0 until n) {
        when(sc.next()) {
            "push_front" -> deque.offerFirst(sc.nextInt())
            "push_back" -> deque.offerLast(sc.nextInt())
            "pop_front" -> sb.appendWithLn(if (deque.isEmpty()) -1 else deque.removeFirst())
            "pop_back" -> sb.appendWithLn(if (deque.isEmpty()) -1 else deque.removeLast())
            "size" -> sb.appendWithLn(deque.size)
            "empty" -> sb.appendWithLn(if (deque.isEmpty()) 1 else 0)
            "front" -> sb.appendWithLn(if (deque.isEmpty()) -1 else deque.first)
            "back" -> sb.appendWithLn(if (deque.isEmpty()) -1 else deque.last)
        }
    }
    print(sb)
}
}

private fun StringBuilder.appendWithLn(any: Any): StringBuilder {
    return append(any).append('\n')
}