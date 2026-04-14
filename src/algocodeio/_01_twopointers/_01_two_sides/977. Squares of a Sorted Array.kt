package algocodeio._01_twopointers._01_two_sides

/**
Пока не ясно, как я по условию должен понять, что тут нужно использовать two pointers.
Ну и плюс еще т.к. я иду по роадмапе и сейчас прохожу two pointers это уже сама по себе подсказка

Задача в том, что бы отсортированном nums в котором -10^4 <= nums[i] <= 10^4
каждое число возвести во 2 степень и выдать отсортированный массив.

Наибольшие числа (после возведения в степень) у нас будут находится по краям массива, это
говорит о том, что тут стоит решать через два указателя.

Нужно создать ans массив, куда будем складывать новые числа, ибо в изначальном массиве
перекладывать числа без потерь невозможно. Для складывания наибольшего числа в конец массива создадим
указатель ansPointer.
Создадим указатель left и right, в цикле while пока left и right нe "столкнутся" будем возводить
в степень nums[left] и nums[right] и сравнивать. Наибольшее число складывать в ans и смещать
указатель ansPointer и тот указатель (left/right), который указал на наибольшее число.

По заметкам выше все расписал, но есть проблема, в кейсе [-7,-3,2,3,11] последнее число (2) не попадает
в ans. Тупо вместо while цикла использовал repeat(nums.size)

Падает на кейсе [-5,-3,-2,-1] с ArrIndexOutOfBoundsException. Падало потому что при каждой итерации я
 сдвигал pointer и сразу по нему брал число из массива, но если итерация последняя, то выхожу таким образом
 за рамки массива.

 Решение на lc набрало ток 33%
 */

private fun sortedSquares(nums: IntArray): IntArray {
    if(nums.size == 1) return nums.apply{
        val num = nums[0]
        nums[0] = num * num
    }

    val ans = IntArray(nums.size){ 0 }
    var ansPointer = ans.lastIndex

    var leftPointer = 0
    var rightPointer = ans.lastIndex

    var left = nums[leftPointer]
    var right = nums[rightPointer]

    var leftSquare = left * left
    var rightSquare = right * right

    repeat(nums.size){
        if(leftSquare >= rightSquare){
            ans[ansPointer] = leftSquare
            ansPointer--
            leftPointer++
            left = nums.getOrNull(leftPointer) ?: return@repeat
            leftSquare = left * left
        } else {
            ans[ansPointer] = rightSquare
            ansPointer--
            rightPointer--
            right = nums.getOrNull(rightPointer) ?: return@repeat
            rightSquare = right * right
        }
    }


    return ans
}


fun main(){
    println(
        sortedSquares(
            intArrayOf(-5,-3,-2,-1)
        )
    )
}