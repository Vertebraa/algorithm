import java.util.Scanner
import java.util.Stack

/**
 * https://www.acmicpc.net/problem/10773
 * 스택 문제 0이 입력되면 앞서 입력된 숫자를 제거하는 문제
 * 마지막 반복 종료 후 스택에 남아있는 수의 합을 출력하면 된다
 * remove() 와 .peek을 사용해서 먼저 풀이 했는데 remove는 스택과 다르게 앞쪽 index부터 제거 해서 틀렸었음
 * pop으로 마지막 입력 값을 remove + get 하거나 removeAt(stack.size - 1)로 대체 풀이가 가능하다
 */

fun main() {
    val sc = Scanner(System.`in`)
    val k = sc.nextInt()
    val account = Stack<Int>() // 재민이가 입력하는 장부(스택)

    for (i in 0 until k) {
        val deposit = sc.nextInt() // 금액을 입력한다
        if (deposit == 0) { // 만약 앞서 입력한 금액이 잘못된 수라면 0을 입력
            account.pop() // 앞서 입력된 수를 pop (remove)
        }else{
            account.push(deposit) // 그게 아니면 그대로 스택에 저장
        }
    }
    println(account.sum()) // 합계 출력
}