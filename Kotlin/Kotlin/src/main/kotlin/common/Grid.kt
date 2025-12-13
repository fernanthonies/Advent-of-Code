package common

import com.sun.org.apache.xpath.internal.operations.Bool

@OptIn(ExperimentalStdlibApi::class)
open class Grid<T>(val width: Int, val height: Int, init: (Int, Int) -> T): Any() {
    protected val grid: MutableList<MutableList<T>> = MutableList(height) { y ->
        MutableList(width) { x -> init(x, y) }
    }

    constructor(source: Grid<T>) : this(source.width, source.height, { x, y -> source[y, x]})
    constructor(source: List<List<T>>) : this(source[0].size, source.size, { x, y -> source[y][x] })

    operator fun get(point: Point): T = get(point.x, point.y)

    operator fun get(x: Int, y: Int): T = grid[y][x]

    fun getOrNull(x: Int, y: Int): T? {
        return if (x in 0..<width && y in 0..<height) {
            get(x, y)
        } else {
            null
        }
    }

    fun getOrNull(point: Point): T? = getOrNull(point.x, point.y)

    operator fun set(point: Point, value: T) = set(point.x, point.y, value)

    operator fun set(x: Int, y: Int, value: T) {
        grid[y][x] = value
    }

    fun rows(): List<List<T>> = grid

    fun columns(): List<List<T>> = transposed().rows()

    fun forEach(func: (T) -> Unit) {
        grid.forEach { col ->
            col.forEach { p ->
                func(p)
            }
        }
    }

    fun forEachIndexed(func: (T, p: Point) -> Unit) {
        grid.forEachIndexed { y, col ->
            col.forEachIndexed { x, p ->
                func(p, Point(x, y))
            }
        }
    }

    fun forEachIndexed(func: (T, x: Int, y: Int) -> Unit) {
        grid.forEachIndexed { y, col ->
            col.forEachIndexed { x, p ->
                func(p, x, y)
            }
        }
    }

    fun any(func: (T) -> Boolean): Boolean {
        grid.forEach { col ->
            col.forEach { p ->
                if (func(p)) return true
            }
        }
        return false
    }

    fun anyIndexed(func: (T, p: Point) -> Boolean): Boolean {
        grid.forEachIndexed { y, col ->
            col.forEachIndexed { x, p ->
                if (func(p, Point(x, y))) return true
            }
        }
        return false
    }

    fun first(func: (T) -> Boolean): T? {
        grid.forEachIndexed { y, col ->
            col.forEachIndexed { x, p ->
                if (func(p)) return p
            }
        }
        return null
    }

    fun firstIndexed(func: (T, p: Point) -> Boolean): T? {
        grid.forEachIndexed { y, col ->
            col.forEachIndexed { x, p ->
                if (func(p, Point(x, y))) return p
            }
        }
        return null
    }

    fun firstIndex(func: (T, p:Point) -> Boolean): Point? {
        grid.forEachIndexed { y, col ->
            col.forEachIndexed { x, p ->
                if (func(p, Point(x, y))) return Point(x, y)
            }
        }
        return null
    }

    fun count(func: (T, p: Point) -> Boolean): Int {
        var result = 0
        grid.forEachIndexed { y, col ->
            col.forEachIndexed { x, p ->
                if (func(p, Point(x, y))) result += 1
            }
        }
        return result
    }

    fun count(func: (T, x: Int, y: Int) -> Boolean): Int {
        var result = 0
        grid.forEachIndexed { y, col ->
            col.forEachIndexed { x, p ->
                if (func(p, x, y)) result += 1
            }
        }
        return result
    }

    override fun toString(): String {
        var s = ""
        for (y in grid) {
            for (x in y) {
                s += x
            }
            s += "\n"
        }
        return s
    }

    fun transposed(): Grid<T> {
        return Grid(height, width) { x, y ->
            get(y, x)
        }
    }

    fun rotated(): Grid<T> {
        return Grid(height, width) { x, y ->
            get(y, width - 1 - x)
        }
    }

    fun print() {
        for (y in 0 until grid.size) {
            for (x in 0 until grid[y].size) {
                print("${grid[y][x]} ")
            }
            println()
        }
    }

    companion object {
        fun fromStringInput(input: List<String>): Grid<String> {
            return Grid(input[0].length, input.size) {x, y ->
                input[y][x].toString()
            }
        }

        fun fromStringInputToChar(input: List<String>): Grid<Char> {
            return Grid(input[0].length, input.size) {x, y ->
                input[y][x].toChar()
            }
        }
    }
}

class PaddedGrid<T>(width: Int, height: Int, init: (Int, Int) -> T): Grid<T>(width + 2, height + 2, init)