package year2024.Days

import BaseDay
import common.Grid
import common.Point
import kotlin.math.abs

class Day16: BaseDay() {
    override fun solvePartOne(): String {
        var start = Point(0,0)
        var end = Point(0,0)
        val grid = Grid(input[0].length, input.size) {x, y ->
            val node = input[y][x].toString()
            when (node) {
                "S" -> start = Point(x, y)
                "E" -> end = Point(x, y)
            }
            node
        }

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
                    s.g = q.g + (1 + (q.dir.differenceTo(s.dir) * 1))

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
                        while (grid[parent!!.point] != "S") {
                            grid[parent.point] = ANSI_BLUE + when (parent.dir) {
                                Point.Direction.N -> "^"
                                Point.Direction.S -> "V"
                                Point.Direction.E -> ">"
                                Point.Direction.W -> "<"
                            } + ANSI_RESET
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