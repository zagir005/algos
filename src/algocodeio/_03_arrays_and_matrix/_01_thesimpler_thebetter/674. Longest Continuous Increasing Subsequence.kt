package algocodeio._03_arrays_and_matrix._01_thesimpler_thebetter

import kotlin.math.max

/**
Просто держим incCountCurr и incCountAns
когда возрастает инкрементируем incCountCurr, как только серия прервалась
if(incCountCurr > incCountAns) incCountAns = incCountCurr
 */
fun findLengthOfLCIS(nums: IntArray): Int {
    if (nums.size == 0) return 0
    var incCountAns = 1
    var incCountCurr = 1

    for(i in 1..nums.lastIndex){
        if(nums[i-1] < nums[i]) incCountCurr++
        else {
            incCountAns = max(incCountAns, incCountCurr)
            incCountCurr = 1
        }
    }

    return max(incCountAns, incCountCurr)
}