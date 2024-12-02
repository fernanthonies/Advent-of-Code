package year2024.Days

import BaseDay
import common.dropIndex
import kotlin.math.abs
import kotlin.math.sign

class Day2: BaseDay() {
    override fun solvePartOne(): String {
        var sum = 0
        input.forEach {line ->
            val intLine = line.split(" ").map { c -> c.toInt() }
            if(isReportSafe(intLine)) {
                sum++
            }
        }
        return sum.toString()
    }

    override fun solvePartTwo(): String {
        var sum = 0
        input.forEach { line ->
            val lineCount = line.count { c -> c == ' ' }
            if (isReportSafe(line.split(" ").map { c -> c.toInt() })) {
                sum++
            } else {
                for (i in 0..lineCount) {
                    val newList = line.split(" ").map { c -> c.toInt() }.dropIndex(i)
                    if (isReportSafe(newList)) {
                        sum++
                        break
                    }
                }
            }
        }
        return sum.toString()
    }

    private fun isReportSafe(input: List<Int>): Boolean {
        val diffs = input.zipWithNext().map { it.second - it.first }
        return diffs.map { it.sign }.distinct().count() == 1 && diffs.all { abs(it) in 1..3 }
    }
}