package algocodeio._01_twopointers._03_fast_and_slow

/**
    крч два часа решал, без подсказки и блокнота не обошлось
    подсказка в том, что нужно представить nums как linked list

    nums[i] это указатель на следующий элемент
    нужно как в решении linked list cycle найти начало цикла
    пример:
    nums =   [3,1,2,4,3]
    индексы:  0 1 2 3 4

    0 -> nums[0] = 3
    3 -> nums[3] = 4
    4 -> nums[4] = 3
    3 -> 4 -> 3 -> ....
 */

private fun findDuplicate(nums: IntArray): Int {
    var sl = 0
    var fs = 0

    while (true) {
        fs = nums[nums[fs]]
        sl = nums[sl]
        if (fs == sl) {
            sl = 0
            while (sl != fs) {
                fs = nums[fs]
                sl = nums[sl]
            }
            return sl
        }
    }
    throw IllegalStateException("йикъ")
}