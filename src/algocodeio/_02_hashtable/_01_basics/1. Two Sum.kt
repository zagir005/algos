package algocodeio._02_hashtable._01_basics

fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = HashMap<Int, Int>()

    for (i in nums.indices) {
        val num = nums[i]
        val complement = target - num

        if (map.containsKey(complement)) {
            return intArrayOf(map[complement]!!, i)
        }

        map[num] = i
    }

    throw IllegalStateException()
}
