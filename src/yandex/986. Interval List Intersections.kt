package yandex
/**
тут явно нужно two pointers юзать, ибо два массива.
Во-первых надо решить как получать перечесение двух интервалов.
Например: a = [0,2]; b = [1,5]; output = [1,2]
output[0] = max(a[0], b[0]) = 1
output[1] = min(a[1], b[1]) = 2
но, если b[0], например, равен 5, то он уже выходит за пределы интервала, соответственно
нам нужно 'a' заменить на следующий интервал, то же самое и наоборот.

споткнулся об то, что один массив может пересекаться с двумя другими
что бы решить проблему добавил в IntersectionResult.Intersect поле moveA:
если true, то сдвигаем A, иначе B

O(n + m)
O(1)
1hr
30% - медленнее остальных из-за лишних абстракций, when.
 */


private fun intervalIntersection(firstList: Array<IntArray>, secondList: Array<IntArray>): Array<IntArray> {
    var fP = 0
    var sP = 0
    val ansArr = mutableListOf<IntArray>()

    while(fP < firstList.size && sP < secondList.size){
        val intersect = firstList[fP].intersection(secondList[sP])
        when (intersect) {
            is IntersectionResult.Intersect -> {
                ansArr.add(intersect.interval)
                if (intersect.moveA) fP++ else sP++
            }
            IntersectionResult.MoveA -> fP++
            IntersectionResult.MoveB -> sP++
        }
    }
    return ansArr.toTypedArray()
}

/**
Возвращает intersect двух массивов
либо тот, pointer на который нужно сдвинуть (наименьший)
 */
private fun IntArray.intersection(b: IntArray): IntersectionResult {
    val a = this
    val start = maxOf(a[0], b[0])
    val end = minOf(a[1], b[1])

    return if (start <= end)
        IntersectionResult.Intersect(
            intArrayOf(start, end),
            moveA = a[1] < b[1]
        )
    else if (a[1] < b[1])
        IntersectionResult.MoveA
    else
        IntersectionResult.MoveB
}

sealed class IntersectionResult {
    data class Intersect(val interval: IntArray, val moveA: Boolean) : IntersectionResult()
    object MoveA : IntersectionResult()
    object MoveB : IntersectionResult()
}