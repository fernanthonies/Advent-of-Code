package year2024.Days

import BaseDay
import common.Grid
import common.Point
import kotlin.math.abs

class Day18: BaseDay() {
    val W: Int = 71
    val H: Int = 71
    val steps: Int = 1024

    override fun solvePartOne(): String {
        var start = Point(0,0)
        var end = Point(W-1,H-1)
        val grid = Grid(W, H) { _, _ -> "." }

        for (i in 0..<steps) {
            val coords = input[i].split(",").map { it.toInt() }
            grid[Point(coords[0], coords[1])] = "#"
        }
        println(grid.toString())
        println()

        val open = mutableListOf<Node>()
        val closed = mutableSetOf<Pair<Point, Point.Direction>>()

        open.add(Node(start, Point.Direction.E, null))

        val ANSI_BLUE = "\u001B[34m"
        val ANSI_RESET = "\u001B[0m"
        val ANSI_RED = "\u001B[31m"
        val ANSI_GREEN = "\u001B[32m"

        var final = 0
        astar@while (open.any()) {
            open.sortBy { it.f }
            val q = open.removeFirst()
            for(i in 0..<q.point.adjacentPoints().size) {
                val it = q.point.adjacentPoints().toList()[i]
                val dir = Point.Direction.fromPoint(it - q.point)!!
                if ((grid.getOrNull(it) == "." || grid.getOrNull(it) == "E") && Pair(it, dir) !in closed) {
                    val s = Node(it, dir, q)
                    s.g = q.g + 1

                    if (s.point == end) {
                        final = s.g

                        open.forEach {
                            grid[it.point] = ANSI_GREEN + grid[it.point] + ANSI_RESET
                        }

                        closed.forEach {
                            if (grid[it.first] !in listOf("S", "E")) {
                                grid[it.first] = ANSI_RED + grid[it.first] + ANSI_RESET
                            }
                        }

                        var parent = s.parent
                        while (parent != null) {
                            grid[parent.point] = ANSI_BLUE + "O" + ANSI_RESET
                            parent = parent.parent
                        }
                        print(grid.toString())
                        break@astar
                    }

                    s.h = abs(s.point.x - end.x) + abs(s.point.y - end.y)

                    if (!open.any {
                            it.point == s.point && it.f < s.f
                        }) {
                        open.add(s)
                    }
                }
            }
            closed.add(Pair(q.point, q.dir))
        }

        return final.toString()
    }

    override fun solvePartTwo(): String {
        return ""
    }

    class Node(val point: Point, val dir: Point.Direction, val parent: Node?) {
        val f: Int
            get() = g + h
        var g: Int = 0
        var h: Int = 0
    }
}