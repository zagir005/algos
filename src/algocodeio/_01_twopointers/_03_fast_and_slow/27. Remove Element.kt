package algocodeio._01_twopointers._03_fast_and_slow

/*
    по идее это тот же move zeroes, two pointers fast and slow.
    только числа не 0 и 1, а val и !val
    O(n)
    O(1)
    100%
    3min
     */
private fun removeElement(nums: IntArray, `val`: Int): Int {
    var sl = 0
    var fs = 0
    while(fs < nums.size){
        if(nums[fs] != `val`){
            if(nums[sl] == `val`){
                val temp = nums[fs]
                nums[fs] = nums[sl]
                nums[sl] = temp
            }
            sl++
        }
        fs++
    }
    return sl
}