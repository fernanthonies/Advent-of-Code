package days

class DayTen(input: List<String>) : BaseDay(input) {

    private val pixelArray = mutableListOf<Int>()

    override fun solvePartOne(): String {
        var value = 1
        input.forEach { line ->
            when (line.split(" ")[0]) {
                "addx" -> {
                    pixelArray.add(value)
                    pixelArray.add(value)
                    value += line.split(" ")[1].toInt()
                }
                "noop" -> {
                    pixelArray.add(value)
                }
                else -> throw Error()
            }
        }
        var result = 0
        for (i in 19 until pixelArray.count() step 40) {
            result += (i+1) * pixelArray[i]
        }

        return result.toString()
    }

    override fun solvePartTwo(): String {

        for (i in 0 until pixelArray.count()) {
            val pixelPosition = pixelArray[i]
            val current = i % 40
            val pixel = if (current >= pixelPosition - 1 && current <= pixelPosition + 1) {
                "#"
            } else {
                "."
            }
            print(pixel)
            if ((i + 1) % 40 == 0) {
                println()
            }
        }
        return ""
    }
}