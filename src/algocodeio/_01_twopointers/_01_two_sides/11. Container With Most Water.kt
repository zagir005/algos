package algocodeio._01_twopointers._01_two_sides

import kotlin.math.min

/**
    крч у нас есть формула вычисления объема воды: min(height[l], height[r]) * (r - l)
    будем проходиться двумя поинтерами и проверять на каждой итерации по этой формуле
    стал ли больше объем воды, если больше то обновляем ans. В конце отдаем результат вычисления

    то, что в algocode сразу формулу дают сильно упрощает

    в lc мое решение бьет только 24%. посмотрел лучшее решение, как я понял там
    невыгодные варианты сразу скипаются без лишних вычислений. Условно, у нас лучший
    l = 5, если нам попался l < 5 нам не нужно лиший раз считать объем по формуле

*/
private fun maxArea(height: IntArray): Int {
    var ans = 0
    var l = 0
    var r = height.lastIndex

    while(l < r){
        val lHeight = height[l]
        val rHeight = height[r]
        var calc = min(lHeight, rHeight) * (r - l)
        if(calc > ans) ans = calc
        if(lHeight < rHeight) l++
        else r--
    }
    return ans
}