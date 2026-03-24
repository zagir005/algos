package everyday

/**
 * Author: zagir
 * Created: 24.03.2026 11:25
 * Task: 1929. Concatenation of Array
 *
 * Algorithm complexity: O(n). По началу показалось, что O(n*2), так как мы создаем массив в два раза больший, чем nums
 * но по факту сложность O(n), так как константа 2 не учитывается.
 * Memory complexity: O(n)
 * Time to solve: from 11:33 to 12:00
 *
 * Description: сначала написал простое решение (хотя оно хуже второго) в виде функции в которой мы создаем
 * IntArray с размером в 2 раза большим n. В init вычисляем индекс следующим образом: если дошли до конца nums
 * то возвращаемся в начало nums: i -nums.size, иначе i. В result array кидаем nums[index].
 * По идее это быстрое решение, O(n), но я заметил, что оно не самое быстрое в литкоде. В итоге чат гпт просто подсказал
 * функцию копирования массива, про такую не знал. В будущем будет полезно.
 *
 * Notes:
 */

private fun getConcatenation(nums: IntArray): IntArray {
    return IntArray(nums.size * 2) { i ->
        val index = if (i >= nums.size) i - nums.size else i
        nums[index]
    }
}

private fun getConcatenationByCopy(nums: IntArray): IntArray {
    val result = IntArray(nums.size * 2)
    System.arraycopy(nums, 0, result, 0, nums.size)
    System.arraycopy(nums, 0, result, nums.size, nums.size)
    return result
}

fun main() {
    println(getConcatenation(intArrayOf(1,2,1)).joinToString())
}