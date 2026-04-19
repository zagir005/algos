package algocodeio._01_twopointers._03_fast_and_slow

/**
    если решать in-place то тут надо бы уже три указателя
    хотя можно просто подсчетом количества каждого цвета
    но тогда будет два цикла

    эврика произошла
    один указатель нам нужен что бы ловить конец очереди с нулями
    второй нужен в конце, будет ловить начало очереди с двойками
    третий это проходной, ловит 0 и 2 для left и right поинтеров
    единицы сами по себе останутся в середине

    O(n)
    O(1)
    2d
    иногда 10% на lc бьет, иногда 100%
*/

private fun sortColors(nums: IntArray): Unit {
    var left = 0
    var mid = 0
    var right = nums.size - 1

    while(mid <= right){
        if(nums[mid] == 0){
            nums.swap(left, mid)
            left++
            mid++
        } else if (nums[mid] == 2) {
            nums.swap(mid,right)
            right--
        } else mid++
    }
}

//swap фукнция на будущее
fun IntArray.swap(left: Int, right: Int) {
    val temp = this[left]
    this[left] = this[right]
    this[right] = temp
}