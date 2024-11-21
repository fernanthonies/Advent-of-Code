package year2022.Days

import BaseDay

class DaySix : BaseDay() {
    override fun solvePartOne(): String {
        return findSignalStart(input.first()).toString()
    }

    override fun solvePartTwo(): String {
        return findMessageStart(input.first()).toString()
    }

    fun findSignalStart(input: String): Int {
        return findStart(input, 4)
    }

    fun findMessageStart(input: String): Int {
        return findStart(input, 14)
    }

    private fun findStart(input: String, numUnique: Int): Int {
        var start = 0
        while (input.substring(start, start + numUnique).toCharArray().distinct().count() != numUnique) {
            start++
        }
        return start + numUnique
    }
}