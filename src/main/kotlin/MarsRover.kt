package marsrover

fun execute(input: String): String {

    var direction = "N"
    for (command in input) {
        direction = when (command) {
            'R' -> nextTurnRight(direction)

            else -> nextTurnLeft(direction)
        }
    }
    return "0:0:$direction"
}


enum class Turn {
    LEFT, RIGHT
}

private fun nextTurnLeft(direction: String) = changeDirection(Turn.LEFT, direction)

private fun nextTurnRight(direction: String) = changeDirection(Turn.RIGHT, direction)

private fun changeDirection(turn: Turn, direction: String) = when (direction) {
    "N" -> when (turn) {
        Turn.RIGHT -> "E"
        Turn.LEFT -> "W"
    }

    "E" -> when (turn) {
        Turn.RIGHT -> "S"
        Turn.LEFT -> "N"
    }

    "S" -> when (turn) {
        Turn.RIGHT -> "W"
        Turn.LEFT -> "E"
    }

    else -> when (turn) {
        Turn.RIGHT -> "N"
        Turn.LEFT -> "S"
    }
}
