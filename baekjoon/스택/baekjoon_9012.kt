import java.io.*
import java.util.Stack

/**
 * https://www.acmicpc.net/problem/9012
 * 스택문제 VPS 여부 판별하는 문제
 * 괄호로 주어진 문자열이 입력되고 해당 문자열의 괄호가 알맞게 열고 닫혔다면 이를 VPS 문자열이라고 한다.
 * 문자열을 입력받고 최초 )가 오는 경우는 무조건 false 아닌경우엔
 * 여는 괄호를 stack에 넣어주고 )가 올때 이전에 넣어둔 (를 pop하는 방법을 사용함
 * 마지막 반복후 stack의 size가 0 이라면 모두 알맞게 짝지어 진 것 이므로 YES 아니라면 NO를 출력함
 */

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val testCase = br.readLine().toInt()


    repeat(testCase) { // testCase 만큼 반복
        val string = br.readLine() // 괄로로 이뤄진 문자열을 입력받음

        println(if (string.isVps()) "YES" else "NO") // 입력한 문자열이 isVps면 YES 아니면 NO 출력
    }
}

fun String.isVps(): Boolean {
    val stack = Stack<Char>() // VPS 여부를 판별하기 위해 빈 stack을 만듬

    for (i in this.indices) { // 입력받은 문자열의 길이 만큼 반복
        when {
            this[i] == '(' -> stack.push('(') // this가 '(' 라면 스택에 '(' 를 넣어줌
            stack.isEmpty() -> return false // '('가 아니면서 (= ')') 스택이 현재 비어있다면 false return
            else -> stack.pop() // 스택이 비어있지 않고 ')'가 왔다면 이전에 push된 '('를 pop
        }
    }
    return stack.isEmpty() // 반복 종료 후 스택이 비어있다면 (= 여는 괄호과 닫는 괄호가 매칭이 되는 경우) isVps = true
}
