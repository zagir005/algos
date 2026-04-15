package algocodeio._01_twopointers._02_pointer_for_each


/**
По началу подумал что тут стоит двумя указателями пройтись, но это не тот случай
т.к. массив не отсортирован.

в итоге:
создаем хеш мапу counts и в ней считаем дубликаты чисел в nums1
потом проходимся по nums2, если находим num в counts, то закидываем в ans и
уменьшаем в counts значение либо вообще удалеяем если уже равно 0

O(n+m) где n = nums1.size; m = nums2.size
решил за 30мин.

побило только 62%, лучшее решение посмотрел, чел
вместо мапы юзает intArr размером в 1000, крч надо обращать внимания больше
на constraints задачи
 */
fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
    val counts = hashMapOf<Int, Int>()
    for(num in nums1){
        counts[num] = counts.getOrDefault(num, 0) + 1
    }
    val ans = mutableListOf<Int>()
    for(num in nums2){
        if(counts.contains(num)){
            ans.add(num)
            counts[num] = counts[num]!! - 1
            if(counts[num] == 0) counts.remove(num)
        }
    }
    return ans.toIntArray()
}