package garbage

/**
 * Author: zagir
 * Created: 26.03.2026 10:29
 * Task: 242. Valid Anagram
 *
 * Best algorithm complexity:
 * Best memory complexity:
 * Time to solve:
 *
 * Description:
 *
 * Tags:
 */

/**
 * Algorithm complexity: O(s+t), так как мы проходимся по обеим строкам
 * Memory complexity: O(s), так как размер charCounts зависит s
 *
 * Notes: по идее можно провоидить обычный бинарный поиск и если число не найдено, то возвращать
 * последний mid index.
 *
 * Tags:
 */

private fun searchInsert(nums: IntArray, target: Int): Int {
    var leftIndex = 0
    var rightIndex = nums.size - 1

    while(leftIndex <= rightIndex){
        var midIndex = (leftIndex + rightIndex) / 2
        var mid = nums[midIndex]
        when{
            target == mid -> return midIndex
            target > mid -> leftIndex = midIndex + 1
            target < mid -> rightIndex = midIndex - 1
        }
        midIndex = (leftIndex + rightIndex) / 2
        mid = nums[midIndex]
    }

    return leftIndex
}

fun main(){
    println(
        searchInsert(
            nums = intArrayOf(1,3,5,6),
            target = 2
        )
    )
}