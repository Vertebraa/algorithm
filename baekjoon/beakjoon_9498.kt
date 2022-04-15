import java.util.Scanner

/**
 * https://www.acmicpc.net/problem/9498
 * 시험 성적 채점하기
 */


fun main(arg: Array<String>) {

    val sc = Scanner(System.`in`)
    val score = sc.nextInt() // 시험 점수를 입력한다
    if (0 <= score && score <= 100) { // 점수의 범위를 제한
        if (90 <= score && score <= 100) { // 90~100점은 성적 A를 출력
            println("A")
        } else if (80 <= score && score <= 89) { // 80~89점은 성적 B를 출력
            println("B")
        } else if (70 <= score && score <= 79) { // 70~79점은 성적 C를 출력
            println("C")
        } else if (60 <= score && score <= 69) { // 60~69점은 성정 D를 출력
            println("D")
        } else {println("F")} // 그 미만의 점수는 F를 출력
    }


}