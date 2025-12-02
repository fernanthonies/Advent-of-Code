package year2025.Days

import BaseDay
import kotlin.math.abs

class Day1 : BaseDay() {
    override fun solvePartOne(): String {
        var sum = 0
        var pointer = 50
        input.forEach { line ->
            val direction = line.substring(0, 1)
            val amount = line.drop(1).toInt() % 100
            val newPointer = when (direction) {
                "R" -> {
                    (pointer + amount) % 100
                }
                "L" -> {
                    val change = pointer - amount
                    if (change < 0) {
                        100 + ((pointer - amount) % 100)
                    } else {
                        change
                    }
                }
                else -> { 0 }
            }
            if (newPointer == 0) sum += 1
            pointer = newPointer
        }
        return sum.toString()
    }

    override fun solvePartTwo(): String {
        var sum = 0
        var pointer = 50
        input.forEach { line ->
            val direction = line.substring(0, 1)
            val amount = line.drop(1).toInt()
            var current = pointer
            when (direction) {
                "R" -> {
                    repeat(amount) {
                        if (current == 99) {
                            current = 0
                        } else {
                            current += 1
                        }
                        if (current == 0) sum += 1
                    }
                }
                "L" -> {
                    repeat(amount) {
                        if (current == 0) {
                            current = 99
                        } else {
                            current -= 1
                        }
                        if (current == 0) sum += 1
                    }
                }
                else -> { 0 }
            }
            pointer = current
        }
        return sum.toString()
    }
}