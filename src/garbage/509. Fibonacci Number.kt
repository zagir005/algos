package garbage

/*
* Algorithm complexity: O(n)
* Memory complexity: O(1)
 */
private fun fib(n: Int): Int {
    if (n <= 1) return n

    var prev = 0
    var curr = 1

    for (i in 2..n) {
        val next = prev + curr
        prev = curr
        curr = next
    }

    return curr
}