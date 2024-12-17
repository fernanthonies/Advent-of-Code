package year2024.Days

import BaseDay
import common.Grid
import common.Point

class Day12: BaseDay() {
    override fun solvePartOne(): String {
        val grid = Grid.fromStringInput(input)

        val visited = mutableListOf<Point>()
        val areas = mutableListOf<MutableList<Point>>()
        grid.forEachIndexed { s, p ->
            if (p !in visited) {
                val area = mutableListOf<Point>()
                val open = mutableListOf(p)
                while(open.any()) {
                    val next = open.removeFirst()
                    visited.add(next)
                    area.add(next)
                    open.addAll(next.adjacentPoints().filter { ap -> grid.getOrNull(ap) == s && ap !in visited && ap !in open })
                }
                areas.add(area)
            }
        }

        return areas.sumOf { list ->
            val count = list.count()
            val perimeter = list.sumOf { p ->
                p.adjacentPoints().count { ap -> grid.getOrNull(ap) != grid[p] }
            }
            val product = count * perimeter
            product
        }.toString()
    }

    override fun solvePartTwo(): String {
        val grid = Grid.fromStringInput(input)

        val visited = mutableListOf<Point>()
        val areas = mutableListOf<MutableList<Point>>()
        grid.forEachIndexed { s, p ->
            if (p !in visited) {
                val area = mutableListOf<Point>()
                val open = mutableListOf(p)
                while(open.any()) {
                    val next = open.removeFirst()
                    visited.add(next)
                    area.add(next)
                    open.addAll(next.adjacentPoints().filter { ap -> grid.getOrNull(ap) == s && ap !in visited && ap !in open })
                }
                areas.add(area)
            }
        }

        

        return ""
    }
}