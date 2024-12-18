package year2024.Days

import BaseDay
import common.Grid
import common.Point

class Day16: BaseDay() {
    override fun solvePartOne(): String {
        var start: Point = Point(0,0)
        var end: Point = Point(0,0)
        val grid = Grid(input[0].length, input.size) {x, y ->
            val node = input[y][x].toString()
            when (node) {
                "S" -> start = Point(x, y)
                "E" -> end = Point(x, y)
            }
            node
        }

        val open = mutableListOf<Point>()
        val closed = mutableListOf<Point>()

        open.add(start)

        return ""
    }

    override fun solvePartTwo(): String {
        return ""
    }

    class Node(val point: Point, val dir: Point.Direction) {
        val f: Int
            get() = g + h
        var g: Int = 0
        var h: Int = 0
    }
}