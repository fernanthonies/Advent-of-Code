package year2024.Days

import BaseDay

class Day7: BaseDay() {
    override fun solvePartOne(): String {
        var sum: Long = 0
        input.forEach { line ->
            val target = line.split(":")[0].toLong()
            val numbers = line.split(":")[1].split(" ").drop(1).map { it.toInt() }

            val runner = Solver(target, numbers)
            if (runner.recurse(0, 1)) {
                sum += target
            }
        }
        return sum.toString()
    }

    override fun solvePartTwo(): String {
        var sum: Long = 0
        input.forEach { line ->
            val target = line.split(":")[0].toLong()
            val numbers = line.split(":")[1].split(" ").drop(1).map { it.toInt() }

            val runner = Solver(target, numbers, true)
            if (runner.recurse(0, 1)) {
                sum += target
            }
        }
        return sum.toString()
    }

    class Solver(private val target: Long, private val numbers: List<Int>, private val canConcat: Boolean = false) {
        fun recurse(i: Int, currResult: Long): Boolean {
            if (i == numbers.size) {
                return currResult == target
            }

            if (currResult > target) {
                return false
            }

            val number = numbers[i]
            val add = recurse(i + 1, currResult + number)
            val mult = recurse(i + 1, currResult * number)
            val concat = if (canConcat) recurse(i + 1, "$currResult$number".toLong()) else false

            return add || mult || concat
        }
    }
}