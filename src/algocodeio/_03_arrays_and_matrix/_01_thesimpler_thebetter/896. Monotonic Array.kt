package algocodeio._03_arrays_and_matrix._01_thesimpler_thebetter

private fun isMonotonic(nums: IntArray): Boolean {
    var isIncreasing = true
    var isDecreasing = true

    for(num in 1..nums.lastIndex){
        isIncreasing = isIncreasing && nums[num-1] <= nums[num]
        isDecreasing = isDecreasing && nums[num-1] >= nums[num]
        if(!isIncreasing && !isDecreasing) return false
    }

    return isIncreasing || isDecreasing
}