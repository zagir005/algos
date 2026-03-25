package everyday

/**
 * Author: zagir
 * Created: 25.03.2026 06:57
 * Task: 344. Reverse String
 *
 * Algorithm complexity: O(n) - проходимся по массиву и все. Можно было бы подумать, что O((n/2)-1), мы же не по всему
 * массив проходимся, но эт неправильно, константы мы должны отбрасывать
 * Memory complexity:O(1), у нас там есть переменные, но мы их не учитываем, сам массив тож не учитываем, ибо он входной
 * Time to solve: from 6:57 to 7:16
 *
 * Description:
 *
 * Notes: решение с перестановкой в цикле оказалось медленным, всего лишь 7% бьет на lc.
 * написал сразу решение с двумя указателями и оно 100% набрало. я чет не особо понимаю почему.
 * видимо for тяжелее, чем while, из-за лишних условий, вычислений и тд.
 *
 * Еще прикольный момент: после того, как скинул решение гпт оказалось, что я лишний свап делаю в twoPointers решении
 * из-за <= в while. Я этот момент поправил, скинул в lc и исправленное решение оказалось на 1мс медленее, но по памяти
 * более оптимизированное, чем изначальное решение. Суета, видимо lc просто прикалывается.
 */

private fun reverseString(s: CharArray): Unit {
    for (i in 0..<s.size / 2) {
        val temp = s[i]
        s[i] = s[s.lastIndex - i]
        s[s.lastIndex - i] = temp
    }
}

private fun reverseStringTwoPointers(s: CharArray): Unit {
    var left = 0
    var right = s.size - 1
    while (left < right) {
        val temp = s[left]
        s[left] = s[right]
        s[right] = temp
        left++
        right--
    }
}