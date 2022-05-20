import java.util.*

/**
 * https://www.acmicpc.net/problem/1874
 * 스택 문제 1부터 n까지의 오름차순 수열을 입력받은 수열로 만드는데 필요한 연산을 출력 시키는 문제
 * 스택에 오름차순 수열을 넣었다가 빼면서 push 해야 할땐 '+' pop해야 할때는 '-'를 개행하여 출력한다
 * '-'를 출력 시킬때 비어있는 스택에 peek()을 하면 에러가 나기때문에 조건에 스택이 비어있지 않다면을 체크해줘야함
 * 또 index번호를 한개씩 늘릴때 사이즈보다 커지면 안되기 때문에 lastIndex를 넘지 않도록 해야함
 */

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val stack = Stack<Int>()
    val array = IntArray(n) { sc.nextInt() } // size n의 수열을 입력받음


    var arrayCurrentIndex = 0
    val sb = StringBuilder()
    for (i in 1..n) {
        stack.push(i) // 1부터 n까지 순차적으로 (오름차순) 스택에 넣어줌
        sb.append("+\n") // push 할때 마다 '+'을 스트링 빌더에 넣어줌

        while (stack.isNotEmpty() && arrayCurrentIndex <= array.lastIndex && stack.peek() == array[arrayCurrentIndex]) {
            // 스택이 비어있지 않고, 스택의 peek이 array의 arrayCurrentIndex의 값과 같다면 pop
            stack.pop()
            sb.append("-\n") // pop할 때 마다 '-'를 스트링 빌더에 넣어줌
            arrayCurrentIndex++ // 다음 index로 넘어감(++)
        }
    }
    if (stack.isEmpty()) { // 스택이 비어있다면 (= 입력 받은 수열로 바꿀 수 있는 경우)
        println(sb) // + 와 - 출력
    } else {
        println("NO") // 수열을 바꿀 수 없다면 NO 출력
    }
}
