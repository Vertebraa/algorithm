import java.util.*

/**
 * https://www.acmicpc.net/problem/10828
 * 스택 문제 균형잡힌 세상. 입력된 문자열 안에 있는 괄호가 올바르게 열고 닫아 졌는지 확인하는 문제
 * 올바르게 열고 닫혔다면 yes 아니라면 no를 출력한다
 * 입력의 종료 조건은 "."
 * 처음에 오는 괄호를 먼저 stack에 push하고 다음에 오는 닫는 괄호가 push된 괄호와 매칭되는지
 * 여부를 확인하기 위해 peek() 사용해 확인해줌 매칭된다면 pop()으로 스택을 비워나감
 * 처음에 오는 괄호가 닫는 괄호이거나 마지막 반복후 stack이 비어있지 않다면 false
 * 모두 알맞게 매칭되어 pop()되었다면 (=스택이 비었다면) true
 */

fun main() {
    while (true) {
        val stack = Stack<Char>()
        val string = readLine().toString()
        if (string == ".") { // 입력 종료 조건
            break
        }
        var isBalanced = true
        for (element in string) {
            if (element == '(' || element == '[') {
                stack.push(element) // 문자열에서 처음만난 여는 괄호를 push
            } else if (element == ')' && stack.isNotEmpty() && stack.peek() == '(') {
                stack.pop() // 스택이 비어있지 않고 스택의 괄호가 '('이고 다음에 오는 괄호가 ')'라면 pop
            } else if (element == ']' && stack.isNotEmpty() && stack.peek() == '[') {
                stack.pop() // 스택이 비어있지 않고 스택의 괄호가 '['이고 다음에 오는 괄호가 ']'라면 pop
            } else if (element == ')' || element == ']') {
                isBalanced = false // 첫 괄호가 닫는 괄호라면 자동으로 false (반복문 탈출후 no)
                break
            }
        }
        if (stack.isNotEmpty()) {
            isBalanced = false // 스택이 비어있지 않다(= 매칭되지 않은 괄호가 있다) false
        }
        println(if (isBalanced) "yes" else "no")
    }
}