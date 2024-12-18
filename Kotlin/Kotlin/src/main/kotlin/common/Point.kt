package common

import kotlin.math.abs

class Point(var x: Int, var y: Int): Any() {
    fun adjacentPoints(allowDiagonal: Boolean = false, allowCross: Boolean = true): Set<Point> {
        val result = mutableSetOf<Point>()
        if (allowCross) {
            result.add(Point(x, y - 1))
            result.add(Point(x, y + 1))
            result.add(Point(x - 1, y))
            result.add(Point(x + 1, y))
        }
        if (allowDiagonal) {
            result.add(Point(x - 1, y - 1))
            result.add(Point(x + 1, y + 1))
            result.add(Point(x - 1, y + 1))
            result.add(Point(x + 1, y - 1))
        }
        return result
    }

    operator fun plus(other: Point): Point {
        return Point(this.x + other.x, this.y + other.y)
    }

    operator fun minus(other: Point): Point {
        return Point(this.x - other.x, this.y - other.y)
    }

    operator fun times(other: Int): Point {
        return Point(this.x * other, this.y * other)
    }

    override fun equals(other: Any?): Boolean {
        return other is Point && other.x == x && other.y == y
    }

    override fun hashCode(): Int {
        var result = x
        result = 31 * result + y
        return result
    }

    enum class Direction(val p: Point) {
        N(Point(0, -1)) {
            override fun cw(): Direction = E
            override fun ccw(): Direction = W
            override fun opp(): Direction = S
        },
        E(Point(1, 0)) {
            override fun cw(): Direction = S
            override fun ccw(): Direction = N
            override fun opp(): Direction = W
        },
        S(Point(0, 1)) {
            override fun cw(): Direction = W
            override fun ccw(): Direction = E
            override fun opp(): Direction = N
        },
        W(Point(-1, 0)) {
            override fun cw(): Direction  = N
            override fun ccw(): Direction = S
            override fun opp(): Direction = E
        };

        fun differenceTo(other: Direction): Int {
            return when (abs(this.ordinal - other.ordinal)) {
                0 -> 0   // Same direction
                2 -> 2   // 180 degrees
                else -> 1 // 90 degrees (E to N or similar)
            }
        }

        abstract fun cw(): Direction
        abstract fun ccw(): Direction
        abstract fun opp(): Direction

        companion object {
            fun fromPoint(point: Point): Direction? {
                return entries.find { it.p == point }
            }
        }
    }
}