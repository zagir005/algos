package algocodeio._01_twopointers._03_fast_and_slow

import kotlin.math.min

/**
    two pointers, fast and slow
    т.к. в kotlin удалить из IntArray элементы нельзя, нужно перенести лишние в конец
    lc сам глянет первые k нужных элементов

    задача тяжело пошла, без подсказки и блокнота не получалось решить
    ясно что это быстрый и медленный указатель, но как условие выстроить что бы в нужный
    момент элементы местами менять непонятно

    в итоге суть в том, что бы проверять элемент по индексу sl - 2

    O(n)
    O(1)
    1ч. 13м
 */
private fun removeDuplicates(nums: IntArray): Int {
    var sl = 2
    var fs = 2

    while(fs <= nums.lastIndex){
        val fsNum = nums[fs]
        val slNum = nums[sl]
        if(fsNum != nums[sl-2]){
            val temp = fsNum
            nums[fs] = slNum
            nums[sl] = temp
            sl++
        }
        fs++
    }
    return min(sl, nums.size)
}

fun main(){
    removeDuplicates(
        nums = intArrayOf(1,1,1,2,2,3)
    )
}