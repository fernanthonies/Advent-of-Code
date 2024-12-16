package year2024.days

import BaseTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import year2024.Days.Day10
import year2024.Days.Day14
import year2024.Days.Day15

class Day15Test: BaseTest<Day15>(inputStringOne, inputStringTwo, ::Day15) {

    @Test
    fun solvePartOne() {
        val result = testPartOne()
        Assertions.assertEquals("2028", result)
    }

    @Test
    fun solvePartTwo() {
        val result = testPartTwo()
        Assertions.assertEquals("9021", result)
    }

    private companion object {
        const val inputStringOne =
                "########\n" +
                "#..O.O.#\n" +
                "##@.O..#\n" +
                "#...O..#\n" +
                "#.#.O..#\n" +
                "#...O..#\n" +
                "#......#\n" +
                "########\n" +
                "\n" +
                "<^^>>>vv<v>>v<<"

        const val inputStringTwo =
                "##########\n" +
                        "#..O..O.O#\n" +
                        "#......O.#\n" +
                        "#.OO..O.O#\n" +
                        "#..O@..O.#\n" +
                        "#O#..O...#\n" +
                        "#O..O..O.#\n" +
                        "#.OO.O.OO#\n" +
                        "#....O...#\n" +
                        "##########\n" +
                        "\n" +
                        "<vv>^<v^>v>^vv^v>v<>v^v<v<^vv<<<^><<><>>v<vvv<>^v^>^<<<><<v<<<v^vv^v>^\n" +
                        "vvv<<^>^v^^><<>>><>^<<><^vv^^<>vvv<>><^^v>^>vv<>v<<<<v<^v>^<^^>>>^<v<v\n" +
                        "><>vv>v^v^<>><>>>><^^>vv>v<^^^>>v^v^<^^>v^^>v^<^v>v<>>v^v^<v>v^^<^^vv<\n" +
                        "<<v<^>>^^^^>>>v^<>vvv^><v<<<>^^^vv^<vvv>^>v<^^^^v<>^>vvvv><>>v^<<^^^^^\n" +
                        "^><^><>>><>^^<<^^v>>><^<v>^<vv>>v>>>^v><>^v><<<<v>>v<v<v>vvv>^<><<>^><\n" +
                        "^>><>^v<><^vvv<^^<><v<<<<<><^v<<<><<<^^<v<^^^><^>>^<v^><<<^>>^v<v^v<v^\n" +
                        ">^>>^v>vv>^<<^v<>><<><<v<<v><>v<^vv<<<>^^v^>^^>>><<^v>>v^v><^^>>^<>vv^\n" +
                        "<><^^>^^^<><vvvvv^v<v<<>^v<v>v<<^><<><<><<<^^<<<^<<>><<><^^^>^^<>^>v<>\n" +
                        "^^>vv<^v^v<vv>^<><v<^v>^^^>>>^^vvv^>vvv<>>>^<^>>>>>^<<^v>^vvv<>^<><<v>\n" +
                        "v^^>>><<^^<>>^v^<v^vv<>v^<<>^<^v^v><^<<<><<^<v><v<>vv>>v><v^<vv<>v^<<^"
    }
}