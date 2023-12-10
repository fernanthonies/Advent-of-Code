package common

class Grid<T>(width: Int, height: Int, init: (Int) -> T): Any() {
    private val grid: MutableList<MutableList<T>>

    init {
        grid = MutableList(width) {
            MutableList(height, init)
        }
    }

    operator fun get(point: Point): T {
        return get(point.x, point.y)
    }

    operator fun set(point: Point, value: T) {
        set(point.x, point.y, value)
    }

    operator fun get(x: Int, y: Int): T {
        return grid[x][y]
    }

    operator fun set(x: Int, y: Int, value: T) {
        grid[x][y] = value
    }
}