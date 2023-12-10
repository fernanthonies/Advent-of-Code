package common

class Point(val x: Int, val y: Int): Any() {
    fun adjacentPoints(allowDiagonal: Boolean = false): Set<Point> {
        val result = mutableSetOf<Point>()
        result.add(Point(x, y - 1))
        result.add(Point(x, y + 1))
        result.add(Point(x - 1, y))
        result.add(Point(x + 1, y))
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

    override fun equals(other: Any?): Boolean {
        return other is Point && other.x == x && other.y == y
    }

    override fun hashCode(): Int {
        var result = x
        result = 31 * result + y
        return result
    }
}