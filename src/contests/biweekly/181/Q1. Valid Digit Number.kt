package contests.biweekly.`181`


/*
Q1. Valid Digit Number

You are given an integer n and a digit x.

A number is considered valid if:
It contains at least one occurrence of digit x, and
It does not start with digit x.
Return true if n is valid, otherwise return false.

Example 1:
Input: n = 101, x = 0
Output: true
Explanation:
The number contains digit 0 at index 1. It does not start with 0, so it satisfies both conditions. Thus, the answer is true
 */

/**
 * Решил за пару минут, но не математически. Позже, на будущее, опишу мат. способ получения первой цифры в числе.
 */

fun validDigit(n: Int, x: Int): Boolean {
    val nString = n.toString()
    val xChar = x.digitToChar()
    return nString[0] != xChar && nString.contains(xChar)
}

fun main(){
    println(validDigit(101,0))
}