import java.util.*
import kotlin.math.max

/**
 * https://www.acmicpc.net/problem/1157
 * 문자열 문제 가장 많이 사용된 알파벳 찾기
 * 입력 받은 문자열 내에서 가장많이 사용된 알파벳을 대문자로 출력 하는 문제 (여러가일경우 "?"출력)
 * 문자열을 .lowerCase 로 소문자화 시킨 후에 charArray로 만듬
 * 어떤 알파벳이 가장 많이 쓰였는지 찾기 위해 size 26의 IntArray를 만들고
 * (ascii - 97)로 문자열내 각 알파벳이 몇번씩 쓰였는지 확인함 (InArray의 각 자리에 1씩 더해주는 방식)
 * 이후 가장 많이 사용된 알파벳의 사용횟수를 찾고 저장함
 * 가장 높은 사용횟수가 1개 이상일 경우 ? 출력
 * 1개일 경우 그 i(알파벳 순서) 에 65를 더한 후 char로 타입을 변경해 대문자 알파벳으로 출력
 */

fun main(arg: Array<String>) {
    val sc = Scanner(System.`in`)
    val inPutText = sc.next().lowercase(Locale.getDefault()).toCharArray() // 문자열을 소문자로 받은 후에 array화 시킴
    val alphabetCount = IntArray(26) // 0번쨰부터 25번 (각 자릿수가 알파벳 순서를 의미)

    for (i in 0 until inPutText.size) {
        val alphabetIndex = inPutText[i].code - 97
        alphabetCount[alphabetIndex]++ // 입력받은 문자열을 반복하며 (a의 경우 아스키 코드 97이므로 0번째) 각 알파벳이 몇번 쓰였나 확인
    }
    var mostUsed = 0
    for (i in alphabetCount.indices) {
        mostUsed = max(alphabetCount[i],mostUsed) // alphabetCounter의 각 index중 가장 높은 값(사용횟수가 높은)을 찾음
    }
    var usedCount = 0
    for (i in alphabetCount.indices) {
        if (alphabetCount[i] == mostUsed) { // 많이 사용된 알파벳이 1개 이상인지를 확인함
            usedCount++ // 예를 들어 가장 많이 사용된 알파벳이 a와 b라면 usedCount = 2가 됨
        }
        if (usedCount > 1) { // 1개 초과 라면 반복 종료 (무조건 답은 ? 가 되므로)
            break
        }
    }
    if (usedCount > 1) {
        println("?")
    } else { // =가장 많이 사용된 알파벳이 한개 이하라면
        for (i in alphabetCount.indices) {
            if (alphabetCount[i] == mostUsed) { // 가장 사용횟수가 많은 index번호 (= 알파벳 순서) 를 찾고
                println((i + 65).toChar()) // ascii + 65 = 대문자 알파벳 출력
            }
        }
    }
}