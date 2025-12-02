package year2025.Days

import BaseDay
import com.sun.org.apache.xpath.internal.operations.Bool
import common.splitInHalf

class Day2: BaseDay() {
    override fun solvePartOne(): String {
        var sum = 0L
        input[0].split(",").map { it -> Pair(it.split("-")[0], it.split("-")[1]) }.forEach { rangePair ->
            val intRange = LongRange(rangePair.first.toLong(), rangePair.second.toLong())
            intRange.forEach { i ->
                if(checkValid(i)) {
                    sum += i
                }
            }
        }
        return sum.toString()
    }

    override fun solvePartTwo(): String {
        var sum = 0L
        input[0].split(",").map { it -> Pair(it.split("-")[0], it.split("-")[1]) }.forEach { rangePair ->
            val intRange = LongRange(rangePair.first.toLong(), rangePair.second.toLong())
            intRange.forEach { i ->
                if(checkForPattern(i)) {
                    sum += i
                }
            }
        }
        return sum.toString()
    }

    fun checkValid(value: Long): Boolean {
        val valString = value.toString()
        val split = valString.splitInHalf()
        return valString.length % 2 == 0 && split.first == split.second
    }

    fun checkForPattern(value: Long): Boolean {
        val valString = value.toString()
        val length = valString.length

        IntRange(1, length / 2).filter { length % it == 0 }.forEach { i ->
            val subString = valString.take(i)
            var check = ""
            repeat(length / i) {
                check += subString
            }
            if (check.toLong() == value) return true
        }
        return false
    }
}