package algocodeio._01_twopointers._02_pointer_for_each

/**
844. Backspace String Compare
сначала думал
идем с конца массивов двумя указателями,
если # то скипаем символ перед ним

споткнулся об кейсы где "bxo#j##tw" символ удаления перекрывал удаление
в итоге начал считать кол-во удалений

способ решения: two pointers, каждому по указателю

O(n+m)
O(1)
38min
 */
private fun backspaceCompare(s: String, t: String): Boolean {
    var sPointer = s.lastIndex
    var tPointer = t.lastIndex
    var sDelCount = 0
    var tDelCount = 0

    while(sPointer > -1 || tPointer > -1){
        var sValue = s.getOrElse(sPointer) { ' ' }
        var tValue = t.getOrElse(tPointer) { ' ' }

        when{
            sValue == '#' -> { sDelCount++; sPointer-- }
            tValue == '#' -> { tDelCount++; tPointer-- }
            sDelCount > 0 -> { sDelCount--; sPointer-- }
            tDelCount > 0 -> { tDelCount--; tPointer-- }
            tValue == sValue -> {
                sPointer--
                tPointer--
            }
            sValue != tValue -> return false
        }
    }

    return if(sPointer < 0 && tPointer < 0) true else false
}

fun main(){
    println(
        backspaceCompare(
            s = "bxj##tw",
            t = "bxo#j##tw"
        )
    )
}