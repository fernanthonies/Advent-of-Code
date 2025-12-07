package year2025.Days

import BaseDay
import common.Grid
import common.Point

class Day7: BaseDay() {
    override fun solvePartOne(): String {
        var beams = mutableSetOf<Int>()
        val grid = Grid.fromStringInput(input)
        val start = grid.rows().first().indexOf("S")
        var sum = 0
        beams.add(start)
        grid.rows().forEach { r ->
            val nextRow = mutableSetOf<Int>()
            beams.forEach { b ->
                if (r[b] == "^") {
                    sum++
                    nextRow.add(b - 1)
                    nextRow.add(b + 1)
                } else {
                    nextRow.add(b)
                }
            }
            beams = nextRow
        }

        return sum.toString()
    }

    override fun solvePartTwo(): String {
        var timelines = mutableMapOf<Int, Long>()
        val grid = Grid.fromStringInput(input)
        val start = grid.rows().first().indexOf("S")

        timelines[start] = 1
        grid.rows().forEach { r ->
            val nextRow = mutableMapOf<Int, Long>()
            timelines.forEach { pos, count ->
                if (r[pos] == "^") {
                    nextRow[pos - 1] = nextRow.getOrDefault(pos - 1, 0) + count
                    nextRow[pos + 1] = nextRow.getOrDefault(pos + 1, 0) + count
                } else {
                    nextRow[pos] = nextRow.getOrDefault(pos, 0) + count
                }
            }
            timelines = nextRow
        }

        return timelines.values.sum().toString()
    }
}