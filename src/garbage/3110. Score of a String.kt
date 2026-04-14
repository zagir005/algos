package garbage

import kotlin.math.abs

/**
 * Author: zagir
 * Created: 24.03.2026 09:52
 * Task: 3110. Score of a String
 *
 * Algorithm complexity: O(n) - т.к. один раз проходимся по массиву и все
 * Memory complexity: O(1) - у нас там память выделяется только под переменную цикла и переменную sum. Т.к. они
 * никак не масштабируются с увеличем размера входного массива, то и memory complexity у нас остается константной.
 * Time to solve: from 10:21 to 10:33
 *
 * Description: создаю отдельную переменную для хранения итоговой суммы. Прохожусь циклом по строке, за исключением
 * последнего символа, в цикле беру абсолютное значение от s[i].code - s[i].code и прибавляю к итоговому sum.
 *
 * Notes: по идее можно еще рекурсией решить, но вряд-ли смысл есть от этого. Такое решение будет только больше
 * памяти занимать.
 */

fun scoreOfString(s: String): Int {
    var sum = 0
    for (i in 0..<s.length - 1) {
        sum += abs(s[i].code - s[i + 1].code)
    }
    return sum
}
