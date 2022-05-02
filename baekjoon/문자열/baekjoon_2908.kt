import java.util.*
import kotlin.math.max

/**
 * https://www.acmicpc.net/problem/2908
 * 문자열 문제 두 수를 입력 받고 각 숫자를 뒤집는다 이후 더 큰 수를 찾는 문제
 * 예를 들어 123 456 이면 321 654가 됨 더 큰 수는 654
 * 숫자를 뒤집는 함수를 만들어서 풀이함
 */

fun main(arg: Array<String>) {
    val sc = Scanner(System.`in`)
    val num1 = sc.nextInt() // 숫자 1을 입력받음
    val num2 = sc.nextInt() // 숫자 2를 입력받음
    val reversedNum1 = reverseNumber(num1)
    val reversedNum2 = reverse(num2)

    println(max(reversedNum1, reversedNum2))
}

private fun reverseNumber(number: Int): Int {
    val numberArray = number.toString().toCharArray() // 입력 받은 숫자를 charArray로 만듬
    val reverseArray = CharArray(numberArray.size) // 뒤집은 숫자를 넣어줄 빈 array를 만듬

    for (i in numberArray.indices) {
        reverseArray[i] = numberArray[numberArray.lastIndex - i]
    } // 예를 들어 3자리 수일때 0번째는 (2-0)번째 1번째는 (2-1)번째 2번째는 (2-2)번째 -> 뒤집은 숫자를 위에 만든 reverseArray에 넣어줌
    return String(reverseArray).toInt() // reverseArray를 int타입으로 리턴
}

private fun reverse(number: Int): Int {
    val arrayNumber = number.toString().toCharArray()

    for (i in 0 until arrayNumber.size / 2) { // 절반만 돌면서 자리를 바꾸는 방법의 함수 (반대위치의 수와 swap만 하면 되니까)
        val keep = arrayNumber[i] // index값이 바뀌면서 초기화 되기 때문에 초기화 전의 값을 변수로 저장함
        val swapIndex = arrayNumber.lastIndex - i // i와 바뀔 index번호를 변수화

        arrayNumber[i] = arrayNumber[swapIndex] // 3자리 수의 경우 (i가 0일때) 0번 째는 (2-0)번째 수
        arrayNumber[swapIndex] = keep // 2번째 수는 (i가 0일때) 0번째(변수로 저장해둔) 숫자가 됨
    }
    return String(arrayNumber).toInt() // array를 뒤집어서 재정렬한후 int타입으로 리턴
}
