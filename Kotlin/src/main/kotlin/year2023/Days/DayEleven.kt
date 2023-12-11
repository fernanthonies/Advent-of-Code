package year2023.Days

import BaseDay
import common.Grid
import common.PaddedGrid
import common.Point
import kotlin.math.abs

class DayEleven(input: List<String>) : BaseDay(input) {

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
        var sum = 0
        for (galaxy in galaxies) {
            for (otherGalaxy in galaxies) {
                if (galaxy == otherGalaxy) {
                    continue
                }

                //check if any expanded rows/cols in range, and incrememnt length
                val xRange = (galaxy.x until otherGalaxy.x).toList().intersect(expandedCols).count()
                val yRange = (galaxy.y until otherGalaxy.y).toList().intersect(expandedRows).count()

                val distance = abs(galaxy.x - otherGalaxy.x) + abs(galaxy.y - otherGalaxy.y) + xRange + yRange
                sum += distance
            }
        }

        return sum.toString()
    }

    override fun solvePartTwo(): String {
        return ""
    }
}