/**
 * 숫자야구
 * 첫 번째 줄에 세자리 숫자를 입력 받음 ex) 456
 * 두 번째 줄에 찔러볼 수 있는 횟수를 정함 (N번 안에 맞춰야함)
 * 숫자 야구룰 : 가진 숫자와 찔러본 숫자가 배열의 자리 까지 일치하면 스트라이크 배열과 상관 없이 숫자만 맞으면 볼 일치하지 않으면 아웃
 * ex) 456일때 123을 찔러보면 3아웃 423을 찔러보면 1스트라이크 2아웃 465를 찔러보면 1스트라이크 2볼
 * 입,출력 예시
 * 456
 * 1
 * 452 2스트라이크 0볼 1아웃
 * 만약에 지정 횟수 안에 혹은 마지막에 배열까지 완벽하게 세자리 모두 맞췄다면(3스트라이크) success 출력
 * 지정 횟수안에 3스트라이크를 하지 못한경우 fail 출력
 */

import java.util.Scanner


fun main(arg: Array<String>) {
    val sc = Scanner(System.`in`)
    val numberBaseballAnswer = sc.nextInt().toString().toCharArray()
    val count = sc.nextInt()

    var isSuccess: Boolean = false // 올스트라이크 = isSucces를 mutable false로 초기화


    for (i in 0 until count) {
        val currentMyAnswer = sc.nextInt().toString().toCharArray()
        val strike: Int = Calculator().calculateStrikeCount(numberBaseballAnswer, currentMyAnswer)
        val ball = Calculator().calculateBallCount(numberBaseballAnswer, currentMyAnswer)
        val out = Calculator().calculateOutCount(numberBaseballAnswer, currentMyAnswer)

        println("${strike}스트라이크 ${ball}볼 ${out}아웃") // 테스트 케이스 마다 현재 상황을 출력해줌

        val isAllStrike = strike == numberBaseballAnswer.size // 올스트라이크(= 정답)인경우
        if (isAllStrike) {
            isSuccess = true
            break // 남은 테스크 케이스를 무시하고 반복 종료
        }
    }
    if (isSuccess) { // isSuccess가 true인 경우
        println("success") // success 출력
    } else { // 반복 종료까지 isSuccess가 false 그대로 인 경우
        println("fail") // fail출력
    }
}

class Calculator {
    fun calculateStrikeCount( // 스트라이크의 갯수를 카운트 하는 함수
        numberBaseballAnswer: CharArray, // 정답을 main에서 입력받고 CharArray화 시킨것
        currentMyAnswer: CharArray // 내가 제시한 답을 main에서 입력받고 CharArray화 시킨것
    ): Int {
        var strike = 0
        for (j in numberBaseballAnswer.indices) {
            if (numberBaseballAnswer[j] == currentMyAnswer[j]) { // 위의 두 Array의 각 인덱스가 같은경우
                strike++ // strike count++
            }
        }
        return strike // 함수에 마지막에 저장된 strike return
    }
    fun calculateBallCount( // ball의 갯수를 카운트 하는 함수
        numberBaseballAnswer: CharArray,
        currentMyAnswer: CharArray
    ): Int {
        var ball = 0
        for (j in numberBaseballAnswer.indices) {
            for (k in numberBaseballAnswer.indices) {
                if (j != k && numberBaseballAnswer[j] == currentMyAnswer[k]) { // index 번호가 같지 않으면서 (같으면 strike까지 포함) 같은 숫자가 존재 할 경우
                    ball++ // ball count++
                }
            }
        }
        return ball // 함수에 마지막으로 저장된 ball return
    }
    fun calculateOutCount( // out의 갯수 카운트 해주는 함수
        numberBaseballAnswer: CharArray,
        currentMyAnswer: CharArray
    ): Int {
        var out = 0
        for (element in numberBaseballAnswer) {
            var hasSameValue = false // 같은 값이 있는가? 를 mutable false로 초기화
            for (k in numberBaseballAnswer.indices) {
                if (element == currentMyAnswer[k]) { // 정답의 각 숫자와 내가 제시한 답에 같은 숫자가 있는 경우
                    hasSameValue = true // 같은 값이 있는가 = true가 되면서
                    break // 반복문 종료
                }
            }
            if (hasSameValue.not()) {
                out++
            }
        }
        return out // 마지막으로 저장된 out return
    }
}