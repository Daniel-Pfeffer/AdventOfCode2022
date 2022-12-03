suspend fun main() {
    val test = "A Y\n" +
        "B X\n" +
        "C Z"
    var points = 0
    val x = InputReceiver.get(2)
    x.dropLast(1).forEach {
        val cols = it.split(" ")
        val other = RPS.from(cols[0].first())
        val requiredOutcome = Outcome.from(cols[1].first())
        val me = other.ensure(requiredOutcome)
        points += me.points + 1 + requiredOutcome.points
    }
    println(points)
}

enum class RPS(val points: Int) {
    ROCK(0),
    PAPER(1),
    SCISSOR(2);

    fun outcome(other: RPS): Outcome {
        if (this == other) {
            return Outcome.DRAW
        }
        if ((this.points + 1) % 3 == other.points) {
            return Outcome.LOSS
        }
        return Outcome.WIN
    }

    fun ensure(requiredOutcome: Outcome): RPS {
        values().forEach {
            if (it.outcome(this)==requiredOutcome) {
                return it
            }
        }
        throw FuckException()
    }

    companion object {
        fun from(f: Char): RPS {
            if (f == 'A') {
                return ROCK
            }
            if (f == 'B') {
                return PAPER;
            }
            if (f == 'C') {
                return SCISSOR
            }
            throw FuckException()
        }
    }
}

enum class Outcome(val points: Int) {
    WIN(6),
    LOSS(0),
    DRAW(3);

    companion object {
        fun from(f: Char): Outcome {
            if (f == 'Y') {
                return DRAW
            }
            if (f == 'X') {
                return LOSS
            }
            if (f == 'Z') {
                return WIN
            }
            throw FuckException()
        }
    }
}