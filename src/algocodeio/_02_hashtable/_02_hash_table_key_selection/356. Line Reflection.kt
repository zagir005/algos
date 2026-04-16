package algocodeio._02_hashtable._02_hash_table_key_selection

import kotlin.math.max
import kotlin.math.min

/**
    Для удобства для точек сделаю data class Point

    нужно будет проверять симметрию по X
    что бы это сделать нужно найти крайнюю левую и правую точки
    тогда можно вычислить симметричную точку по формуле lX + rX - x
    например:
    есть точка с координатой X=1
    lX = 1
    rX = 4
    1 + 4 - 1 = 4, это и будет X координата симметричной точки. Если точка с такой
    координатой есть в массиве, значит точки в массиве симметричны

    в Point реализовал функцию getSymmetricX, по ней можно будет получить
    симметричную для этого Point'а x-координату

    надо будет проходиться по points Set'у и искать точку с таким же y и симметричным X
    если вдруг такого не будет, то выкидываем false

    O(n) - потому что проходимся по всем точкам
    O(n) - потому что выделяется память на set с точками
 */

data class Point(val x: Int, val y: Int){
    fun getSymmetricX(l: Int, r: Int): Int = l + r - x
}

fun isSymmetric(points: List<List<Int>>): Boolean{
    //в points координаты стоят в порядке - [x,y]

    // X-координаты крайних левой и правой точек
    var lX: Int = points[0][0]
    var rX: Int = points[0][0]
    points.forEach {
        lX = min(lX, it[0])
        rX = max(rX, it[0])
    }

    val pointsSet = HashSet<Point>()
    points.forEach { pList ->
        pointsSet.add(Point(pList[0], pList[1]))
    }

    pointsSet.forEach { point ->
        if (
            !pointsSet.contains(
                Point(
                    x = point.getSymmetricX(lX, rX),
                    y = point.y
                )
            )
        ) return false
    }

    return true
}

fun main(){
    println(
        isSymmetric(
            listOf(
                listOf(1,2),
                listOf(3,1),
                listOf(4,2),
                listOf(2,1),
                listOf(2,1),
            )
        )
    )
}