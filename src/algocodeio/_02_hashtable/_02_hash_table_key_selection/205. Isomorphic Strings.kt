package algocodeio._02_hashtable._02_hash_table_key_selection

/**
    по идее надо мапить s[i] на t[i], при этом если
    символ равный s[i] уже мапился в какой-либо другой, то выдаем false
    соответственно, нам надо хранить в мапе все сопоставления символов

    споткнулся об то, что изоморфность строки нужно проверять в обе стороны
    (я проверял только s к t)

    cначала заранее заполнял мапы и делал отдельный цикл проверяя в обе стороны строки
    теперь все в одном цикле

    O(n)
    O(n)
    27%
    55min
    по идее можно эффективнее написать если вместо хеш-мапы использовать массив
    int'ов размером в 256 (кол-во ascii символов)
*/
fun isIsomorphic(s: String, t: String): Boolean {
    val sMap = HashMap<Char, Char>()
    val tMap = HashMap<Char, Char>()

    for (i in s.indices) {
        val sValue = s[i]
        val tValue = t[i]

        if(sMap.containsKey(sValue) && sMap[sValue] != tValue) return false
        if (tMap.containsKey(tValue) && tMap[tValue] != sValue) return false

        sMap[sValue] = tValue
        tMap[tValue] = sValue
    }

    return true
}

private fun isIsomorphicShit(s: String, t: String): Boolean {
    val sMap = s.associate{ it to ' ' }.toMutableMap()

    for(i in s.indices){
        val sValue = s[i]
        val tValue = t[i]

        if(sMap[sValue] != ' ' && sMap[sValue] != tValue)
            return false

        sMap[sValue] = tValue
    }

    val tMap = t.associate{ it to ' ' }.toMutableMap()

    for(i in s.indices){
        val sValue = s[i]
        val tValue = t[i]

        if(tMap[tValue] != ' ' && tMap[tValue] != sValue)
            return false

        tMap[tValue] = sValue
    }

    return true
}

fun main(){
    val s = "badc"
    val t = "baba"
}
