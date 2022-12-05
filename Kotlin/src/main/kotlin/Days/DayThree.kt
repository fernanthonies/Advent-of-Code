package days

class DayThree(input: List<String>) : BaseDay(input) {
    override fun solvePartOne(): String {
        var total = 0
        input.map { splitString(it) }.forEach { linePair ->
            total += priority(findSharedChar(linePair))
        }
        return total.toString()
    }

    override fun solvePartTwo(): String {
        var total = 0
        input.chunked(3).forEach { chunk ->
            total += priority(findBadgeChar(chunk))
        }
        return total.toString()
    }

    private fun findSharedChar(input: Pair<String, String>): Char {
        val firstList = input.first.toCharArray()
        val secondList = input.second.toCharArray()

        for (first in firstList) {
            if (secondList.contains(first)) {
                return first
            }
            else continue
        }
        throw Error("shared char not found!")
    }

    private fun findBadgeChar(input: List<String>): Char {
        for(first in input.first()) {
            if (input[1].contains(first) && input[2].contains(first)) {
                return first
            }
            else continue
        }
        throw Error("badge char not found!")
    }

    private fun splitString(line: String): Pair<String, String> {
        if (line.count() % 2 != 0) {
            throw Error("string parts aren't equal!")
        }

        val half = line.count() / 2
        return Pair(line.substring(0, half), line.substring(half))
    }

    private fun priority(char: Char): Int {
        val characters = "abcdefghijklmnopqrstuvwxyz".toList()
        val value = characters.indexOf(char.lowercaseChar()) + 1
        return if (char.isUpperCase()) {
            value + 26
        } else {
            value
        }
    }
}

