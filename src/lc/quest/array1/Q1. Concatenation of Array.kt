package lc.quest.array1

/**
 * Задача особо смысла не имеет, но я заметил что есть решение быстрее моего.
 * Оно работает за счет System.arraycopy, продублирую его тут
 * Стоит запомнить на будущее, что можно ускорить копирование элементов с помощью этой функции
 * как чатгпт объяснил, это нативный jvm метод, который реализован на плюсах и он просто перекладывает значения в памяти
 * эт быстрее чем цикл и постоянные обращения к массиву, как в моем варианте
 */

private fun getConcatenation(nums: IntArray): IntArray {
    val ans = IntArray(nums.size * 2)
    for(i in nums.indices){
        val curr = nums[i]
        ans[i] = curr
        ans[i + nums.size] = curr
    }
    return ans
}

private fun getConcatenationArrCopy(nums: IntArray): IntArray {
    val conc = IntArray(nums.size * 2)
    System.arraycopy(nums, 0, conc, 0, nums.size)
    System.arraycopy(nums, 0, conc, nums.size, nums.size)
    return conc
}