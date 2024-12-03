package year2024.Days

import BaseDay
import common.dropIndex

class Day2: BaseDay() {
    override fun solvePartOne(): String {
        return input.map { it.split(" ").map { c -> c.toInt() } }.fold(0) { s, line -> s + if(isReportSafe(line)) 1 else 0 }.toString()
    }

    override fun solvePartTwo(): String {
        return input
            .map { it.split(" ").map { c -> c.toInt() } }
            .fold(0) { s, line ->
                s + (if ((0..line.size - 1).any { isReportSafe(line.dropIndex(it)) }) 1 else 0)
            }.toString()
    }

    private fun isReportSafe(input: List<Int>): Boolean {
        val diffs = input.zipWithNext().map { it.second - it.first }.toSet()
        return setOf(1, 2, 3).containsAll(diffs) || setOf(-1, -2, -3).containsAll(diffs)
    }
}