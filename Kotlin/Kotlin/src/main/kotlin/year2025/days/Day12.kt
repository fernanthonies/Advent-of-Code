package year2025.Days

import BaseDay
import com.sun.org.apache.xpath.internal.operations.Bool
import common.AnsiColor
import common.Grid
import common.Point
import common.colorize

class Day12: BaseDay() {
    var presents = mutableListOf<List<Grid<String>>>()
    var pSizes = mutableListOf<Int>()

    override fun solvePartOne(): String {
        presents = mutableListOf<List<Grid<String>>>()
        pSizes = mutableListOf<Int>()
        input.take(30).chunked(5).forEach { chunk ->
            val g = Grid.fromStringInput(chunk.drop(1).take(3))
            val g1 = g.rotated()
            val g2 = g1.rotated()
            val g3 = g2.rotated()
            presents.add(listOf(g, g1, g2, g3))
            pSizes.add(g.count { s, _ -> s == "#" })
        }

        var sum = 0
        for (line in input.drop(30)) {
            val gridSize = line.split(":")[0].split("x").map { it.toInt() }
            val pCounts = line.split(":")[1].trim().split(" ").map { it.toInt() }
            val totalNeeded = pSizes.zip(pCounts).fold(0) { acc, pair -> acc + (pair.first * pair.second) }
            val totalSpace = gridSize.reduce { acc, i -> acc * i }
            val totalNeededLoose = pCounts.reduce { acc, i -> acc + (i * 9) }
            if ( totalSpace < totalNeeded) {
                continue
            } else if (totalSpace >= totalNeededLoose) {
                sum += 1
                continue
            }

            val toPlace = pCounts.mapIndexed { index, i -> List(i) { index } }.flatten()
            val region = Grid(gridSize[0], gridSize[1]) { x, y -> ".".colorize(AnsiColor.WHITE)}
            if (placePresent(0, region, toPlace, Point(0,0))) {
                sum += 1
            }
        }

        return sum.toString()
    }

    override fun solvePartTwo(): String {
        return "Finished!!"
    }

    fun placePresent(index: Int, region: Grid<String>, toPlace: List<Int>, current: Point): Boolean {
        if (index > toPlace.size - 1) return true
        val present = presents[toPlace[index]]
        val fit = present.firstOrNull {
            canFit(region, it, current)
        }

        if (fit != null) {
            region.add(fit, current)
            region.print()
            println()
            return if (placePresent(index + 1, region, toPlace, Point(0, 0))) {
                true
            } else {
                region.remove(fit, current)
                region.print()
                println()
                region.nextPoint(current)?.let {
                    placePresent(index, region, toPlace, it)
                } ?: false
            }
        } else {
            return region.nextPoint(current)?.let {
                placePresent(index, region, toPlace, it)
            } ?: false
        }
    }

    fun canFit(region: Grid<String>, present: Grid<String>, searchPoint: Point): Boolean {
        return !present.anyIndexed { t, p ->
            t == "#" && (region.getOrNull(p + searchPoint) ?: "#") == "#"
        }
    }

    fun Grid<String>.add(subGrid: Grid<String>, p: Point) {
        subGrid.forEachIndexed { s, sp ->
            if (s.contains('#')) {
                this[p + sp] = "#"
            }
        }
    }

    fun Grid<String>.remove(subGrid: Grid<String>, p: Point) {
        subGrid.forEachIndexed { s, sp ->
            if (s.contains('#')) {
                this[p + sp] = "."
            }
        }
    }

    fun Grid<String>.nextPoint(p: Point): Point? {
        return this.firstIndex { string, new ->
            (new > p) //&& string == "."
        }
    }

    operator fun Point.compareTo(other: Point): Int {
        return if (x == other.x && y == other.y) {
            0
        } else if (y < other.y) {
            -1
        } else if (y == other.y) {
            if (x < other.x) {
                -1
            } else {
                1
            }
        } else {
            1
        }
    }
}