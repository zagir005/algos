package algocodeio._01_twopointers._03_fast_and_slow

/*
    По идее можно решить через two pointers, left/right
    но непонятно что делать с элементами равным pivot
    нужен указатель на середину

    сначала решу без
*/

private fun pivotArray(nums: IntArray, pivot: Int): IntArray {
    val left = mutableListOf<Int>()
    val mid = mutableListOf<Int>()
    val right = mutableListOf<Int>()

    for(i in nums){
        when{
            i < pivot -> left.add(i)
            i == pivot -> mid.add(pivot)
            i > pivot -> right.add(i)
        }
    }

    return (left + mid + right).toIntArray()
}