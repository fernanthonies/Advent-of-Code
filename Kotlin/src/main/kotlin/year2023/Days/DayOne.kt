package year2023.Days

import BaseDay

class DayOne(input: List<String>) : BaseDay(input) {
    override fun solvePartOne(): String {
        var sum = 0
        input.forEach {
            val first = it.filter { c -> c.isDigit() }.first()
            val last = it.filter { c -> c.isDigit() }.last()
            val num = "${first}${last}".toInt()
            sum += num
        }
        return sum.toString()
    }

    override fun solvePartTwo(): String {
        var sum = 0
        input.forEach { input ->
            var firstDigit = 0
            var lastDigit = 0
            if (input.any { c -> c.isDigit() }) {
                firstDigit = input.first { c -> c.isDigit() }.digitToInt()
                lastDigit = input.last { c -> c.isDigit() }.digitToInt()
            }
            var firstDigitIndex = indexOfOrNull(input, firstDigit.toString()) ?: 999
            var lastDigitIndex = indexOfOrNull(input, lastDigit.toString()) ?: -999
            Numbers.values().forEach {
                input.firstIndexOf(it.string)?.let { firstIndex ->
                    if (firstIndex < firstDigitIndex) {
                        firstDigit = it.digit
                        firstDigitIndex = firstIndex
                    }
                }
                input.lastIndexOf(it.string)?.let { lastIndex ->
                    if (lastIndex > lastDigitIndex) {
                        lastDigit = it.digit
                        lastDigitIndex = lastIndex
                    }
                }
            }
            val num = "${firstDigit}${lastDigit}".toInt()
            sum += num
            println("$input - ${firstDigit}${lastDigit}")
        }
        return sum.toString()
    }

    private fun String.firstIndexOf(subString: String): Int? {
        return indexOfOrNull(this, subString)
    }

    private fun String.lastIndexOf(subString: String): Int? {
        val reversed = this.reversed()
        val subReversed = subString.reversed()
        return indexOfOrNull(reversed, subReversed)?.let {
            this.length - it - subString.length
        }
    }

    private fun indexOfOrNull(string: String, subString: String): Int? {
        val index = string.indexOf(subString)
        return if (index < 0) {
            null
        } else {
            index
        }
    }

    enum class Numbers(val string: String, val digit: Int) {
        One("one", 1),
        Two("two", 2),
        Three("three", 3),
        Four("four", 4),
        Five("five", 5),
        Six("six", 6),
        Seven("seven", 7),
        Eight("eight", 8),
        Nine("nine", 9),
    }
}