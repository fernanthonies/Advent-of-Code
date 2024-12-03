package year2024.Days

import BaseDay

class Day3: BaseDay() {
    override fun solvePartOne(): String {
        val fullInput = input.joinToString("")
        val pattern = "mul\\([0-9]+,[0-9]+\\)"
        val digits = "[0-9]+"
        val mulRegex = Regex(pattern)
        val digitRegex = Regex(digits)
        var sum = 0
        val matches = mulRegex.findAll(fullInput)
        sum += matches.map { digitRegex.findAll(it.value).map { d -> d.value.toInt() }.reduce { acc, i -> acc * i } }.reduce { acc, i -> acc + i }
        return sum.toString()
    }

    override fun solvePartTwo(): String {
        val pattern = "mul\\([0-9]+,[0-9]+\\)|do\\(\\)|don't\\(\\)"
        val digits = "[0-9]+"
        val mulRegex = Regex(pattern)
        val digitRegex = Regex(digits)
        var sum = 0
        val fullInput = input.joinToString("")
        var on = true
        val matches = mulRegex.findAll(fullInput).map { it.value }.toList()
        matches.forEach {
            when (it) {
                "do()" -> on = true
                "don't()" -> on = false
                else -> if (on) sum += digitRegex.findAll(it).map { d -> d.value.toInt() }.reduce { acc, i -> acc * i }
            }
        }
        return sum.toString()
    }
}