package garbage

/**
 * Author: zagir
 * Created: 26.03.2026 10:29
 * Task: 15. 3Sum
 *
 * Algorithm complexity: O(n^2), так как по каждому элементу массива по i и по left с right.
 * Саму сортировку не считаем, а так вместе с ней O(n^2 + n log n)
 * Memory complexity: O(1)
 * Time to solve: 1hr
 *
 * Tags:
 *
 * Notes:
 * в первом решении брутфорсом споткнулся об то, что не должно быть
 * дубликатов - массивов с одинаковыми, просто переставленными, числами.
 * если сделать set и сортировать предварительно списки, то решение работает, но за O(n^3).
 *
 * крч сортируем массив предварительно.
 * идем от i (от начала массива)
 * и делаем twoPointers. Проверяем и закидываем в list
 *
 *
 * Tags: Two Pointers
 */

private fun threeSum(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    nums.sort()

    for (i in 0..nums.lastIndex) {
        if (i > 0 && nums[i] == nums[i - 1]) continue
        var left = i + 1
        var right = nums.lastIndex
        while (left < right) {
            val iNum = nums[i]
            val leftNum = nums[left]
            val rightNum = nums[right]
            val sum = iNum + leftNum + rightNum
            when {
                sum > 0 -> right--
                sum < 0 -> left++
                else -> {
                    result.add(listOf(iNum, leftNum, rightNum))
                    left++
                    right--
                    while (left < right &&
                        nums[left] == nums[left - 1]) left++
                    while (left < right &&
                        nums[right] == nums[right + 1]) right--
                }
            }
        }
    }

    return result
}