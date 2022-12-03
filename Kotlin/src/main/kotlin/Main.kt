import Days.dayThree
import java.io.File

fun main() {
    //Days.dayOne(readFile("../input/dayOne.txt"))
    //Days.dayTwo(readFile("../input/dayTwo.txt"))
    dayThree(readFile("../input/dayThree.txt"))
}

fun readFile(fileName: String): List<String> {
    return File(fileName).useLines { it.toList() }
}