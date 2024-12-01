package year2021.Days

import BaseDay
import common.Point
import common.Point3

class Day2: BaseDay() {
    override fun solvePartOne(): String {
        val position = Point(0,0)
        input.forEach { line ->
            when(line.split(" ")[0]) {
                "forward" -> position.x += line.split(" ")[1].toInt()
                "up" -> position.y -= line.split(" ")[1].toInt()
                "down" -> position.y += line.split(" ")[1].toInt()
            }
        }
        return (position.x * position.y).toString()
    }

    override fun solvePartTwo(): String {
        val position = Point3(0,0,0)
        input.forEach { line ->
            val X = line.split(" ")[1].toInt()
            when(line.split(" ")[0]) {
                "forward" -> {
                    position.x += X
                    position.y += position.z * X
                }
                "up" -> position.z -= X
                "down" -> position.z += X
            }
        }
        return (position.x * position.y).toString()
    }
}