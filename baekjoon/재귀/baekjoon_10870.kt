import java.util.Scanner

fun main(arg: Array<String>) {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val fibonacci = IntArray(n + 1)


    fibonacci[0] = 0
    if (fibonacci.size > 1) {
        fibonacci[1] = 1
    }
    for (i in 2 until fibonacci.size) {
        fibonacci[i] = fibonacci[i - 2] + fibonacci[i - 1]
    }
    println(fibonacci[n])
}

