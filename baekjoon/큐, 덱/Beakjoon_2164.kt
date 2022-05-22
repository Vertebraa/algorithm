import java.util.LinkedList
import java.util.Queue
import java.util.Scanner

/**
 * https://www.acmicpc.net/problem/2164
 * 큐, 덱 문제 문제에서 주어지는 연산을 종료한 후 마지막에 남는 카드의 숫자를 출력하는 문제
 * 제일 앞의 카드를 버리고 그다음 카드는 가장 아래로 보낸다. 이과정을 카드가 한장 남을 떄 까지 반복하면 된다.
 * 가장 앞의 카드를 poll()하고 그 다음카드를 offer(poll()) 해줘서 풀이함
 */

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val queue: Queue<Int> = LinkedList()

    for (i in 1..n) {
        queue.offer(i) // 큐에 1부터 n 까지의 숫자를 넣어줌
    }
    while (queue.size > 1) { // 카드가 한장 남을때 까지 반복
        queue.poll() // 맨앞 카드를 poll
        queue.offer(queue.poll()) // 그다음 카드를 poll하고 그 카드를 기존 큐에 offer
    }
    println(queue.poll())
}