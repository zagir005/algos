package algocodeio._02_hashtable._04_array_as_hash_table

/*
    объяснение: citations.size это максимально возможный h
    если из 5 статей все будут иметь по 5 цитат, то h = 5
    если из 5 статей 5 цитат у четырех, то h = 4
    [100,200], h = 2
    [3,1,6], h = 2

    крч во-первых можно, например, массив [100,200] представить как
    [2,2], так с ним уже легче работать.
    [3,1,3]
    [1,3,1]

    надо подсчетом решить, пройтись по citations и
    под каждое число подсчитать кол-во

    крч прикол в том, что если с конца в начало countArr пойти (h)
    и суммировать countArr[h] в total до тех пор, пока оно не станет больше, чем
    сам h, то мы получим нужный нам h.

    O(n)
    O(n)
    1hr.32min
    100%
*/
fun hIndex(citations: IntArray): Int {
    val maxH = citations.size
    val countArr = IntArray(maxH + 1)

    for(count in citations)
        if(count >= maxH)
            countArr[maxH]++
        else
            countArr[count]++

    var total = 0
    for (h in maxH downTo 0) {
        total += countArr[h]
        if (total >= h) return h
    }

    return 0
}