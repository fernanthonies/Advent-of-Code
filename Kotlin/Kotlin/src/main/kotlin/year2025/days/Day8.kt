package year2025.Days

import BaseDay
import common.Point3
import common.euclideanDistance
import kotlin.math.abs
import kotlin.math.pow

class Day8: BaseDay() {
    override fun solvePartOne(): String {
        val points = input.map {
            val (x, y, z) = it.split(",").map { s -> s.toInt() }
            Point3(x, y, z)
        }
        val distances = mutableMapOf<Int, Pair<Int, Int>>()
        for (i in 0..points.size - 1) {
            for (j in i..points.size - 1) {
                if (i != j) distances.put(abs(euclideanDistance(points[i], points[j]).pow(2).toInt()), Pair(i, j))
            }
        }
        val circuits = mutableListOf<MutableSet<Int>>()

        distances.toSortedMap().values.take(1000).forEach { pair ->
            val firstIndex = circuits.indexOfFirst { it.contains(pair.first) }
            val secondIndex = circuits.indexOfFirst { it.contains(pair.second) }

            if (firstIndex >= 0 && secondIndex < 0) {
                circuits[firstIndex].add(pair.second)
            } else if (firstIndex < 0 && secondIndex >= 0) {
                circuits[secondIndex].add(pair.first)
            } else if (firstIndex >= 0) {
                // ensure that we remove the higher index to add to the lower, since everything to the right is
                // re-indexed on removeAt
                if (firstIndex > secondIndex) {
                    val removed = circuits.removeAt(firstIndex)
                    circuits[secondIndex].addAll(removed)
                } else if (secondIndex > firstIndex) {
                    val removed = circuits.removeAt(secondIndex)
                    circuits[firstIndex].addAll(removed)
                } else {
                    //do nothing, they are in the same set
                }
            } else {
                circuits.add(mutableSetOf(pair.first, pair.second))
            }
        }

        return circuits.sortedBy { it.size }.takeLast(3).map { it.size }.reduce { acc, i -> acc * i }.toString()
    }

    override fun solvePartTwo(): String {
        val points = input.map {
            val (x, y, z) = it.split(",").map { s -> s.toInt() }
            Point3(x, y, z)
        }
        val distances = mutableMapOf<Int, Pair<Int, Int>>()
        for (i in 0..points.size - 1) {
            for (j in i..points.size - 1) {
                if (i != j) distances.put(abs(euclideanDistance(points[i], points[j]).pow(2).toInt()), Pair(i, j))
            }
        }
        val circuits = mutableListOf<MutableSet<Int>>()

        val list = distances.toSortedMap().values.toList()
        var pair: Pair<Int, Int>? = null
        for (i in 0..list.size){
            pair = list[i]
            val firstIndex = circuits.indexOfFirst { it.contains(pair.first) }
            val secondIndex = circuits.indexOfFirst { it.contains(pair.second) }

            if (firstIndex >= 0 && secondIndex < 0) {
                circuits[firstIndex].add(pair.second)
            } else if (firstIndex < 0 && secondIndex >= 0) {
                circuits[secondIndex].add(pair.first)
            } else if (firstIndex >= 0) {
                // ensure that we remove the higher index to add to the lower, since everything to the right is
                // re-indexed on removeAt
                if (firstIndex > secondIndex) {
                    val removed = circuits.removeAt(firstIndex)
                    circuits[secondIndex].addAll(removed)
                } else if (secondIndex > firstIndex) {
                    val removed = circuits.removeAt(secondIndex)
                    circuits[firstIndex].addAll(removed)
                } else {
                    //do nothing, they are in the same set
                }
            } else {
                circuits.add(mutableSetOf(pair.first, pair.second))
            }

            if (circuits.size == 1 && circuits[0].size == points.size) {
                break
            }
        }

        return (points[pair!!.first].x.toLong() * points[pair.second].x.toLong()).toString()
    }
}