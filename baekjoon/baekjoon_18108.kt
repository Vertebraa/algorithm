import java.util.Scanner

/**
 * https://www.acmicpc.net/problem/18108
 * 불기연도를 서기연도로 변환한 값 출력
 */
fun main(args:Array<String>){
    val sc = Scanner(System.`in`)
    val buddhaEra = sc.nextInt() // 불기연도를 입력
    if (buddhaEra in 1000..3000){ //입력 가능한 불기연도의 범위 지정
        val buddhaEraAnnoDominiGap = 543 // 불기연도와 서기연도의 차이
        val annoDomini = buddhaEra - buddhaEraAnnoDominiGap // 서기연도값 계산
        println(annoDomini) // 입력한 불기연도를 서기연도로 변환하여 출력
    }
}
