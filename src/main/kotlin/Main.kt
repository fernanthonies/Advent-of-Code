import java.io.File

fun main(args: Array<String>) {
    dayOne()
}

fun dayOne(input: List<String>) {
    val sumList = mutableListOf<Int>()
    var tempTotal = 0

    input.forEach { line ->
        line.toIntOrNull()?.let {
            tempTotal += it
        }?:run {
            sumList.add(tempTotal)
            tempTotal = 0
        }
    }
    sumList.sort()
    println("Highest calorie count is ${sumList.last()}")
    println("Sum of top three is ${sumList.takeLast(3).sum()}")
}

fun readFile(fileName: String): List<String> {
    return File(fileName).useLines { it.toList() }
}