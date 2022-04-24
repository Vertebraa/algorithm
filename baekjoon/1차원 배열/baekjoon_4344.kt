import java.util.*

/**
 * https://www.acmicpc.net/problem/4344
 * 1차원 배열문제 평균을 넘는(초과) 학생의 비율을 출력하는 문제
 * 문제에서 제시한 소수점 셋째 자리까지 출력하는 방법을 몰라서 구글링함
 * format이란걸 처음 써봤는데 아직 이해가 잘 안됨 문법 공부 더 필요함
 * 반복문 내에서 반복문을 여러번 더 사용하는게 어려웠음
 */

fun main(arg: Array<String>) {
    val sc = Scanner(System.`in`)
    val testCase = sc.nextInt()

    for (i in 0 until testCase) { // 테스트 케이스의 범위를 제한
        val studentSize = sc.nextInt() // 학생을 수를 입력
        var totalScore = 0 // 평균을 구하기 위해 총 점수를 mutable 변수로 지정
        var overAverageStudents : Double = 0.0 // 평균을 초과하는 학생의 수 mutable double 타입 0으로 초기화
        val scores = IntArray(studentSize)

        for (j in 0 until studentSize) {
            scores[j] = sc.nextInt() // 학생들의 점수를 각각 입력
            totalScore += scores[j] // 각각 점수들을 더해 총점수를 구함
        }
        for (k in scores) { // score에 입력된 각 학생들의 점수
            if (k > totalScore/studentSize) { // 평균 ( 총점수 / 학생수) 을 넘을경우
                overAverageStudents ++ // 평균초과 학생수 + 1
            }
        }

    println(String.format("%.3f%%",overAverageStudents/studentSize * 100.000)) // 소수점 셋째까지 출력하는 방법인데 아직 이해를 못함 구글링
    }
}



