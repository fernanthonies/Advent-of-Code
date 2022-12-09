package days

class DayEight(input: List<String>) : BaseDay(input) {
    private val treeArray: IntArray
    private val col: Int
    private val row: Int
    private val total: Int

    init {
        col = input.first().count()
        row = input.count()
        total = col*row

        treeArray = input.joinToString("").map { it.digitToInt() }.toIntArray()
    }

    override fun solvePartOne(): String {
        val visibleTrees: Array<Boolean> = Array(total) {
            when {
                it < col -> true
                it % col == 0 -> true
                it % col == col - 1 -> true
                it >= total - col -> true
                else -> false
            }
        }
        //rows
        for (i in 1 until row) {
            var frontTallest = treeArray[i*col]
            var backTallest = treeArray[(i+1)*col - 1]
            for (j in 1 until col - 1) {
                val x = j + (i * col)
                val y = (col - j - 1) + (i * col)

                if (treeArray[x] > frontTallest) {
                    frontTallest = treeArray[x]
                    visibleTrees[x] = true
                }
                if (treeArray[y] > backTallest) {
                    backTallest = treeArray[y]
                    visibleTrees[y] = true
                }
            }
        }

        //columns
        for (i in 0 until col) {
            var frontTallest = treeArray[i]
            var backTallest = treeArray[i + (total - col)]
            for (j in 1 until row - 1) {
                val x = i + (j * col)
                val y = ((row - j - 1) * col) + i

                if (treeArray[x] > frontTallest) {
                    frontTallest = treeArray[x]
                    visibleTrees[x] = true
                }
                if (treeArray[y] > backTallest) {
                    backTallest = treeArray[y]
                    visibleTrees[y] = true
                }
            }
        }

        val totalVisible = visibleTrees.count { it }
        return totalVisible.toString()
    }

    override fun solvePartTwo(): String {
        var topScore = 0

        for (i in col until total - col - 1) {
            if (i % col == 0 || (i + 1) % col== 0) continue
            var currentScore = 1
            val currentHeight = treeArray[i]

            //look up
            currentScore *= lookInDirection(-col, i, currentHeight)
            //look right
            currentScore *= lookInDirection(1, i, currentHeight)
            //look down
            currentScore *= lookInDirection(col, i, currentHeight)
            //look left
            currentScore *= lookInDirection(-1, i, currentHeight)

            if (currentScore > topScore) {
                topScore = currentScore
            }
        }

        return topScore.toString()
    }

    private fun lookInDirection(stride: Int, currentIndex: Int, currentHeight: Int): Int {
        var distance = 0
        var index = currentIndex
        do {
            distance++
            index += stride
        } while (index > col && index < total - col
            && index % row != 0
            && (index + 1) % row != 0
            && treeArray[index] < currentHeight)
        return distance
    }
}