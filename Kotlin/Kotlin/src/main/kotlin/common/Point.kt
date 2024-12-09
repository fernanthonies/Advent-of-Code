package common

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
}