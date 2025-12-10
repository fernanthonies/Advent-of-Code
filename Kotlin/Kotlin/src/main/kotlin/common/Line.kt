package common

/**
 * An axis aligned line segment that is either Horizontal (x1 == x2) or Vertical (y1 == y2)
 * While there are no strict constraints for this, most of the functionality of this type depends
 * on that being the case
 * */
class Line(var x1: Int, var y1: Int, var x2: Int, var y2: Int) {
    constructor(p1: Point, p2: Point): this(p1.x, p1.y, p2.x, p2.y)

    init {
        if (x1 > x2) {
            val temp = x2
            x2 = x1
            x1 = temp
        }
        if (y1 > y2) {
            val temp = y2
            y2 = y1
            y1 = temp
        }
    }

    enum class Alignment {
        HORIZONTAL,
        VERTICAL
    }

    val alignment: Alignment
        get() {
            return if (x1 == x2) {
                Alignment.VERTICAL
            } else {
                Alignment.HORIZONTAL
            }
        }

    val p1: Point
        get() = Point(x1, y1)

    val p2: Point
        get() = Point(x2, y2)

    fun isPointOnLine(x: Int, y: Int): Boolean {
        return if (alignment == Alignment.HORIZONTAL) {
            x in x1..x2 && y == y1
        } else {
            y in y1..y2 && x == x1
        }
    }

    fun isPointOnLine(p: Point): Boolean {
        return isPointOnLine(p.x, p.y)
    }

    fun intersect(other: Line): Boolean {
        return when (alignment) {
            other.alignment -> {
                false
            }
            Alignment.VERTICAL -> {
                x1 in other.x1..other.x2 && other.y1 in y1..y2
            }
            else -> {
                y1 in other.y1..other.y2 && other.x1 in x1..x2
            }
        }
    }

    fun intersection(other: Line): Point? {
        return when (alignment) {
            other.alignment -> {
                null
            }
            Alignment.VERTICAL -> {
                if (x1 in other.x1..other.x2 && other.y1 in y1..y2) {
                    Point(x1, other.y1)
                } else {
                    null
                }
            }
            else -> {
                if (y1 in other.y1..other.y2 && other.x1 in x1..x2) {
                    Point(other.x1, y1)
                } else {
                    null
                }
            }
        }
    }

    fun inBox(box: List<Point>): Boolean {
        return p1.inBox(box) && p2.inBox(box)
    }
}