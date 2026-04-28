package garbage.tbank

fun maxProfit(prices: IntArray): Int {
    var buy1 = Int.MIN_VALUE
    var sell1 = 0
    var buy2 = Int.MIN_VALUE
    var sell2 = 0

    for (price in prices) {
        buy1 = maxOf(buy1, -price)
        sell1 = maxOf(sell1, buy1 + price)
        buy2 = maxOf(buy2, sell1 - price)
        sell2 = maxOf(sell2, buy2 + price)
    }

    return sell2
}


fun main() {
    val n = readln().toInt()
    val prices = readln().split(" ").map { it.toInt() }
    print(maxProfit(prices.toIntArray()))
}