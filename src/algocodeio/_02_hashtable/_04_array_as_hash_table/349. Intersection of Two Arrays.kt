package algocodeio._02_hashtable._04_array_as_hash_table

/*
        O(n+m)
        O(n+m)
     */
private fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
    val nums1Set = nums1.toMutableSet()
    val nums2Set = nums2.toSet()
    val ans = mutableListOf<Int>()

    for(i in nums2Set)
        if(!nums1Set.add(i)) ans.add(i)

    return ans.toIntArray()
}