package common

@OptIn(ExperimentalStdlibApi::class)
open class Grid<T>(val width: Int, val height: Int, init: (Int, Int) -> T): Any() {
    protected val grid: MutableList<MutableList<T>>

    init {
        grid = MutableList(height) { y ->
            MutableList(width) { x -> init(x, y) }
        }
    }

    constructor(source: Grid<T>) : this(source.width, source.height, { x, y -> source[y, x]})

    operator fun get(point: Point): T {
        return get(point.x, point.y)
    }

    operator fun set(point: Point, value: T) {
        set(point.x, point.y, value)
    }

    operator fun get(x: Int, y: Int): T {
        return grid[y][x]
    }

    operator fun set(x: Int, y: Int, value: T) {
        grid[y][x] = value
    }

    fun getOrNull(x: Int, y: Int): T? {
        return if (x in 0..<width && y in 0..<height) {
            get(x, y)
        } else {
            null
        }
    }

    fun getOrNull(point: Point): T? {
        return getOrNull(point.x, point.y)
    }

    fun rows(): List<List<T>> {
        return grid
    }

    fun columns(): List<List<T>> {
        return transpose().rows()
    }

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

    override fun toString(): String {
        var s: String = ""
        for (y in grid) {
            for (x in y) {
                s += x
            }
            s += "\n"
        }
        return s
    }

    fun transpose(): Grid<T> {
        return Grid(height, width) { x, y ->
            grid[x][y]
        }
    }

    fun print() {
        for (y in 0 until grid.size) {
            for (x in 0 until grid[y].size) {
                print("${grid[x][y]} ")
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