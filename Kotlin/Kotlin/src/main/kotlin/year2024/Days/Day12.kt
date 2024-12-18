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
                p.adjacentPoints().count { ap -> ap !in list }
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

        var sum = 0
        areas.forEach { area ->
            val edges = area.flatMap { point ->
                point.adjacentPoints().filter { it !in area }.map { ap ->
                    point to Point.Direction.fromPoint(ap - point)
                }
            }
            var sides = 0
            edges.forEach { e ->
                sides += if (edges.any {
                    it.first == (e.first + e.second!!.cw().p) && it.second == e.second
                }) {
                    0
                } else {
                    1
                }
            }

            sum += sides * area.count()
        }

        return sum.toString()
    }
}