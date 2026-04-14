package lc.array2

import kotlin.math.abs

/**
 * Вроде задача помечена как легкая, но далась тяжело, за O(n log n) смог решить через сортировку только.
 * За O(n) уже пошел за подсказками к чату гпт.
 *
 * По самому условию задачи стоит отметить, что nums[i] >= 1, тут чат гпт подсказал лайфхак:
 * Пометка числа: Можно nums[i] = nums[i] *= -1, тогда мы как-бы "помечаем" число, при этом не теряя его
 * (можно получить обратно через abs(nums[i]), благодаря этому не нужно тратиться на лишний массив
 *
 * Решение гпт оказалось не самым быстрым, быстрее использовать booleanArr в качестве карты чисел.
 *
 */

fun main(){
    println(
        findErrorNums(
            nums = intArrayOf(1,2,2,4)
        ).joinToString()
    )
}

private fun findErrorNums(nums: IntArray): IntArray {
    var duplicate = -1
    var missing = -1

    for (num in nums) {
        val index = abs(num) - 1
        if (nums[index] < 0) {
            duplicate = abs(num)
        } else {
            nums[index] *= -1
        }
    }

    for (i in nums.indices) {
        if (nums[i] > 0) {
            missing = i + 1
        }
    }

    return intArrayOf(duplicate, missing)
}

/**
 * Создаем seen: BooleanArr, проходимся по массиву for(num in nums), и в boolean по индексу num (представим, что в nums две двойки)
 * помечаем true, на каждой итерации проверяем, если seen[num] уже true, значит мы нашли дубликат.
 * стоит отметить что у seen мы размер указали nums.size+1, делается это что бы удобно потом проходится по нему
 * при поиске missing числа, т.к. в nums[i] у нас числа от единицы. То есть, мы просто приводим массив к удобному для условий задачи виду.
 *
 *
*/

fun findErrorNumsBooleanArr(nums: IntArray): IntArray {
    val seen = BooleanArray(nums.size + 1)
    var duplicate = 0
    var missing = 0

    for (num in nums) {
        if (seen[num]) {
            duplicate = num
            break
        }
        seen[num] = true
    }

    for (i in 1..nums.size) {
        if (!seen[i]) {
            missing = i
            break
        }
    }

    return intArrayOf(duplicate, missing)
}