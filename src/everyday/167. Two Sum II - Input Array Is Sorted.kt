package everyday

/**
 * Author: zagir
 * Created: 25.03.2026 09:05
 * Task: 167. Two Sum II - Input Array Is Sorted
 *
 * Algorithm complexity: у цикла в цикла O(n^2), у двух указателей O(n)
 * Memory complexity: O(1) в обоих решениях
 * Time to solve: цикл в цикле - from 9:10 to 9:32, два указателя from 9:44 to 10:04
 *
 * Description: крч надо найти индексы двух чисел, сумма которых будет равна таргету.
 * сам массив отсортирован и в нем обязательно есть эти два числа.
 * решить надо с memory complexity O(1)
 *
 * Notes: первое решение конченное получилось, 5% бьет, два цикла while.
 * второе уже лучше, с двумя указателями. тут нужно использовать то, что массив отсортирован.
 * если прибавили left и right и получился перебор, соответственно нужно уменьшать right.
 * если недобор, то увеличивать left. и таким образом приходим к target.
 * в lc бьет 18%, просмотрел более быстрые и единственная разница в том, в каком порядке стоят указатели
 * все таки очевидно, что result==target.
 * еще вместо lastIndex вписал size-1
 * и использовал else
 * в итоге бьет 97%
 *
 * Tags: Two pointers
 */

private fun twoSum(numbers: IntArray, target: Int): IntArray {
    var left = 0
    while (true) {
        var right = numbers.lastIndex

        while (left < right) {
            if (numbers[left] + numbers[right] == target) return intArrayOf(left + 1, right + 1)
            right--
        }

        left++
    }
}

private fun twoSumTwoPointer (numbers: IntArray, target: Int): IntArray {
    var left = 0
    var right = numbers.size - 1
    while (left < right) {
        val result = numbers[left] + numbers[right]
        when{
            result > target -> right--
            result < target -> left++
            else -> return intArrayOf(left + 1, right + 1)
        }
    }
    throw IllegalStateException("что у вас тут происходит")
}