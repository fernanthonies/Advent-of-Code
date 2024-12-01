import org.junit.jupiter.api.BeforeEach

open class BaseTest<T: BaseDay>(private val testInputOne: String, private val testInputTwo: String, private val factory: () -> T) {
    private lateinit var subject: T

    @BeforeEach
    fun setUp() {
        subject = factory()
    }

    fun testPartOne(): String {
        subject.setData(testInputOne.split("\n"))
        return subject.solvePartOne()
    }

    fun testPartTwo(): String {
        subject.setData(testInputTwo.split("\n"))
        return subject.solvePartTwo()
    }
}