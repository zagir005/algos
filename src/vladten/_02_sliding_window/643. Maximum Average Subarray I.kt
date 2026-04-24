package vladten._02_sliding_window

import kotlin.math.max

/**
sliding window
сначала допустил такую ошибку, что сумму чисел внутри окна вычислял каждый раз заново
что давало сложность O(n*k). Нужно при передвижении окна nums[lP-1] отнимать от sum,
а nums[rP] прибавлять.
 O(n)
 O(1)
 99%
 22min
 */
fun findMaxAverage(nums: IntArray, k: Int): Double {
    //предварительно вычисляем сумму первого окна
    var currSum = 0
    for(i in 0..k-1) currSum += nums[i]

    //передвигаем окно
    var maxSum = currSum
    for(rP in k..nums.size - 1){
        val lP = rP - k
        currSum -= nums[lP]
        currSum += nums[rP]
        maxSum = max(currSum, maxSum)
    }

    return maxSum / k.toDouble()
}