package algocodeio._01_twopointers._02_pointer_for_each

/*
        Т.к. два массива то нужно сразу смотреть в сторону two pointers
        т.к. первые значения в nums1 у нас реальные, а в конце нули которые надо заполнить
        лучше пойти с конца массива, что бы не терять реальные данные

        O(n+m)
        O(1)
        11%
        17min
     */

private fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    var nums1Pointer = m - 1
    var nums2Pointer = n - 1

    var i = nums1.lastIndex
    while (i >= 0 && nums2Pointer >= 0) {
        if (nums1Pointer >= 0 && nums1[nums1Pointer] >= nums2[nums2Pointer]) {
            nums1[i] = nums1[nums1Pointer]
            nums1Pointer--
        } else {
            nums1[i] = nums2[nums2Pointer]
            nums2Pointer--
        }
        i--
    }
}
