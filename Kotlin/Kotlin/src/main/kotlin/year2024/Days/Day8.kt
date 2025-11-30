package year2024.Days

import BaseDay
import common.Grid
import common.Point
import common.cartesianProduct

@OptIn(ExperimentalStdlibApi::class)
class Day8: BaseDay() {
    private lateinit var grid: Grid<Char>
    override fun solvePartOne(): String {
        val antinodes = mutableSetOf<Point>()
        grid = Grid.fromStringInputToChar(input)
        val antennas = buildMap {
            grid.forEachIndexed { s, p ->
                if (s != '.') {
                    getOrPut(s)  { mutableListOf(p) }
                }
            }
        }

//        antennas.forEach {
//            it.value.cartesianProduct(it.value).filter { pair -> pair.first != pair.second }.forEach { pair ->
//                val distance = pair.second - pair.first
//                antinodes.add(pair.first - distance)
//                antinodes.add(pair.second + distance)
//            }
//        }
        return antinodes.filter { isPointValid(it) }.size.toString()
    }

    override fun solvePartTwo(): String {
        val antinodes = mutableSetOf<Point>()
        grid = Grid.fromStringInputToChar(input)
        val antennas = buildMap {
            grid.forEachIndexed { s, p ->
                if (s != '.') {
                    getOrPut(s)  { mutableListOf(p) }
                }
            }
        }

//        antennas.forEach {
//            it.value.cartesianProduct(it.value).filter { pair -> pair.first != pair.second }.forEach { pair ->
//                // this isn't really all that efficient, but the problem space is small enough to not really worry about it ¯\_(ツ)_/¯
//                for (i in 0..grid.height) {
//                    val distance = (pair.second - pair.first) * i
//                    antinodes.add(pair.first - distance)
//                    antinodes.add(pair.second + distance)
//                }
//            }
//        }

        return antinodes.filter { isPointValid(it) }.size.toString()
    }

    private fun isPointValid(point: Point): Boolean {
        return point.x in 0..<grid.width && point.y in 0..<grid.height
    }
}