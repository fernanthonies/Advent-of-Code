package year2024.Days

import BaseDay
import common.Grid
import common.Point

class Day14: BaseDay() {

    val X = 0
    val Y = 1
    val Vx = 2
    val Vy = 3
    val H = 103
    val W = 101
    val Mh = H / 2
    val Mw = W / 2

    override fun solvePartOne(): String {
        val bots = input.map {
            it.split(" ").map { j -> j.split("=")[1] }
                .flatMap { k -> k.split(",") }.map { v -> v.toInt() }
        }

        val newLocations = mutableListOf<Pair<Int, Int>>()
        bots.forEach {b ->
            val x = (b[X] + b[Vx] * 100) % W
            val y = (b[Y] + b[Vy] * 100) % H
            newLocations.add(Pair(if (x < 0) W + x else x,if (y < 0) H + y else y))
        }
        val quadrants = mutableListOf(0, 0, 0, 0)
        newLocations.forEach { loc ->
            when {
                (loc.first < Mw && loc.second < Mh) -> quadrants[0] += 1
                (loc.first > Mw && loc.second < Mh) -> quadrants[1] += 1
                (loc.first < Mw && loc.second > Mh) -> quadrants[2] += 1
                (loc.first > Mw && loc.second > Mh) -> quadrants[3] += 1
            }
        }

        return quadrants.reduce { acc, i -> acc * i }.toString()
    }

    override fun solvePartTwo(): String {
        val bots = input.map {
            it.split(" ").map { j -> j.split("=")[1] }
                .flatMap { k -> k.split(",") }.map { v -> v.toInt() }.toMutableList()
        }

        // I dunno man, just print a bunch of iterations where more than half the bots are near another bot,
        // and just scroll through 'em to find the right one?
        for (i in 0..10000) {
            bots.forEach { bot ->
                val x = (bot[X] + bot[Vx]) % W
                val y = (bot[Y] + bot[Vy]) % H
                bot[X] = if (x < 0) W + x else x
                bot[Y] = if (y < 0) H + y else y
            }
            if (bots.count{b ->
                    Point(b[X], b[Y]).adjacentPoints(allowDiagonal = true).any { p ->
                        bots.any { it[X] == p.x && it[Y] == p.y }
                    }
                } > bots.size / 2) {
                val grid = Grid(W, H) {x, y ->
                    if (bots.any {b -> b[X] == x && b[Y] == y}) "#" else "."
                }
                println("${i},")
                print(grid.toString())
                println()
                println()
            }
        }

        return ""
    }
}