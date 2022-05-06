/**
 * https://programmers.co.kr/learn/courses/30/lessons/12919
 * 서울에서 김서방 찾기, String 배열 seoul이 주어지고 Kim이 몇번째 index에 있는지 리턴하는 문제
 */

class Solution {
    fun solution(seoul: Array<String>): String {
        return "김서방은 ${seoul.indexOf("Kim")}에 있다" // seoul배열의 "Kim"이 들어있는 index번호
    }
}