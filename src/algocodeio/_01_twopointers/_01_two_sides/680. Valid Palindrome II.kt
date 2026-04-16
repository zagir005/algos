package algocodeio._01_twopointers._01_two_sides

/**
    берем isPalindrome функцию (two pointers реализация)
    проходимся по строке, если видим что символы не совпадают
    нужно проверить какой из них лишний
    для этого кидаем в isPalindrome строку, но проверяем
    начиная с (l + 1 to r) || (l to r -1)
    если оба false выдадут значит строка не палиндром
    при том такое решение явно не подойдет если мы можем удалить больше одного символа

    скорость O(n)
    память O(1)
    37мин.
*/
fun validPalindrome(s: String): Boolean {
    if(s.length <= 2) return true

    var l = 0
    var r = s.lastIndex

    while (l < r) {
        if (s[l] != s[r]) {
            return isPalindrome(s, l + 1, r) || isPalindrome(s, l, r - 1)
        }
        l++
        r--
    }

    return true
}

private fun isPalindrome(s: String, l: Int, r: Int): Boolean {
    var left = l
    var right = r

    while (left < right) {
        if (s[left] != s[right]) return false
        left++
        right--
    }

    return true
}