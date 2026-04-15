package algocodeio._01_twopointers._02_pointer_for_each

/**
        В общем, нужно проверить является ли s подстрокой t.
        Если решать через two pointers, каждому по указателю:
        указатель на начало каждого массива (sPointer, tPointer)
        двигаем tPointer пока не найдем совпадение с s[sPointer]
        если нашли то сдвигаем sPointer и продолжаем идти по t

        сложность в таком случае будет O(n) где n = t.size
        решил за 26 мин
*/

private fun isSubsequence(s: String, t: String): Boolean {
    if(s.length == 0) return true
    if(t.length == 0) return false

    var sPointer = 0

    for (tPointer in t.indices) {
        if (s[sPointer] == t[tPointer]) {
            sPointer++
            if (sPointer == s.length) return true
        }
    }
    return sPointer == s.length
}