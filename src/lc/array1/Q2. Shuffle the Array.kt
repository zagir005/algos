package lc.array1

fun main(){
    // 0, 3, 1, 4, 2, 5
    //
    println(
        shuffle(
            nums = intArrayOf(2,5,1,3,4,7),
            n = 3
        ).joinToString()
    )
}

/**
 * Была немного путница, но как написал текстом какие индексы мне нужны, сразу стало ясно что делать
 * Функция по времени выполнения в lc набрала лишь 25%. Можно было бы покрасивее написать без цикла и доп индексов,
 * сразу возвращая IntArray. ну эт в другой раз
 */

private fun shuffle(nums: IntArray, n: Int): IntArray {
    val ans: IntArray = IntArray(nums.size)
    var ansIndex = 0
    for (i in 0..<n) {
        ans[ansIndex] = nums[i]
        ansIndex++
        ans[ansIndex] = nums[i + n]
        ansIndex++
    }
    return ans
}

