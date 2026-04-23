package algocodeio._03_arrays_and_matrix._01_thesimpler_thebetter

/**
крч идея в том, что aP у нас будет идти впереди и указывать на наибольшее число,
а bP просто подбирать за ним. Если найдем число равное aP, то запишем в bP

по началу обозначал индексами, в итоге убрал, прост напрямую число сохраняю
 */
private fun maxProduct(nums: IntArray): Int {
    var max = 0
    var min = 0

    for (num in nums)
        if (num > max) {
            min = max
            max = num
        } else if (num > min) {
            min = num
        }

    return (max - 1) * (min - 1)
}