package algocodeio._01_twopointers._03_fast_and_slow

/**
    тоже two pointers, fast and slow
    теперь в начало нужно сместить четные числа
*/

private fun sortArrayByParity(nums: IntArray): IntArray {
    var sl = 0
    var fs = 0
    while(fs < nums.size){
        if(nums[fs] % 2 == 0){
            if(nums[sl] % 2 != 0){
                val temp = nums[fs]
                nums[fs] = nums[sl]
                nums[sl] = temp
            }
            sl++
        }
        fs++
    }
    return nums
}