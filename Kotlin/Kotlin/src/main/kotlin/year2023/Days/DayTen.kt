package year2023.Days

import BaseDay
import common.Grid
import common.PaddedGrid
import common.Point

class DayTen : BaseDay() {

    val w: Int
    val h: Int
    private lateinit var startCoords: Point

    private val grid: PaddedGrid<Char>

    init {
        w = input[0].length
        h = input.count()

        grid = PaddedGrid(w, h) { _, _ -> '.' }

        for ((y, line) in input.withIndex()) {
            for ((x, value) in line.withIndex()) {
                grid[x + 1, y + 1] = value
                if (value == 'S') startCoords = Point(x+1, y+1)
            }
        }
    }

    override fun solvePartOne(): String {
        val nextCoords = startCoords.adjacentPoints().filter {
            when(grid[it.x, it.y]) {
                '|' -> grid[it.x, it.y - 1] == 'S' || grid[it.x, it.y + 1] == 'S'
                '-' -> grid[it.x + 1, it.y] == 'S' || grid[it.x - 1, it.y] == 'S'
                'L' -> grid[it.x, it.y - 1] == 'S' || grid[it.x + 1, it.y] == 'S'
                'J' -> grid[it.x, it.y - 1] == 'S' || grid[it.x - 1, it.y] == 'S'
                '7' -> grid[it.x, it.y + 1] == 'S' || grid[it.x - 1, it.y] == 'S'
                'F' -> grid[it.x, it.y + 1] == 'S' || grid[it.x + 1, it.y] == 'S'
                '.' -> false
                'S' -> false
                else -> false
            }
        }

        var (n1, n2) = nextCoords
        var n1Last = startCoords
        var n2Last = startCoords

        var distance = 1
        while (n1 != n2 && (n1 != n2Last && n2 != n1Last)) {
            val n1Next = pointChanges(grid[n1]).map { it + n1 }.first { it != n1Last }
            n1Last = n1
            n1 = n1Next

            val n2Next = pointChanges(grid[n2]).map { it + n2 }.first { it != n2Last }
            n2Last = n2
            n2 = n2Next
            distance++
        }

        return distance.toString()
    }

    override fun solvePartTwo(): String {
        val nextCoords = startCoords.adjacentPoints().filter {
            when(grid[it.x, it.y]) {
                '|' -> grid[it.x, it.y - 1] == 'S' || grid[it.x, it.y + 1] == 'S'
                '-' -> grid[it.x + 1, it.y] == 'S' || grid[it.x - 1, it.y] == 'S'
                'L' -> grid[it.x, it.y - 1] == 'S' || grid[it.x + 1, it.y] == 'S'
                'J' -> grid[it.x, it.y - 1] == 'S' || grid[it.x - 1, it.y] == 'S'
                '7' -> grid[it.x, it.y + 1] == 'S' || grid[it.x - 1, it.y] == 'S'
                'F' -> grid[it.x, it.y + 1] == 'S' || grid[it.x + 1, it.y] == 'S'
                '.' -> false
                'S' -> false
                else -> false
            }
        }

        val printGrid = Grid(w + 2, h + 2) {  _, _ -> " ." }
        val loop = mutableListOf<Point>()
        var (n) = nextCoords
        var nLast = startCoords
        while (n != startCoords) {
            printGrid[n] = " ${grid[n]}"
            loop.add(n)
            val n1Next = pointChanges(grid[n]).map { it + n }.first { it != nLast }
            nLast = n
            n = n1Next
        }

        val filteredLoop = loop.filter { listOf('-', 'F', 'L').contains(grid[it]) }
        var count = 0
        for (x in 0 until w) {
            for (y in 0 until h) {
                if (loop.contains(Point(x, y))) continue
                var crossings = 0
                for (test in 0 until y) {
                    if (filteredLoop.contains(Point(x, test))) {
                        crossings++
                    }
                }
                count += if (crossings % 2 == 0) 0 else 1
            }
        }

        return count.toString()
    }

    fun pointChanges(pipe: Char): List<Point> {
        return when(pipe) {
            '|' -> listOf(Point(0, 1), Point(0, -1))
            '-' -> listOf(Point(1, 0), Point(-1, 0))
            'L' -> listOf(Point(0, -1), Point(1, 0))
            'J' -> listOf(Point(0, -1), Point(-1, 0))
            '7' -> listOf(Point(0, 1), Point(-1, 0))
            'F' -> listOf(Point(0, 1), Point(1, 0))
            else -> listOf()
        }
    }
}