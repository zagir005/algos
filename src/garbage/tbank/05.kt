package garbage.tbank

fun main() {
    val n = readln().toInt()
    val s = readln()

    var counter = 0
    val alphabet = "TOI"

    for (char in s) {
        if (!alphabet.contains(char)) counter++
    }

    println(counter)
}