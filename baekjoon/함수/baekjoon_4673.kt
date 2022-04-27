/**
 * https://www.acmicpc.net/problem/4673
 * 함수를 사용해서 셀프넘버 찾기
 * 셀프넘버는 자연수 N과 N의 각 자릴수의 덧셈으로 만들 수 없는 숫자를 말함
 * 예를 들어 456일때 456+ 4 + 5 + 6 = 471이므로 471은 셀프 넘버가 아님
 * 10001개의 인덱스를 만들어 1번 index부터 10000번 index까지의 index번호를 숫자라고 생각하고 풀이
 * 각 index에 셀프넘버가 아닌 경우 1을 set 해주고 index 값이 0인 경우에만 해당 index 번호를 출력 (IntArray 초기값 0)
 */


fun main(arg: Array<String>) {

    val numberPool = IntArray(10001) // 전체 숫자의 풀을 만듬

    for (i in 1 until numberPool.size) { //1번부터 10000번까지 반복
        val unSelfNumber = findUnSelfNumber(i) // 함수에 return된 값 = 셀프넘버가 아닌 수
        if (unSelfNumber < numberPool.size) { // 10000가 넘으면 out of bound가 나므로 제한을 걸어줌
            numberPool[unSelfNumber] = 1 // 숫자 풀의 셀프넘버가 아닌 수(=n번째)의 index에 1을 set
        }
        if (numberPool[i] == 0) { // index 값이 0 인 경우
            println(i) // 그 index 번호를 전부 출력
        }
    }
}

private fun findUnSelfNumber (n : Int): Int { // 셀프넘버가 아닌 경우를 찾는 함수
    var sumOfNumber = 0
    val nArray = n.toString().toCharArray() // 입력된 숫자를 CharArray화 시킨것
    for (i in nArray.indices) {
        sumOfNumber += Character.getNumericValue(nArray[i]) // 위 array의 index의 각 자릿수를 더한값
    }
    return sumOfNumber + n // 위에서 더한 값에 입력된 숫자를 더해주고 (= 셀프넘버가 아닌 숫자) 그 값을 return
}