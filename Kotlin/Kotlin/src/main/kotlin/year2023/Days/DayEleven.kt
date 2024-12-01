package year2023.Days

import BaseDay
import common.Point
import common.manhattanDistance

class DayEleven : BaseDay() {

    val galaxies: MutableList<Point> = mutableListOf()
    var expandedRows: List<Int> = listOf()
    var expandedCols: List<Int> = listOf()

    init {
        for ((y, line) in input.withIndex()) {
            for ((x, value) in line.withIndex()) {
                if (value == '#') {
                    galaxies.add(Point(x, y))
                }
            }
        }

        expandedCols = (0 until input[0].length).toList().minus(galaxies.map { it.x }.distinct().toSet())
        expandedRows = (0 until input.count()).toList().minus(galaxies.map { it.y }.distinct().toSet())
    }

    override fun solvePartOne(): String {
        return solve(1).toString()
    }

    override fun solvePartTwo(): String {
        return solve(999999).toString()
    }

    private fun solve(expansion: Int): Long {
        var sum: Long = 0

        val pairs = mutableListOf<Pair<Point, Point>>()
        for (i in 0 until galaxies.count()) {
            for (j in i + 1 until galaxies.count()) {
                pairs.add(Pair(galaxies[i], galaxies[j]))
            }
        }

        for (pair in pairs) {
            val (g1, g2) = pair
            val xRange = if (g1.x < g2.x) (g1.x until g2.x) else (g2.x until g1.x)
            val colExpansion = xRange.toList().intersect(expandedCols.toSet()).count() * expansion
            val yRange = if (g1.y < g2.y) (g1.y until g2.y) else (g2.y until g1.y)
            val rowExpansion = yRange.toList().intersect(expandedRows.toSet()).count() * expansion

            val distance = manhattanDistance(g1, g2) + colExpansion + rowExpansion
            sum += distance
        }

        return sum
    }
}