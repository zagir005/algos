package algocodeio._01_twopointers._03_fast_and_slow

import garbage.ds.ListNode

/**
    two pointers, fast and slow
    fs у нас проходится вперед, выдавая тем самым количество элементов
    sl у нас идет до ноды fs/2

    оказалось можно еще лучше решить, просто в цикле fsNode = fsNode.next.next, в то время как sl.next
    т.к. fs у нас будет идти в два раза быстрее, то slNode окажется прямо на середине
    что бы не вызвать next у null элемента проверяем это предварительно в условии цикла

    в сравнении с первым решением не нужно лишний раз проходится по нодам
    O(n)
    O(1)
*/

private fun middleNode(head: ListNode?): ListNode? {
    var sl = head
    var fs = head
    while(fs != null && fs.next != null){
        sl = sl?.next
        fs = fs?.next?.next
    }

    return sl
}