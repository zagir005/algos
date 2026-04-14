package garbage

/**
 * Author: zagir
 * Created: 26.03.2026 20:02
 * Task: 704. Binary Search
 *
 * Best algorithm complexity:
 * Best memory complexity:
 * Time to solve: на второй день только решил
 *
 * Description: самым быстрым алгоритмом поиска в отсортированном массиве является бинарный - O(log n).
 * Год назад писал его в последний раз.
 * Главный принцип это отсеивание части массива, типа горячо/холодно. Берем середину массива, если target
 * меньше, то отсеиваем числа справа, иначе слева и так даканцу
 *
 * Solve description:
 *
 * Tags: Binary search
 */

private fun search(nums: IntArray, target: Int): Int {
    var leftIndex = 0
    var rightIndex = nums.size - 1

    while(leftIndex <= rightIndex){
        val midIndex = (leftIndex + rightIndex) / 2
        val mid = nums[midIndex]
        when{
            target == mid -> return midIndex
            target > mid -> leftIndex = midIndex + 1
            target < mid -> rightIndex = midIndex - 1
        }
    }

    return -1
}