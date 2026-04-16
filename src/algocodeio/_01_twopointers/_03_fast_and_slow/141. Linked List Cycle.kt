package algocodeio._01_twopointers._03_fast_and_slow

import garbage.ds.ListNode

/**
    если нарисовать движения быстрого и медленного указателя по нодам (каждую итерацию, ноды с циклом)
    то можно заметить, что быстрая обязательно попадет на медленную, таким образом доказывая что
    у нас есть цикл

    O(n)
    O(1)
*/

private fun hasCycle(head: ListNode?): Boolean {
    if(head == null || head?.next == null) return false

    var sl = head
    var fs = head

    while(fs?.next != null){
        sl = sl?.next
        fs = fs.next?.next
        if(fs == sl) return true
    }

    return false
}