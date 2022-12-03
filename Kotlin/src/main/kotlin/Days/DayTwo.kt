package Days

fun dayTwo(input: List<String>) {
    partOne(input)
    partTwo(input)
}

fun partOne(input: List<String>) {
    var score = 0

    input.map { it.split(" ") }.forEach { round ->
        val me = Choice.fromString(round[1])
        val them = Choice.fromString(round[0])
        val result = me.result(them)

        score += me.score() + result.score()
    }

    println("My total score for RPS=${score}")
}

fun partTwo(input: List<String>) {
    var score = 0

    input.map { it.split(" ") }.forEach { round ->
        val them = Choice.fromString(round[0])
        val result = RoundResult.fromString(round[1])
        val me = them.fromResult(result)

        score += me.score() + result.score()
    }

    println("part two=${score}")
}

enum class Choice {
    Rock {
        override fun result(other: Choice): RoundResult {
            return when (other) {
                Rock -> RoundResult.Draw
                Paper -> RoundResult.Lose
                Scissor -> RoundResult.Win
            }
        }
        override fun fromResult(result: RoundResult): Choice {
            return when (result) {
                RoundResult.Win -> Paper
                RoundResult.Draw -> Rock
                RoundResult.Lose -> Scissor
            }
        }
        override fun score(): Int = 1
    },
    Paper {
        override fun result(other: Choice): RoundResult {
            return when (other) {
                Rock -> RoundResult.Win
                Paper -> RoundResult.Draw
                Scissor -> RoundResult.Lose
            }
        }
        override fun fromResult(result: RoundResult): Choice {
            return when (result) {
                RoundResult.Win -> Scissor
                RoundResult.Draw -> Paper
                RoundResult.Lose -> Rock
            }
        }
        override fun score(): Int = 2
    },
    Scissor {
        override fun result(other: Choice): RoundResult {
            return when (other) {
                Rock -> RoundResult.Lose
                Paper -> RoundResult.Win
                Scissor -> RoundResult.Draw
            }
        }
        override fun fromResult(result: RoundResult): Choice {
            return when (result) {
                RoundResult.Win -> Rock
                RoundResult.Draw -> Scissor
                RoundResult.Lose -> Paper
            }
        }
        override fun score(): Int = 3
    };

    abstract fun fromResult(result: RoundResult): Choice
    abstract fun result(other: Choice): RoundResult
    abstract fun score(): Int

    companion object {
        fun fromString(input: String): Choice {
            return when (input) {
                "A", "X" -> Rock
                "B", "Y" -> Paper
                "C", "Z" -> Scissor
                else -> Rock
            }
        }
    }
}

enum class RoundResult {
    Win {
        override fun score(): Int {
            return 6
        }
    },
    Lose {
        override fun score(): Int {
            return 0
        }
    },
    Draw {
        override fun score(): Int {
            return 3
        }
    };

    abstract fun score(): Int

    companion object {
        fun fromString(input: String): RoundResult {
            return when(input) {
                "X" -> Lose
                "Y" -> Draw
                "Z" -> Win
                else -> Lose
            }
        }
    }
}