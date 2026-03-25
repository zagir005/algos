package everyday

/**
 * Author: zagir
 * Created: 25.03.2026 07:49
 * Task: 125. Valid Palindrome
 *
 * Algorithm complexity: O(n)
 * Memory complexity: С фильтрацией - O(n), без фильтрации O(1)
 * По решению с фильтрацией я по началу думал, что там O(n^2) из-за того, что
 * у нас новая строка создается с фильтрацией. Но мы ведь входной массив не учитываем изначально. Так что O(n)
 *
 * Time to solve: фильтрацией from 7:49 to 8:20, без фильтрации from 8:20 to 8:40
 *
 * Description: two pointers задача дефолтная, берем левый и правый символы и сравниваем.
 * чуть тонкость в том, что бы скипать пробелы, запятуи всякие и при этом сравнивать в lowercase.
 *
 * Notes: я ща встрял из-за пробелов, ибо их мы не учитываем в палиндроме, но как элементы строки
 * они у нас все равно есть.
 * Представим, что у нас два указателя, если один из указателей столкнулся с пробелом, мы могли бы его
 * инкрементировать/декрементировать и скипнуть итерацию цикла. Но, может быть такое, что у нас в строке
 * тупо два пробела и мы наткнемся на indexOutOfBoundsException.
 * Проверку пилить уже некрасиво, а предварительно чистить от пробелов строку слишком медленное решение.
 * Но ща попробую.
 *
 * С фильтром бьет 84%. Споткнулся по началу об то, что символы (запятые и тд) тоже надо фильтровать.
 * Потом написал решение без фильтрации, оно набирает 39%, видимо из-за большего количества операций.
 * Но сложность по памяти у него все равно меньше, O(1)
 * Написал отдельную функцию для валидации символа и заработал пару мс, теперь 44%
 *
 *
 * Tags: Two pointers
 */

private fun isValidSymbol(symbol: Char): Boolean {
    return (symbol in 'a'..'z' || symbol in 'A'..'Z' || symbol in '0'..'9')
}

fun isPalindrome(s: String): Boolean {
    var left = 0
    var right = s.lastIndex

    while (left < right){
        while (left < right && !isValidSymbol(s[left])) left++
        while (left < right && !isValidSymbol(s[right])) right--

        if (s[left].lowercaseChar() != s[right].lowercaseChar()) return false

        left++
        right--
    }

    return true
}

private fun isPalindromeFiltered(s: String): Boolean {
    val newS = s.filter { it.isLetterOrDigit() }
    var left = 0
    var right = newS.lastIndex
    if (s.isEmpty()) return true

    while (left < right){
        if (newS[left].lowercaseChar() != newS[right].lowercaseChar()) return false
        left++
        right--
    }

    return true
}

fun main(){
    println(isPalindrome("A man, a plan, a canal: Panama"))
}

