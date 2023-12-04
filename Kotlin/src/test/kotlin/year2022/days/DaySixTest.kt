package year2022.days

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import year2022.Days.DaySix

class DaySixTest {

    private lateinit var subject: DaySix

    @BeforeEach
    fun setUp() {
        subject = DaySix(listOf())
    }

    @Test
    fun findSignalStart() {
        assertEquals(5, subject.findSignalStart("bvwbjplbgvbhsrlpgdmjqwftvncz"))
        assertEquals(6, subject.findSignalStart("nppdvjthqldpwncqszvftbrmjlhg"))
        assertEquals(10, subject.findSignalStart("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"))
        assertEquals(11, subject.findSignalStart("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"))
    }

    @Test
    fun findMessageStart() {
        assertEquals(19, subject.findMessageStart("mjqjpqmgbljsphdztnvjfqwrcgsmlb"))
        assertEquals(23, subject.findMessageStart("bvwbjplbgvbhsrlpgdmjqwftvncz"))
        assertEquals(23, subject.findMessageStart("nppdvjthqldpwncqszvftbrmjlhg"))
        assertEquals(29, subject.findMessageStart("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"))
        assertEquals(26, subject.findMessageStart("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"))
    }
}