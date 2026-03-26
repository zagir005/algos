package everyday

/**
 * Author: zagir
 * Created: 26.03.2026 10:29
 * Task: 242. Valid Anagram
 *
 * Best algorithm complexity:
 * Best memory complexity:
 * Time to solve: 20m
 *
 * Description: Даются две строчки, нужно понять являются ли они анаграммами (одни и те же буквы в обоих)
 *
 * Tags:
 */

/**
 * Algorithm complexity: O(s+t), так как мы проходимся по обеим строкам
 * Memory complexity: O(s), так как размер charCounts зависит s
 *
 * Notes: я честно говоря тупо вспомнил как в прошлый раз решал ее.
 * Крч можно завести отдельную мапу (символ to количество) для первой строки а потом проходить по второй
 * и отнимать из мапы количество этих букв, если какой-то из символов в мапе не останется на нуле,
 * значит не анаграмма.
 * На lc всего лишь 5% бьет, хз почему. Видимо нужны оптимизации с мапой. Если правильно помню,
 * можно вообще массив int'ов сделать размером с алфавит и в нем считать, так оно уже быстрее работать будет.
 * По асимптоматике это в любом случае уже оптимальное решение.
 *
 * Tags:
 */
private fun isAnagram(s: String, t: String): Boolean {
    if (s.length != t.length) return false
    val charCounts: MutableMap<Char, Int> = HashMap()

    s.forEach { char ->
        charCounts[char] = charCounts.getOrDefault(char, 0) + 1
    }

    t.forEach { char ->
        val count = charCounts[char] ?: return false
        if (count - 1 < 0) return false
        else charCounts[char] = count - 1
    }

    return true
}

fun main(){
    println(isAnagram("ab", "a"))
}