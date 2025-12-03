package year2025.Days

import BaseDay
import common.indicesOf
import kotlin.text.indexOf

class Day3: BaseDay() {
    override fun solvePartOne(): String {
        return solveInternal(2).toString()
    }

    override fun solvePartTwo(): String {
        return solveInternal(12).toString()
    }

    private fun solveInternal(batteryCount: Int): Long {
        var sum = 0L

        input.forEach { line ->
            var voltage = ""

            var lastIndex = 0
            while(voltage.length < batteryCount) {
                val ints = line.substring(lastIndex, line.length - (batteryCount - voltage.length - 1)).map { it.toString().toLong() }.toLongArray()
                val maxIndex = ints.indices.maxBy { ints[it] }
                voltage += "${ints[maxIndex]}"
                lastIndex += maxIndex + 1
            }
            sum += voltage.toLong()
        }

        return sum
    }
}