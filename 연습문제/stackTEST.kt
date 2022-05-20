import kotlin.math.E

/**
 * 스택 구현 연습 Array 사용
 * arrayList의 동작 원리 기반
 */

fun main() {
    val stack = HyunjinStack()

    for (i in 0..10)
        stack.push(i)

    for (i in 0..10) {
        stack.pop()
    }
    // 작동 테스트
}


class HyunjinStack(size: Int) { // size를 지정할 수 있는 생성자를 정의한다

    constructor() : this(DEFAULT_STACK_MINIMUM_SIZE) // size를 지정하지 않아도 되는 생성자를 정의한다 이 경우 DEFAULT_STACK_MINIMUM_SIZE를 사용한다

    companion object {
        private const val DEFAULT_STACK_MINIMUM_SIZE = 2 // DEFAULT_STACK_MINIMUM_SIZE는 상수화 시켜놓는다
    }

    private val stackMinimumSize = size // 생성자로 전달받은 size를 최소 사이즈로 지정한다
    private var stack = IntArray(stackMinimumSize) // 스택을 array로 가정함
    private var currentIndex = -1

    fun push(value: Int) {
        currentIndex++
        stack[currentIndex] = value // 입력받은 value를 stack의 현재 index에 set한다

        if (currentIndex == stack.lastIndex) { // 현재 index와 stack의 마지막 index가 같은경우 (array가 꽉찬 경우)
            val newStack = IntArray(stack.size * 2) // 기존 array의 2배 size의 새로운 array를 만듬
            for (i in stack.indices) {
                newStack[i] = stack[i] // 기존 array에 있던 각 데이터를 새로운 array에 set함
            }
            stack = newStack // 기존 array를 새로운 array로 교체
        }
    }

    fun pop(): Int {
        val top = peek() // peek()을 통해 가져온 데이터를 가지고 있음
        currentIndex--

        if (stack.size > stackMinimumSize) { // 최소 size보다 stack의 size가 클 경우
            val halfSize = stack.size / 2
            if (currentIndex < halfSize) { // 스택 size의 절반 보다 현재 index가 작을 때 (stack이 절반 미만으로 채워졌을때)
                val newStack = IntArray(halfSize + 1) // 기존 array size의 절반 + 1 size의 새로운 array를 만듬 (+ 1하지 않으면 곧 바로 꽉찬상태가 될 수 있음)
                for (i in newStack.indices) {
                    newStack[i] = stack[i] // 기존 array의 데이터를 새로운 array에 set함
                }
                stack = newStack // 기존 array와 새로운 array를 교체
            }
        }
        return top // peek()으로 가져온 데이터를 리턴
    }

    fun peek(): Int {
        return stack.get(stack[currentIndex]) // 스택의 현재 index의 대응하는 데이터를 get함
    }

    fun isEmpty(): Boolean {
        return currentIndex < 0 // index가 0보다 작으면 (최초 -1 이므로 빈 상태를 의미함) isEmpty
    }
}
