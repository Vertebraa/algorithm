/**
 * https://programmers.co.kr/learn/courses/30/lessons/12903
 * 가운데 글자 가져오기, 만약 입력받은 문자열의 length가 홀수라면 정가운데에 있는 문자를 가져옴
 * 짝수라면 가운데 두 문자를 가져옴
 */

class Solution {
    fun solution(s: String): String {
        return if (s.length % 2 == 0) { // length가 짝수인 경우
            s.substring(s.length / 2 - 1, s.length / 2 + 1) // length를 반으로 나눈수의 -1 번째(=index) 문자와 다음 문제를 리턴
        } else {
            s.substring(s.length / 2, s.length / 2 + 1) // 홀수라면 length를 반으로 나눈수 번째(=index)를 리턴함
        } // subString(n, m)은 n번째의 앞 문자들과 m번째 부터 뒤의 문자들(=until)을 제거한다
    }
}