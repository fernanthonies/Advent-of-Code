package year2024.Days

import BaseDay
import common.Grid
import common.Point

class Day4: BaseDay() {
    private lateinit var grid: Grid<String>
    override fun solvePartOne(): String {
        grid = Grid.fromStringInput(input)

        var sum = 0
        for (y in 0..grid.height-1) {
            for (x in 0..grid.width-1) {
                if (grid[x, y] == "X") {
                    val nearby = Point(x, y).adjacentPoints(true).filter { it.x >= 0 && it.y >= 0 && it.x < grid.width && it.y < grid.height }
                    sum += nearby.filter { grid[it] == "M" }.count { isInLineXMAS(it, it - Point(x, y)) }
                } else {
                    continue
                }
            }
        }
        return sum.toString()
    }

    override fun solvePartTwo(): String {
        grid = Grid.fromStringInput(input)

        var sum = 0
        for (y in 1..grid.height-2) {
            for (x in 1..grid.width-2) {
                if (grid[x, y] == "A") {
                    val nearby = Point(x, y).adjacentPoints(allowDiagonal = true, allowCross = false).map { grid[it] }
                    if (nearby.count { it == "S" } == 2 && nearby.count { it == "M" } == 2 && nearby[0] != nearby[1]) sum += 1
                } else {
                    continue
                }
            }
        }
        return sum.toString()
    }

    private fun isInLineXMAS(p: Point, direction: Point): Boolean {
        val newP = p + direction
        return if (grid[p] == "S") {
            return true
        } else if (newP.x < 0 || newP.y < 0 || newP.x >= grid.width || newP.y >= grid.height) {
            false
        } else if (grid[newP] == grid[p].next()) {
            isInLineXMAS(newP, direction)
        } else {
            false
        }
    }

    fun String.next(): String? {
        return when (this) {
            "X" -> "M"
            "M" -> "A"
            "A" -> "S"
            "S" -> null
            else -> null
        }
    }
}