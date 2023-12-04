package year2023.Days

import BaseDay

class DayOne(input: List<String>) : BaseDay(input) {
    override fun solvePartOne(): String {
        return input.solve().toString()
    }

    override fun solvePartTwo(): String {
        val mutableInput = input.toMutableList()
        for ((i, line) in input.withIndex()) {
            var newString = line
            for (num in Numbers.values()) {
                var lookupStart = 0
                var index = newString.indexOf(num.string, lookupStart)
                while (index != -1) {
                    newString = newString.addCharAtIndex(num.digit.toString().first(), index+1)
                    lookupStart = index + 2
                    index = newString.indexOf(num.string, lookupStart)
                }
            }
            mutableInput[i] = newString
        }

        return mutableInput.solve().toString()
    }

    private fun List<String>.solve(): Int {
        var sum = 0
        this.forEach {
            val first = it.filter { c -> c.isDigit() }.first()
            val last = it.filter { c -> c.isDigit() }.last()
            val num = "${first}${last}".toInt()
            sum += num
        }
        return sum
    }

    private fun String.addCharAtIndex(char: Char, index: Int) =
        StringBuilder(this).apply { insert(index, char) }.toString()

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