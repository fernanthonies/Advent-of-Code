package common

open class Grid<T>(width: Int, height: Int, init: (Int) -> T): Any() {
    protected val grid: MutableList<MutableList<T>>

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

    fun print() {
        for (y in 0 until grid.size) {
            for (x in 0 until grid[y].size) {
                print(grid[x][y])
            }
            println()
        }
    }
}

class PaddedGrid<T>(width: Int, height: Int, init: (Int) -> T): Grid<T>(width + 2, height + 2, init)