package lc.quest.array1

/**
 * Просто подсчет стрика единичек в бинарном массиве. Нужно найти максимальный стрик (идущие друг за другом единички)
 * мое решение оказалось медленее лучшего из-за доп. проверки после цикла
 * можно избежать если в if чекать именно i==1
 */
private fun findMaxConsecutiveOnes(nums: IntArray): Int {
    var maxStreak = 0
    var currStreak = 0
    for(i in nums){
        if(i == 0){
            if(currStreak > maxStreak) maxStreak = currStreak
            currStreak = 0
        }
        else
            currStreak++
    }
    if(currStreak > maxStreak) maxStreak = currStreak
    return maxStreak
}