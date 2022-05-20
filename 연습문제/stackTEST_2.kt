import java.util.Stack

/**
 * 스택 구현 연습 NODE사용
 */

fun main() {
    val stack = HyunStack<String>()

    for (i in 1..10) {
        stack.push(i.toString())
    }
    while (!stack.isEmpty()) {
        println(stack.pop())
    }
    // 작동 테스트
}


class HyunStack<T> {

    private var top: Node<T>? = null

    fun push(value: T) {
        val newTop = Node(value, top) // value에 입력값을 넣어주고 top을 bottom으로 지정한 새로운 NODE를 만듬
        top = newTop // 새롭게 만든 노드를 top으로 지정함
    }

    fun pop(): T {
        val topValue = peek() // peek()을 통해 가져온 데이터를 변수화 시켜줌
        top = top?.bottom // top의 bottom을 top으로 지정함
        return topValue // 변수화 시킨 peek() 데이터를 리턴
    }

    fun peek(): T {
        return top?.value ?: throw Exception("stack is empty") // 현재 top의 value를 리턴
    }

    fun isEmpty(): Boolean {
        return top == null // top이 null인 경우(= push가 없거나 모두 pop된 경우) isEmpty
    }

    private data class Node<T>(
        val value: T,
        val bottom: Node<T>?
    )
}