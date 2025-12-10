package year2025.Days

import BaseDay
import common.Line
import common.Point
import kotlin.math.abs

class Day9: BaseDay() {
    override fun solvePartOne(): String {
        val tiles = input.map {
            val (x, y) = it.split(",").map { s -> s.toInt() }
            Point(x, y)
        }
        val areas = mutableListOf<Long>()
        for (i in 0..tiles.size - 1) {
            for (j in i..tiles.size - 1) {
                if (i != j) areas.add(((abs(tiles[i].x - tiles[j].x) + 1L) * (abs(tiles[i].y - tiles[j].y) + 1L)))
            }
        }
        return areas.max().toString()
    }

    override fun solvePartTwo(): String {
        // Look away... I'm hideous!
        var maxX = 0
        var maxY = 0

        val tiles = input.map {
            val (x, y) = it.split(",").map { s -> s.toInt() }
            if (x > maxX) maxX = x
            if (y > maxY) maxY = y
            Point(x, y)
        }
        maxX += 1
        val edges = mutableListOf<Line>()
        for (i in 1..tiles.size - 1) {
            edges.add(Line(tiles[i].x, tiles[i].y, tiles[i-1].x, tiles[i-1].y))
        }
        edges.add(Line(tiles[0].x, tiles[0].y, tiles[tiles.size - 1].x, tiles[tiles.size - 1].y))
        val vertEdges = edges.filter { it.alignment == Line.Alignment.VERTICAL }
        val horzEdges = edges.filter { it.alignment == Line.Alignment.HORIZONTAL }

        val areas = mutableListOf<Long>()
        for (i in 0..tiles.size - 1) {
            for (j in i..tiles.size - 1) {
                if (i != j) {
                    val p1 = tiles[i]
                    val p2 = tiles[j]
                    if (p1.x == p2.x || p1.y == p2.y) continue
                    val ip1 = Point(p1.x, p2.y)
                    val ip2 = Point(p2.x, p1.y)
                    val areaEdges = listOf(Line(p1, ip1), Line(p1, ip2), Line(p2, ip1), Line(p2, ip2))
                    val corners = listOf(p1, p2, ip1, ip2)
                    val ip1OnOrIn = edges.any {
                        it.isPointOnLine(ip1)
                    } || vertEdges.count { e -> Line(ip1.x, ip1.y, maxX, ip1.y).intersect(e) } % 2 == 1
                    val ip2OnOrIn = edges.any {
                        it.isPointOnLine(ip2)
                    } || vertEdges.count { e -> Line(ip2.x, ip2.y, maxX, ip2.y).intersect(e) } % 2 == 1

                    if (ip1OnOrIn && ip2OnOrIn) {
                        val hIntersections = areaEdges.filter { it.alignment == Line.Alignment.HORIZONTAL }.any { h ->
                            vertEdges.any { v ->
                                h.intersection(v)?.let { i ->
                                    !corners.contains(i) && ((((h.isPointOnLine(v.p1) || h.isPointOnLine(v.p2)) && v.inBox(corners))) || ((i.y in (v.y1)..< v.y2) && (i.x in (h.x1)..< h.x2)))
                                } ?: false
                            }
                        }
                        val vIntersections = areaEdges.filter { it.alignment == Line.Alignment.VERTICAL }.any { v ->
                            horzEdges.any { h ->
                                v.intersection(h)?.let { i ->
                                    !corners.contains(i) && ((((v.isPointOnLine(h.p1) || v.isPointOnLine(h.p2))) && h.inBox(corners)) || ((i.x in (h.x1)..< h.x2) && (i.y in (v.y1)..< v.y2)))
                                } ?: false
                            }
                        }

                        if (!hIntersections && !vIntersections) {
                            val area = ((abs(p1.x - p2.x) + 1L) * (abs(p1.y - p2.y) + 1L))
                            areas.add(area)
                        }
                    }
                }
            }
        }
        return areas.max().toString()
    }
}