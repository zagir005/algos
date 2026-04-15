package algocodeio._01_twopointers._03_fast_and_slow

/**
        Первая задача по паттерну two pointer: быстрый и медленный
        на lc набрало только 12%, скорее всего из-за лишних свапов
        напр. если на нулевом индексе не-нуль, то он свапнется сам на себя
        O(n)
        O(1)
*/

private fun moveZeroes(nums: IntArray): Unit {
    var sl = 0
    var fs = 0
    while(fs <= nums.lastIndex){
        if(nums[fs] != 0){
            val temp = nums[fs]
            nums[fs] = nums[sl]
            nums[sl] = temp
            sl++
        }
        fs++
    }
}

fun main(){
    moveZeroes(
        nums = intArrayOf(1,0,0,3,12)
    )
}