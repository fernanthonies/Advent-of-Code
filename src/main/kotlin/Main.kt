import java.io.File

fun main() {
    //dayOne(readFile("input/dayOne.txt"))
    dayTwo(readFile("input/dayTwo.txt"))
}

fun readFile(fileName: String): List<String> {
    return File(fileName).useLines { it.toList() }
}