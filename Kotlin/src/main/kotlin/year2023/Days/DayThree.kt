package year2023.Days

import BaseDay

class DayThree(input: List<String>) : BaseDay(input) {
    override fun solvePartOne(): String {
        var sum = 0
        input.forEachIndexed { yIndex, s ->
            var digitFound = false
            var number = ""
            var startIndex = 0
            s.forEachIndexed { xIndex, c ->
                if (digitFound) {
                    if (c.isDigit()) {
                        number += c
                    } else {
                        sum += processNumber(number, startIndex, yIndex, s)

                        //finished
                        number = ""
                        digitFound = false
                    }
                } else {
                    if (c.isDigit()) {
                        digitFound = true
                        startIndex = xIndex
                        number += c
                    }
                }
            }
            if (digitFound) {
                sum += processNumber(number, startIndex, yIndex, s)
            }
        }
        return sum.toString()
    }

    override fun solvePartTwo(): String {
        var sum = 0
        val partNumbers: MutableList<PartNumber> = mutableListOf()
        input.forEachIndexed { yIndex, s ->
            var digitFound = false
            var number = ""
            var startIndex = 0
            s.forEachIndexed { xIndex, c ->
                if (digitFound) {
                    if (c.isDigit()) {
                        number += c
                    } else {
                        partNumbers.add(PartNumber(number.toInt(), Pair(startIndex, yIndex)))
                        //finished
                        number = ""
                        digitFound = false
                    }
                } else {
                    if (c.isDigit()) {
                        digitFound = true
                        startIndex = xIndex
                        number += c
                    }
                }
            }
            if (digitFound) {
                partNumbers.add(PartNumber(number.toInt(), Pair(startIndex, yIndex)))
            }
        }

        input.forEachIndexed { yIndex, s ->
            s.forEachIndexed { xIndex, c ->
                if (c == '*') {
                    val adjacent = partNumbers.filter {
                        yIndex in (it.startIndex.second - 1)..(it.startIndex.second + 1) &&
                        xIndex in (it.startIndex.first - 1)..(it.startIndex.first + it.length)
                    }
                    if (adjacent.count() > 1) {
                        sum += adjacent.map { it.value } .reduce { acc, partNumber -> acc * partNumber }
                    }
                }
            }
        }

        return sum.toString()
    }

    private fun processNumber(number: String, startIndex: Int, yIndex: Int, s: String): Int {
        val numLength = number.length
        var test = ""
        val startXIndex = if (startIndex > 0) startIndex - 1 else startIndex
        val endXIndex = if (startIndex + numLength == s.count()) 0 else 1
        if (yIndex > 0) test += input[yIndex - 1].substring(startXIndex, startIndex + numLength + endXIndex)
        if (startIndex > 0) test += s[startIndex - 1]
        if (startIndex + numLength <= s.length - 1) test += s[startIndex + numLength]
        if (yIndex < input.count() - 1) test += input[yIndex + 1].substring(startXIndex, startIndex + numLength + endXIndex)

        return if (test.any { !it.isDigit() && it != '.' }) {
            number.toInt()
        } else {
            0
        }
    }

    data class PartNumber(val value: Int, val startIndex: Pair<Int, Int>, val length: Int = value.toString().length)
}