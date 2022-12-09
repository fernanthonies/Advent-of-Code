package days

class DayNine(input: List<String>) : BaseDay(input)  {

    override fun solvePartOne(): String {
        val head = Point(0, 0)
        val tail = Point(0, 0)
        val tailVisitedPoints = mutableSetOf<String>()

        input.forEach {
            val direction = parseDirection(it)
            val amount = it.split(" ")[1]
            for (i in 1..amount.toInt()) {
                head.move(direction)
                if (tail.isNotAdjacent(head)) {
                    tail.moveTowards(head)
                }
                tailVisitedPoints.add(tail.toString())
            }
        }

        return tailVisitedPoints.count().toString()
    }

    override fun solvePartTwo(): String {
        val knotList = List(10) { Point(0, 0) }

        val tailVisitedPoints = mutableSetOf<String>()

        input.forEach {
            val direction = parseDirection(it)
            val amount = it.split(" ")[1]
            for (i in 1..amount.toInt()) {
                knotList[0].move(direction)
                for(j in 1 until knotList.count()) {
                    if (knotList[j].isNotAdjacent(knotList[j - 1])) {
                        knotList[j].moveTowards(knotList[j - 1])
                    }
                }
                tailVisitedPoints.add(knotList.last().toString())
            }
        }

        return tailVisitedPoints.count().toString()
    }

    private fun parseDirection(input: String): Point {
        return when (input.split(" ")[0]) {
            "U" -> Point(0, 1)
            "D" -> Point(0, -1)
            "L" -> Point(-1, 0)
            "R" -> Point(1, 0)
            else -> throw Error(input.split(" ")[0])
        }
    }

    class Point(private var x: Int, private var y: Int) {
        fun isNotAdjacent(other: Point): Boolean {
            return (kotlin.math.abs(this.x - other.x) > 1 || kotlin.math.abs(this.y - other.y) > 1)
        }

        fun moveTowards(other: Point) {
            if (other.x > this.x) this.x += 1
            if (other.x < this.x) this.x -=1
            if (other.y > this.y) this.y += 1
            if (other.y < this.y) this.y -=1
        }

        fun move(other: Point) {
            this.x += other.x
            this.y += other.y
        }

        override fun toString(): String {
            return "$x, $y"
        }
    }
}