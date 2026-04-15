package algocodeio._01_twopointers._02_pointer_for_each

import kotlin.math.max
import kotlin.math.min

/**
    Т.к. в lc нету такой же задачи, но есть похожая, решу обе.
    findDifferenceSortedArray под algocode.io
 */

/*
        сначала пытался использовать boolean мапу, но понял, что двух значений (true/false)
        недостаточно что бы описать вхождения и расхождения массивов.
        в итоге intArr использую
        0 - нигде не было
        1 - было только в nums1
        2 - было только в nums2
        3 - было в обоих

        O(n+m) - т.к. проходимся по обоим массивам полностью. 2001 отбрасываем ибо константа
        O(n+m) - по памяти

        решил за минут 40
     */
fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
    val map = IntArray(2001)
    val ans1 = mutableListOf<Int>()
    val ans2 = mutableListOf<Int>()

    for(i in nums1) map[i + 1000] = 1

    for(i in nums2)
        when(map[i + 1000]){
            1 -> map[i + 1000] = 3
            0 -> map[i + 1000] = 2
            else -> continue
        }

    for(i in map.indices)
        when(map[i]){
            1 -> ans1.add(i - 1000)
            2 -> ans2.add(i - 1000)
        }

    return listOf(ans1, ans2)
}

/**
 * Задача:
 * Симметричная разница массивов
 *
 * Даны два массива nums1 и nums2, отсортированные по возрастанию и состоящие из уникальных элементов.
 * Нужно найти все элементы, которые встречаются только в одном из массивов и вернуть их в порядке возрастания.
 *
 * Пример 1:
 * Ввод: nums1 = [1,5,7,9], nums2 = [2,3,5,6,7,8]
 * Вывод: [1,2,3,6,8,9]
 *
 * Пример 2:
 * Ввод: nums1 = [2,3], nums2 = [1]
 * Вывод: [1,2,3]
 *
 * Ограничения:
 * len(nums1) + len(nums2) >= 1
 *
 */

/**
 * Two pointers, по указателю на каждый массив
 * O(n+m) - потому что полностью прохожусь по обоим массивам
 * O(n+m) по памяти - добавляем уникальные элементы, в худшем случае в обоих массивах все элементы могут быть уникальными
 */
fun findDifferenceSortedArray(nums1: IntArray, nums2: IntArray): IntArray {
    val ans = mutableListOf<Int>()

    var nums1Pointer = 0
    var nums2Pointer = 0

    while (nums1Pointer < nums1.size && nums2Pointer < nums2.size) {
        val nums1Value = nums1[nums1Pointer]
        val nums2Value = nums2[nums2Pointer]
        when{
            nums1Value == nums2Value -> {
                nums1Pointer++
                nums2Pointer++
            }
            nums1Value < nums2Value -> {
                nums1Pointer++
                ans.add(nums1Value)
            }
            nums2Value < nums1Value -> {
                nums2Pointer++
                ans.add(nums2Value)
            }
        }
    }

    while (nums1Pointer < nums1.size)
        ans.add(nums1[nums1Pointer++])

    while (nums2Pointer < nums2.size)
        ans.add(nums2[nums2Pointer++])

    return ans.toIntArray()
}

fun main(){

}