package year2024.Days

import BaseDay
import common.Grid
import common.Point

class Day15: BaseDay() {
    private lateinit var grid: Grid<String>
    val walls = mutableListOf<Point>()
    val boxes = mutableListOf<Point>()
    val boxes2 = mutableListOf<Pair<Point, Point>>()
    override fun solvePartOne(): String {
        val grid = input.subList(0, input.indexOf(""))
        val instructions = input.subList(input.indexOf("")+1, input.size)

        var robit = Point(0,0)

        grid.forEachIndexed { y, s ->
            s.forEachIndexed { x, c ->
                when(c) {
                    '#' -> walls.add(Point(x, y))
                    'O' -> boxes.add(Point(x, y))
                    '@' -> robit = Point(x, y)
                }
            }
        }

        instructions.flatMap { it.toCharArray().toList() }.forEach { ins ->
            val dir = when(ins) {
                '>' -> Point.Direction.E
                '<' -> Point.Direction.W
                '^' -> Point.Direction.N
                'v' -> Point.Direction.S
                else -> throw Error()
            }

            if (shmove(robit + dir.p, dir)) {
                robit += dir.p
            }
        }

        return boxes.sumOf { (it.y * 100) + it.x }.toString()
    }

    override fun solvePartTwo(): String {
        val grid = input.subList(0, input.indexOf(""))
        val instructions = input.subList(input.indexOf("")+1, input.size)
        walls.clear()

        var robit = Point(0,0)

        grid.forEachIndexed { y, s ->
            s.forEachIndexed { x, c ->
                when(c) {
                    '#' -> {
                        walls.add(Point(x*2, y))
                        walls.add(Point((x*2)+1, y))
                    }
                    'O' -> boxes2.add(Pair(Point(x*2, y), Point((x*2)+1, y)))
                    '@' -> robit = Point(x*2, y)
                }
            }
        }

        var g = Grid(grid.first().length * 2, grid.size) { x, y ->
            when (Point(x, y)) {
                robit -> "@"
                in boxes2.map { it.first } -> "["
                in boxes2.map { it.second } -> "]"
                in walls -> "#"
                else -> "."
            }
        }
        println(g.toString())
        println()

        instructions.flatMap { it.toCharArray().toList() }.forEach { ins ->
            val dir = when(ins) {
                '>' -> Point.Direction.E
                '<' -> Point.Direction.W
                '^' -> Point.Direction.N
                'v' -> Point.Direction.S
                else -> throw Error()
            }

            // trying to recursively check and move at the same time, as in part 1, led to many edge cases in part 2
            // that were not in the example input.  Not pretty, but it ended up working
            if (recursiveCanMove(robit + dir.p, dir)) {
                recursiveMove(robit + dir.p, dir)
                robit += dir.p
            }
        }

        return boxes2.sumOf {
            (it.first.y * 100) + it.first.x
        }.toString()
    }

    private fun shmove(p: Point, d: Point.Direction): Boolean {
        if (walls.contains(p)) {
            return false
        } else if(boxes.contains(p)) {
            val i = boxes.indexOf(p)
            return if (shmove(p + d.p, d)) {
                boxes[i] += d.p
                true
            } else {
                false
            }
        }
        return true
    }

    private fun recursiveCanMove(p: Point, d: Point.Direction): Boolean {
        if (walls.contains(p)) {
            return false
        } else if (boxes2.any { it.first == p || it.second == p }) {
            val i = boxes2.indexOfFirst { it.first == p || it.second == p }
            val b = boxes2[i]
            return if ( (d in listOf(Point.Direction.N, Point.Direction.S) &&
                (recursiveCanMove(b.first + d.p, d) && recursiveCanMove(b.second + d.p, d)))
                || (d == Point.Direction.E && recursiveCanMove(b.second + d.p, d))
                || (d == Point.Direction.W && recursiveCanMove(b.first + d.p, d))
                ) {
                true
            } else {
                false
            }
        }
        return true
    }

    private fun recursiveMove(p: Point, d: Point.Direction) {
        if (boxes2.any { it.first == p || it.second == p }) {
            val i = boxes2.indexOfFirst { it.first == p || it.second == p }
            val b = boxes2[i]
            when (d) {
                Point.Direction.N, Point.Direction.S -> {
                    recursiveMove(b.first + d.p, d)
                    recursiveMove(b.second + d.p, d)
                }
                Point.Direction.E -> recursiveMove(b.second + d.p, d)
                Point.Direction.W -> recursiveMove(b.first + d.p, d)
            }
            boxes2[i] = Pair(b.first + d.p, b.second + d.p)
        }
    }
}