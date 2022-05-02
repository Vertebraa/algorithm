import java.util.*

/**
 * https://www.acmicpc.net/problem/5622
 * 문자열 문제 전화기 다이얼에 매칭되는 알파벳으로 전화번호를 알아내고
 * 다이얼을 돌리는데 걸리는 시간을 출력 시키는 문제
 * 다른 방법을 찾아 보려고 했는데 7번과 9번이 알파벳을 4개씩 가지고 있어서 일일히 매칭시킴
 * 대문자만 입력된다는 조건이 있어서 ascii 코드로 바꿔서 각 알파벳을 array에 숫자로 넣어줌
 * 이후 각 숫자를 다이얼하는데 걸리는 시간을 모두 더해서 풀이함
 */

fun main(arg: Array<String>) {
    val sc = Scanner(System.`in`)
    val inputTexts = sc.next().toString().toCharArray() // 대문자 알파벳으로 이뤄진 문자열을 받고 charArray화 함
    val actualNumber = IntArray(inputTexts.size) // 치환한 숫자가 들어갈 빈 array를 만듬

    for (i in 0 until inputTexts.size) { // 숫자 1엔 대응되는 알파벳이 없으므로 제외
        if (inputTexts[i].code in 65..67) {
            actualNumber[i] = 2
        } else if (inputTexts[i].code in 68..70) {
            actualNumber[i] = 3
        } else if (inputTexts[i].code in 71..73) {
            actualNumber[i] = 4
        } else if (inputTexts[i].code in 74..76) {
            actualNumber[i] = 5
        } else if (inputTexts[i].code in 77..79) {
            actualNumber[i] = 6
        } else if (inputTexts[i].code in 80..83) {
            actualNumber[i] = 7
        } else if (inputTexts[i].code in 84..86) {
            actualNumber[i] = 8
        } else {
            actualNumber[i] = 9
        }
    }
    var sum = 0
    for (i in 0 until actualNumber.size) { // 알파벳을 숫자로 치환한 후 각 숫자를 다이얼할때 걸리는 시간을 더함
        sum += (actualNumber[i]+1)
    }
    println(sum)
}