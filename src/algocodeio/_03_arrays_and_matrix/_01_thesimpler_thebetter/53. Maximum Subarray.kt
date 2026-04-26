package algocodeio._03_arrays_and_matrix._01_thesimpler_thebetter

/*
крч суть в том, что если текущая сумма стала отрицательной, то и продолжать ее не нужно
O(n)
O(1)
*/

fun maxSubArray(nums: IntArray): Int {
    var current = nums[0]
    var maxSum = nums[0]

    for (i in 1 until nums.size) {
        current = maxOf(nums[i], current + nums[i])
        maxSum = maxOf(maxSum, current)
    }

    return maxSum
}