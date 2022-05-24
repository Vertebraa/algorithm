import java.util.Deque
import java.util.LinkedList
import java.util.Scanner

/**
 * https://www.acmicpc.net/problem/1021
 * 큐, 덱 문제 가장 앞에있는 수만 뽑아낼 수 있을때 1 부터 N 까지의 수열에서
 * 다음 줄에 입력 받은 수를 모두 뽑아 내기 위해 필요한 최소 이동 횟수를 구하는 문제
 * 이동은 가장 왼쪽 수를 꺼내 맨 뒤로 넣거나, 가장 오른쪽 수를 꺼내 맨 앞에 넣어주는 두가지 이동만 가능
 */

fun main() {
    Scanner(System.`in`).use { sc ->
        val n = sc.nextInt()
        val obtainNumber = sc.nextInt()
        val deque: Deque<Int> = LinkedList()

        for (i in 1..n) {
            deque.offer(i) // 덱에 1부터 n까지 숫자를 넣어줌
        }
        var count = 0
        repeat(obtainNumber) { // 찾아야하는 수의 갯수 만큼 반복
            val target = sc.nextInt()
            if (deque.peekFirst() != target) { // 첫번째 수가 뽑아야 하는 수와 다르다면
                val targetIndex = deque.indexOfFirst { it == target } // 찾아야 하는 수가 몇번째에 있는지(=index)를 찾음

                if (targetIndex <= (deque.size - 1) / 2) { // 해당숫자가 남은 덱의 사이즈 절번보다 앞에 있다면 (좌로 이동)
                    while (deque.peekFirst() != target) { // 뽑아 낼 수 있는 위치(= peek)와 같지 않은 동안
                        deque.offerLast(deque.pollFirst()) // 덱의 가장 앞의 수를 꺼내 맨뒤로 넣어줌
                        count++ // 이동 횟수 ++
                    }
                } else { // 해당 숫자가 절반 보다 뒤에 있다면
                    while (deque.peekFirst() != target) { // 뽑아 낼 수 있는 위치(= peek)와 같지 않은 동안 (우로 이동)
                        deque.offerFirst(deque.pollLast()) // 덱의 가장 뒤의 수를 꺼내 맨앞에 넣어줌
                        count++ // 이동횟수 ++
                    }
                }
            }
            deque.pollFirst() // 첫번째 수가 뽑아야 하는 수와 같다면 카운트에 영향을 주지 않고 poll
        }
        println(count) // 총 카운트 횟수 출력
    }
}
//        var index = 0
//        var findIndex = -1
//        val tempDeque: Deque<Int> = LinkedList(deque)
//        while (tempDeque.isNotEmpty()) {
//            if (tempDeque.pollFirst() == target) {
//                findIndex = index
//                break
//            } else {
//                index++
//            }