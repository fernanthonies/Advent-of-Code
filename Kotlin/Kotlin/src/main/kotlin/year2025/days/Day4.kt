package year2025.Days

import BaseDay
import common.Grid

class Day4: BaseDay() {
    override fun solvePartOne(): String {
        val grid = Grid.fromStringInput(input)
        return grid.count { s, p -> s == "@" && p.adjacentPoints(allowDiagonal = true, allowCross = true).count { n -> grid.getOrNull(n) == "@" } < 4 }.toString()
    }

    override fun solvePartTwo(): String {
        val grid = Grid.fromStringInput(input)
        // recursively for shits and giggles
        return removeRolls(grid).toString()
    }

    fun removeRolls(grid: Grid<String>): Int {
        var removed = 0
        grid.forEachIndexed { s, p ->
            if (s == "@" && p.adjacentPoints(allowDiagonal = true, allowCross = true).count { n -> grid.getOrNull(n) == "@" } < 4) {
                removed += 1
                grid[p] = "."
            }
        }
        return if (removed > 0) {
            removed += removeRolls(grid)
            removed
        } else {
            removed
        }
    }
}