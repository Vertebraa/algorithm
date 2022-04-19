import java.util.Scanner

fun main(arg: Array<String>) {
    val sc = Scanner(System.`in`)
    val (h, m) = Pair(sc.nextInt(), sc.nextInt())
    val cook = sc.nextInt()

    if (m + cook >= 60) {
        val currentMinute = (m + cook) % 60
        val addTime = (m + cook) / 60
        val finishHour = h + addTime
        if (finishHour >= 24) {
            println("${(finishHour) % 24} $currentMinute")
        } else {
            println("${finishHour} $currentMinute")
        }
    } else {
        println("${h + (m + cook)/60} ${(m + cook) % 60}")
    }
}

/**
 * 2525번 문제 다른 방식으로 코드짜본것
 */