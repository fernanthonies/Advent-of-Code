package year2025.Days

import BaseTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day11Test: BaseTest<Day11>(inputStringOne, inputStringTwo, ::Day11) {

    @Test
    fun solvePartOne() {
        val result = testPartOne()
        Assertions.assertEquals("5", result)
    }

    @Test
    fun solvePartTwo() {
        val result = testPartTwo()
        Assertions.assertEquals("2", result)
    }

    private companion object {
        const val inputStringOne =  "aaa: you hhh\n" +
                                    "you: bbb ccc\n" +
                                    "bbb: ddd eee\n" +
                                    "ccc: ddd eee fff\n" +
                                    "ddd: ggg\n" +
                                    "eee: out\n" +
                                    "fff: out\n" +
                                    "ggg: out\n" +
                                    "hhh: ccc fff iii\n" +
                                    "iii: out"

        const val inputStringTwo =  "svr: aaa bbb\n" +
                                    "aaa: fft\n" +
                                    "fft: ccc\n" +
                                    "bbb: tty\n" +
                                    "tty: ccc\n" +
                                    "ccc: ddd eee\n" +
                                    "ddd: hub\n" +
                                    "hub: fff\n" +
                                    "eee: dac\n" +
                                    "dac: fff\n" +
                                    "fff: ggg hhh\n" +
                                    "ggg: out\n" +
                                    "hhh: out"
    }
}