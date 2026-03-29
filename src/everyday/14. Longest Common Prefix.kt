package everyday

private fun longestCommonPrefix(strs: Array<String>): String {
    var endIndex = strs[0].length

    strs.forEach { s ->
        for (i in 0 until minOf(endIndex, s.length)) {
            if (strs[0][i] != s[i]) {
                endIndex = i
                return@forEach
            }
        }
        endIndex = minOf(endIndex, s.length)
    }

    return strs[0].substring(0, endIndex)
}