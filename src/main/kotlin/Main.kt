import java.io.File

fun main() {
    //dayOne(readFile("input/dayOne.txt"))
    //dayTwo(readFile("input/dayTwo.txt"))
    dayThree(readFile("input/dayThree.txt"))
}

fun readFile(fileName: String): List<String> {
    return File(fileName).useLines { it.toList() }
}