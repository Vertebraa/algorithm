/**
 * https://programmers.co.kr/learn/courses/30/lessons/12932
 * 자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴하는 문제
 * 정수가 12345라면 [5,4,3,2,1] 배열을 리턴하면 된다
 */

class Solution {
    fun solution(n: Long): IntArray {
       return n.toString().reversed().map { Character.getNumericValue(it) }.toIntArray()
    } // 정수를 string타입으로 바꿔주고 뒤집은 후에 각 자릿수를 getNumericValue해서 리스트를 만들고 다시 intArray로 바꿔서 리턴함
}