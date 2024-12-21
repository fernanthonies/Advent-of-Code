package year2024.days

import BaseTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import year2024.Days.Day16

class Day16Test: BaseTest<Day16>(inputStringOne, inputStringTwo, ::Day16) {

    @Test
    fun solvePartOne() {
        val result = testPartOne()
        Assertions.assertEquals("11048", result)
    }

    @Test
    fun solvePartTwo() {
        val result = testPartTwo()
        Assertions.assertEquals("", result)
    }

    private companion object {
        const val inputStringOne =
                "S#.....#.............#.......................#.........................\n" +
                        ".#.###.#.###.#######.#######.#############.###...#.....................\n" +
                        ".#...#...#.#.......#.......#.#.....#.......#.......#...................\n" +
                        ".###.####..#######.#######.#.#.#......######.#.........................\n" +
                        ".#...#.......#.....#.#...#...#...#...........#.........................\n" +
                        ".#.###.#..##.#.#####.#.#.#####.#.......###.............................\n" +
                        "...#.......#.#...#.....#...............#...#...........................\n" +
                        ".##.#..#.#.#..##.######.#..#..###.....##..#............................\n" +
                        ".....#.........#.........#.......#...#.#...............................\n" +
                        "####.#.#..#..#.####.####.#.###.#.#.....................................\n" +
                        ".#...#.#.....#.....#...#.#.#...#...#...................................\n" +
                        ".#.###.##...##.###.#.#.#.###.###.#.#...................................\n" +
                        ".#.#...........#.#.#...#.....#.#.#.#...................................\n" +
                        ".#.#.#.#..##.##..#.#.#.######..#.####...#..............................\n" +
                        ".#.#.....#...#...#.#.#.#.......#.........#.............................\n" +
                        ".#.#..#.##.###.###.#.#.#.#####.#########.#...................#.........\n" +
                        ".#.#...#...#.....#.#.#.............#.....#.............................\n" +
                        ".#.#####.#####.#.#..#.####.##..#..##.#.#.#.............................\n" +
                        ".#.....#.....#.#...#...........#.........#.............................\n" +
                        ".#####.#####.#.#####......##.##....#.....#.............................\n" +
                        ".....#.....#.#.#.....#.......#.............#...........................\n" +
                        "##.#.#####.#.#.#...###...#.......#......##...#.........................\n" +
                        "...#.....#...#.#.#.....................................................\n" +
                        "...###.#######.#.##....................................................\n" +
                        ".#.#.......#...#...#...#.................#.............................\n" +
                        "..#..##......###.#...#.....#..............................#....#...#...\n" +
                        "...........#...#.#.....................................................\n" +
                        "....#.......##.#.......................................##..#...........\n" +
                        ".#...........#...#.....................................................\n" +
                        "...............##............................................#.#.#.#...\n" +
                        ".......#...#.#...#.................................................#...\n" +
                        "#.............#..#.......................................#....######...\n" +
                        ".................................................................#.....\n" +
                        ".....#...........#.............................#.......#..#...##.###...\n" +
                        ".......................................................#.......#.#.....\n" +
                        "...................................................##..#.#####.#.#.#...\n" +
                        ".....................................................#...#...#...#.....\n" +
                        "....#........................................#.......#.#.#.#######.#...\n" +
                        ".....................................#...#...#.#.....#...#.............\n" +
                        "..............................#......#.#.#..#......#...###.#.####.##...\n" +
                        ".......................................#.............#.#...#.#...#.#...\n" +
                        ".................................#..####...#.#...###.#.###.#.#.#.#.#...\n" +
                        "...................................#...#.........#.#.#...#.#...#.#.....\n" +
                        "...................................#.#.#####.#.##....###.#.#####.#.....\n" +
                        ".................................#.#.#.#...#...#.........#.#...#.#.....\n" +
                        "...................................#.#.#.#.######..###.#.#.#.###.#.#...\n" +
                        "...................................#.#.#.#.......#.......#...#...#...#.\n" +
                        ".................................#.#.###..####.#.###.#.###.###.##......\n" +
                        "...................................#.....#...#.#...#.#.....#...#...#...\n" +
                        "........................#......#.###.#####..##.###.#.#.#####.####..#.#.\n" +
                        ".............................#.....#.......#...#.#.#.....#...#...#.....\n" +
                        "...........................#....##.#########.###.#.#####.#.###.#.##.###\n" +
                        "...............................#...#...#.....#...#.#...#.#...#.#...#...\n" +
                        "...........................#...#.###.#.#.#####.#.#.##....###.#.###.#.#.\n" +
                        ".............................#.#.#...#...#.....#.....#...#.#...#.#...#.\n" +
                        "...........................#..##.#.###.#####.##.####.##....#####.#####.\n" +
                        "...........................#.#...#.#...#...#...#...#...#...#.......#...\n" +
                        "........................#..#...###.#.###.#.#####....##.###..####.###.#.\n" +
                        ".....................#...#.....#...#...#.#.......#...#...#.....#.#...#.\n" +
                        "............................#..#.####..#..######.###.#.#..####...#.##..\n" +
                        "...................................#...#.#.....#...#.#.#.#.......#...#.\n" +
                        "................................##.#.#...#.#.....#.#.#.#.###########.#.\n" +
                        ".............................................#...#.#.#.#.........#...#.\n" +
                        "...........................#.#........#####...##.#.#.#.#########.#.####\n" +
                        "...................#...............#.........#.....#.#.....#...#.#.....\n" +
                        ".........................#.#.....#.#.#########...##..#.#.###.#.#.#.###.\n" +
                        ".................................#...#.............#.#.#.....#.#.#.#...\n" +
                        "..............................##.#....##.#.#######.#.#.#######.#.###.#.\n" +
                        ".......................................#.#.......#...#.....#...#...#.#.\n" +
                        "...................................#.#.#..#.####.#########.#.#####.#.#.\n" +
                        ".............................#.................#...........#.........#E"

        const val inputStringTwo =
                "###############\n" +
                "#.......#....E#\n" +
                "#.#.###.#.###.#\n" +
                "#.....#.#...#.#\n" +
                "#.###.#####.#.#\n" +
                "#.#.#.......#.#\n" +
                "#.#.#####.###.#\n" +
                "#...........#.#\n" +
                "###.#.#####.#.#\n" +
                "#...#.....#.#.#\n" +
                "#.#.#.###.#.#.#\n" +
                "#.....#...#.#.#\n" +
                "#.###.#.#.#.#.#\n" +
                "#S..#.....#...#\n" +
                "###############"
    }
}