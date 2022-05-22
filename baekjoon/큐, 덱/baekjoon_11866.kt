import java.util.LinkedList
import java.util.Queue
import java.util.Scanner

/**
 * https://www.acmicpc.net/problem/11866
 * 큐, 덱 문제 요세푸스 순열을 구하는 문제
 * 요세푸스 수열을 N명의 사람이 원형으로 앉아 있다고 할 때 K번째 사람이 자리에서 일어난다
 * 맨 마지막사람이 일어날 때까지 반복한다. 이 떄 원에서 사람들이 일어난 순서를 (N,K) 요세푸스 순열이라고 함
 * 예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.
 * 원형으로 앉아있다는건 마지막 사람이후 첫번째로 돌아온다는 말이므로
 * k-1 번째 사람까지 큐의 뒤로 보내고 k번째 사람을 새로운 큐에 넣어주는 방식으로 풀이함
 */

fun main() {
    Scanner(System.`in`).use { sc ->
        val n = sc.nextInt()
        val k = sc.nextInt()
        val queue: Queue<Int> = LinkedList()
        val answerQueue: Queue<Int> = LinkedList()

        val sb = StringBuilder()
        for (i in 1..n) {
            queue.offer(i) // n명의 사람을 순서대로 큐에 넣어줌
        }
        while (queue.size > 1) { // 남은 사람이 한명이 될 때 까지
            for (i in 0 until k - 1) {
                queue.offer(queue.poll()) // k-1번 까지 큐에 offer(poll()) 해줌 (원형으로 앉아 있다는것을 구현)
            }
            answerQueue.offer(queue.poll()) // k번째 사람은 요세푸스 순열이 되는 새로운 큐에 offer
        }
        answerQueue.offer(queue.poll()) // 마지막 사람을 새로운 큐에 offer
        sb.append('<')
        while (answerQueue.isNotEmpty()) { // 새로운 큐가 비어있지 않을 때 까지만
            sb.append(answerQueue.poll()) // 스트링 빌더에 순서대로 poll해줌
            if (answerQueue.isNotEmpty()) { // 새로운 큐가 비어있지 않다면
                sb.append(", ") // poll된 숫자 사이에 쉼표와 공백을 같이 넣어줌
            }
//            if (answerQueue.size == 1) {
//                sb.append(answerQueue.poll())
//            } else {
//                sb.append("${answerQueue.poll()}, ")
//            }
        }
        sb.append('>')
        print(sb)
    }
}