/**
 * https://programmers.co.kr/learn/courses/30/lessons/12950
 * 행렬의 덧셈 같은 행, 두 배열의 같은 열의 값을 더해서 새로운 행렬을 리턴하는 문제
 */

class Solution {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        return Array(arr1.size) { i -> // 두 배열의 크기는 같으므로 arr1의 크기로 배열을 만들고
            IntArray(arr1[i].size) { j -> // 각 인덱스에 같은 크기의 IntArray를 만들어줌
                arr1[i][j] + arr2[i][j]
            }
        }
    }
}