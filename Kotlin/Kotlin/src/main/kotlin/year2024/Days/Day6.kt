package year2024.Days

import BaseDay
import common.Grid
import common.Point

@OptIn(ExperimentalStdlibApi::class)
class Day6: BaseDay() {
    private lateinit var grid: Grid<String>
    override fun solvePartOne(): String {
        var direction: Direction = Direction.N
        val h = input.size
        val w = input[0].length
        val visitedPoints = mutableSetOf<Point>()

        var current = Point(0,0)
        grid = Grid.fromStringInput(input)
        loop@for (y in 0..<h) {
            for (x in 0..<w) {
                if (grid[x, y] == "^") {
                    current = Point(x, y)
                    break@loop
                }
            }
        }

        visitedPoints.add(current)
        do {
            if (grid[current + direction.d] == "#") {
                direction = direction.next()
            } else {
                current += direction.d
                visitedPoints.add(current)
            }
        } while ((current + direction.d).x >= 0 && (current + direction.d).y >= 0 && (current + direction.d).x < w && (current + direction.d).y < h)

        return visitedPoints.size.toString()
    }

    override fun solvePartTwo(): String {
        var direction: Direction = Direction.N
        val h = input.size
        val w = input[0].length
        val loopOneVisitedPoints = mutableSetOf<Point>()

        var current = Point(0,0)
        var start = Point(0, 0)
        grid = Grid.fromStringInput(input)
        loop@for (y in 0..<h) {
            for (x in 0..<w) {
                if (grid[x, y] == "^") {
                    current = Point(x, y)
                    start = current
                    break@loop
                }
            }
        }

        // populate visited list
        loopOneVisitedPoints.add(current)
        do {
            if (grid[current + direction.d] == "#") {
                direction = direction.next()
            } else {
                current += direction.d
                loopOneVisitedPoints.add(current)
            }

        } while ((current + direction.d).x >= 0 && (current + direction.d).y >= 0 && (current + direction.d).x < w && (current + direction.d).y < h)

        var sum = 0
        loopOneVisitedPoints.drop(1).forEach { vp ->
            val visitedPoints = mutableSetOf<Pair<Point, Direction>>()
            current = start
            direction = Direction.N
            do {
                if (grid[current + direction.d] == "#" || (current + direction.d) == vp) {
                    direction = direction.next()
                } else {
                    current += direction.d
                    if (visitedPoints.any { it.first == current && it.second == direction }) {
                        sum += 1
                        break
                    }
                    visitedPoints.add(Pair(current, direction))
                }
            } while ((current + direction.d).x >= 0 && (current + direction.d).y >= 0 && (current + direction.d).x < w && (current + direction.d).y < h)
        }
        return sum.toString()
    }

    enum class Direction(val d: Point) {
        N(Point(0, -1)) {
            override fun next(): Direction {
                return E
            }
        },
        S(Point(0, 1)) {
            override fun next(): Direction {
                return W
            }
        },
        E(Point(1, 0)) {
            override fun next(): Direction {
                return S
            }
        },
        W(Point(-1, 0)) {
            override fun next(): Direction {
                return N
            }
        };

        abstract fun next(): Direction
    }
}