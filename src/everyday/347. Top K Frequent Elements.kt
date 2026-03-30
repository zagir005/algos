package everyday

import java.util.PriorityQueue
import kotlin.comparisons.compareByDescending

private fun topKFrequent(nums: IntArray, k: Int): IntArray {
    val numsHash = HashMap<Int,Int>()
    val ans = PriorityQueue<Pair<Int, Int>>(compareByDescending {
        it.second
    })

    nums.forEach { i ->
        numsHash.getOrPut(i) { 0 }
        numsHash[i] = numsHash[i]!! + 1
    }

    numsHash.forEach {
        ans.offer(Pair(it.key, it.value))
    }

    return IntArray(k) {
        ans.poll().first
    }
}