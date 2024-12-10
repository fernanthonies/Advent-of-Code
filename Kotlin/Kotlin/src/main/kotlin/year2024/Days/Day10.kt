package year2024.Days

import BaseDay
import common.Grid

class Day10: BaseDay() {
    override fun solvePartOne(): String {
        val grid = Grid.fromStringInput(input)
        var sum = 0
        grid.forEachIndexed { s, p ->
            if (s == "0") {
                var previous = setOf(p)
                for (i in 1..9) {
                    previous =
                        previous.flatMap { prev -> prev.adjacentPoints(false).filter { grid.getOrNull(it)?.toInt() == i } }.toSet()
                }
                sum += previous.count()
            }
        }

        return sum.toString()
    }

    override fun solvePartTwo(): String {
        val grid = Grid.fromStringInput(input)
        var sum = 0
        grid.forEachIndexed { s, p ->
            if (s == "0") {
                var previous = listOf(p)
                for (i in 1..9) {
                    previous =
                        previous.flatMap { prev -> prev.adjacentPoints(false).filter { grid.getOrNull(it)?.toInt() == i } }
                }
                sum += previous.count()
            }
        }

        return sum.toString()
    }
}