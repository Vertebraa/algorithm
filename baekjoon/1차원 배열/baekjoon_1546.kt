import java.util.*

/**
 * https://www.acmicpc.net/problem/1546
 * 1차원 배열문제 점수의 평균을 구하는 문제
 * 점수 3개를 입력 받고 최고 점수로 각각의 점수를 나눈 후 100을 곱해 새로운 점수를 만듬 그 후 새로운 점수들의 평균을 구함
 */

fun main(arg: Array<String>) {
    val sc = Scanner(System.`in`)

    val subject = sc.nextInt()
    val scoreList = IntArray(subject)
    var highScore = 0



    for (i in 0 until subject) { // 입력 받은 점수들 중에 최고점을 찾아냄
        scoreList[i] = sc.nextInt()
        if (scoreList[i] > highScore) {
            highScore = scoreList[i]
        }
    }
    var sum: Double = 0.0 // 새로운 점수들의 합
    for (i in 0 until subject) {
        val newScore = ((scoreList[i].toDouble() / highScore.toDouble()) * 100) // 기존 점수들을 /highScore * 100해서 새로운 점수를 만듬
        sum += newScore // 새로운 점수들의 합을 구함
    }
    println((sum / subject)) // 새로운 점수들의 평균을 출력
}

// 첫 째줄에 시험 과목의 갯수 N입력 N <= 1000
// 둘 째줄에 성적이 N개 입력됨 ex) 3과목 20 30 60
// 가장 높은 점수를 M이라고 했을때
// 각 점수를 / M * 100 하고 모두 더함 그 후에 과목갯수로 나눠 평균을 구함
// 하지만 분모가 분자보다 큰경우 값이 0이 나오므로 분자와 분모의 타입을 double로 지정해서 소숫점 값이 나오도록 해야함

// 각 시험 점수가 담길 Array를 만듬
// Array 내에서 가장큰 수 highScore를 찾음
// Array[i]를 각각 / M * 100 하고 저장함
// Array[i] 값을 모두 더함
// 더한 값을 과목의 갯수 N으로 나눈후 출력함
// 예제8번의 경우 소수점 14번째 자리까지 출력 했으므로 타입은 Double로 지정해야 할것 같음