package lc.daily_question

import kotlin.math.abs
import kotlin.math.min

/**
    По идее нам просто надо пройтись по всему массиву, узнать индексы вхождений target в words
    и потом вычислить расстояние от startIndex до target строки, выдав наименьшую из них.
    Важно отметить, что массив циклический, то есть мы можем от индекса 0 дойти до lastIndex
    просто смещаясь влево. То есть, считать расстояние до target стоит в обе стороны.

    Формула для расчета мин. дистанции:
    min(abs(i - startIndex), words.size - abs(i - startIndex))

    По времени: O(n)
    По памяти: O(1)

    с первого раза 100% побил на lc, 29мин. на задачу ушло (но там грязными)
*/

private fun closestTarget(words: Array<String>, target: String, startIndex: Int): Int {
    var minDistance = Int.MAX_VALUE
    for(i in words.indices){
        val word = words[i]
        if(word == target){
            val distance = min(abs(i - startIndex), words.size - abs(i - startIndex))
            if(distance < minDistance)
                minDistance = distance
        }
    }
    if(minDistance == Int.MAX_VALUE) minDistance = -1
    return minDistance
}