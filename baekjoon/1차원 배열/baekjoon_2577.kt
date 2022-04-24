import java.util.*

/**
 * https://www.acmicpc.net/problem/2577
 * 1차원 배열 문제 숫자의 갯수 구하기
 * 자연수 3개를 입력 받고 그 숫자들을 모두 곱한 결과값에 쓰인 숫자들의 갯수를 출력 시키는 문데
 * 예를 들어 곱셈의 값이 17037300 라면 0이 3번, 1이 1번, 7이 2번 쓰인것
 * 출력 시 0부터 9까지 각 숫자가 몇번씩 쓰였는지 개행 하여 출력 ( 쓰이지 않은 숫자는 0 )
 */

fun main(arg: Array<String>) {
    val sc = Scanner(System.`in`)

    val num1 = sc.nextInt()
    val num2 = sc.nextInt()
    val num3 = sc.nextInt()
    val resultArray = (num1 * num2 * num3).toString().toCharArray() // 입력받은 정수 3개를 곱하고 그 값을 Char타입의 Array로 만듬

    val countArray = IntArray(10) // IntArray의 경우 각 index의 초기값이 (0,0,0,....0)

    for (i in 0 until resultArray.size) {
        when (resultArray[i]) { // CharArray화 시킨 곱셈값의 사이즈 만큼 반복문 실핼
            '0' -> countArray[0]++ // 0번부터 각 index를 돌면서 일치 하는 숫자가 있을경우 countArray의 매칭되는 index에 1씩 더해줌 (카운트)
            '1' -> countArray[1]++
            '2' -> countArray[2]++
            '3' -> countArray[3]++
            '4' -> countArray[4]++
            '5' -> countArray[5]++
            '6' -> countArray[6]++
            '7' -> countArray[7]++
            '8' -> countArray[8]++
            '9' -> countArray[9]++
        }
    }
    countArray.forEach { println(it) } // countArray에 저장된 값을 개행하여 각각 출력
}

// 자연수 3개를 입력 받음
// 입력받은 자연수 3개를 곱함
// 곱한 값을 String 타입으로 바꾼후에 char 타입의 Array로 쪼갬
// 이후 반복해서 resultArray의 각각의 숫자가 몇번씩 사용됐는지 확인
// 예를 들어 곱셉 값이 17037300라면
// 0에 + 1 +1 +1 1에 + 1 3에 +1 +1 7에 +1 +1
//
//