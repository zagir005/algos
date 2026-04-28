package garbage.tbank

fun main(){
    val s = readln()
    if(s.isPalindrome() || s.last() == 'a') println("Yes")
    else println("No")
}

private fun String.isPalindrome(): Boolean {
    var left = 0
    var right = this.lastIndex

    while (left < right) {
        if (this[left] != this[right]) return false
        left++
        right--
    }

    return true
}