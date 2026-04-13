package contests.biweekly180

fun countDigitOccurrences(nums: IntArray, digit: Int): Int {
    var result = 0

    for(i in nums){
        var currNum = i
        do {
            val currLastDigit = currNum % 10
            if(currLastDigit == digit)
                result++
            currNum /= 10
        } while (currNum != 0)
    }
    return result
}

fun main(){
    println(
        countDigitOccurrences(
            nums = intArrayOf(12,54,32,22),
            digit = 2
        )
    )
}