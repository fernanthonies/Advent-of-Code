package year2023.Days

import BaseDay
import common.lcmOfArray

class DayNine(input: List<String>) : BaseDay(input) {

    override fun solvePartOne(): String {
        var sum = 0
        for (line in input) {
            sum += findNextNumber(line.split(" ").map { it.toInt() }.toTypedArray())
        }
        return sum.toString()
    }

    override fun solvePartTwo(): String {
        var sum = 0
        for (line in input) {
            sum += findPreviousNumber(line.split(" ").map { it.toInt() }.toTypedArray())
        }
        return sum.toString()
    }

    fun findNextNumber(input: Array<Int>): Int {
        if (!input.any { it != 0 }) {
            return 0
        }
        val newArray = Array(input.count() - 1) { 0 }
        for (i in 1 until input.count()) {
            newArray[i - 1] = input[i] - input[i - 1]
        }
        val childLast = findNextNumber(newArray)
        return input.last() + childLast
    }

    fun findPreviousNumber(input: Array<Int>): Int {
        if (!input.any { it != 0 }) {
            return 0
        }
        val newArray = Array(input.count() - 1) { 0 }
        for (i in 1 until input.count()) {
            newArray[i - 1] = input[i] - input[i - 1]
        }
        val childFirst = findPreviousNumber(newArray)
        return input.first() - childFirst
    }
}