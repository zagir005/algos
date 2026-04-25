package contests.biweekly.`181`

/**
0 - если возрастающая часть больше
1 - если убывающая часть больше
-1 - если обе части равны

по идее просто проходимся по массиву в цикле и суммируем сначала все значения в одну переменную,
она будет означать сумму ascending части. Если nums[i+1] < nums[i] значит дошли до descending части

 крч первый раз не прошло из-за переполнения int'а.
 */
fun compareBitonicSums(nums: IntArray): Int {
    var ascSum = nums[0].toLong()
    var i = 0
    while (i + 1 < nums.size && nums[i + 1] > nums[i]) {
        i++
        ascSum += nums[i]
    }

    var descSum = nums[i].toLong()
    while (i + 1 < nums.size) {
        i++
        descSum += nums[i]
    }

    return when {
        ascSum > descSum -> 0
        descSum > ascSum -> 1
        else -> -1
    }
}