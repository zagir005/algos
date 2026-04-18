package algocodeio._01_twopointers._03_fast_and_slow

/*
    я как на этой задаче встрял на два часа
    O(n)
    O(1)
*/

private fun removeDuplicates(nums: IntArray): Int {
    var sl = 0
    var fs = 0

    while(fs < nums.size){
        if(nums[fs] > nums[sl]){
            nums[sl+1] = nums[fs]
            sl++
        }
        fs++
    }
    return sl + 1
}