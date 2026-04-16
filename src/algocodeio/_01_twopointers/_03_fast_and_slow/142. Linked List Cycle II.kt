package algocodeio._01_twopointers._03_fast_and_slow

import garbage.ds.ListNode

/**
если мы хотим понять что находимся в цикле то полюбому придется
крутить sl и fs указатели по кругу
по идее из того что они в цикле крутятся можно вывести кол-во
итераций, размер цикла. зная размер цикла вряд-ли можно получить
начало цикла.

крч без подсказки и блокнота не получилось решить:
в момент совпадения нод у fs и sl:
один поинтер начиная с head двигаем на +1
другой поинтер начиная с совпавшей ноды тоже двигаем на +1
тогда они столкнутся ровно на начале цикла

в начало буду сдвигать sl
 */
private fun detectCycle(head: ListNode?): ListNode? {
    var sl = head
    var fs = head

    while(fs?.next != null){
        fs = fs.next?.next
        sl = sl?.next

        if(fs == sl){
            fs = head
            while(fs != sl){
                fs = fs?.next
                sl = sl?.next
            }
            return fs
        }
    }

    return null
}