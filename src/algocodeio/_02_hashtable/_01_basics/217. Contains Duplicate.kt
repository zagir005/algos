package algocodeio._02_hashtable._01_basics

fun containsDuplicate(nums: IntArray): Boolean {
    val set = hashSetOf<Int>()
    for(i in nums){
        if(!set.add(i)) return true
    }
    return false
}