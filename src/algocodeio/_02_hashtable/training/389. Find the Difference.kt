package algocodeio._02_hashtable.training

/*
        XOR:
        0 0 - 0
        1 1 - 0
        0 1 - 1
        1 0 - 1

        O(n)
        O(1)
     */
private fun findTheDifference(s: String, t: String): Char {
    var result = 0

    for (c in s)
        result = result xor c.code

    for (c in t)
        result = result xor c.code

    return result.toChar()
}