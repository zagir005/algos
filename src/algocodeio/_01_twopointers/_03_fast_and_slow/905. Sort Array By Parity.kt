package algocodeio._01_twopointers._03_fast_and_slow

/**
    тоже two pointers, fast and slow
    теперь в начало нужно сместить четные числа
    O(n)
    O(1)
    97% - в лучшем решении указатели идут с двух сторон
    если left не четное число то меняет местами с right
    6min

    Когда нужно разделить массив на две группы по какому-то признаку (четные/нечетные, нули/не нули) и
    порядок внутри групп не важен, метод с двух сторон (left и right) часто выглядит чище и работает чуть быстрее,
    так как мы просто "схлопываем" массив к центру
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