package marsrover

fun execute(input: String) = input
    .map(Char::toCommand)
    .fold(
        Output(
            direction = North,
            position = Position(0, 0)
        )
    )
    { output, command -> executeCommand(command, output) }
    .toString()

private fun executeCommand(command: Command, output: Output) = when (command) {
    Command.RIGHT -> output.turnRight()
    Command.LEFT -> output.turnLeft()
    Command.FORWARD -> output.moveForward()
}

fun Char.toCommand() = Command.values().first { it.c == this }

data class Output(
    val direction: Direction,
    val position: Position
) {
    fun turnLeft() = this.copy(direction = direction.turnLeft())
    fun turnRight() = this.copy(direction = direction.turnRight())
    fun moveForward(): Output {
        return if (direction is East) {
            this.copy(position = position.increaseX())
        } else {
            this.copy(position = position.increaseY())
        }
    }

    override fun toString() = "$position:$direction"

}

enum class Command(val c: Char) {
    RIGHT('R'),
    LEFT('L'),
    FORWARD('M')
}

sealed interface Direction {
    fun turnLeft(): Direction
    fun turnRight(): Direction
}

data class Position(
    val x: Int,
    val y: Int
) {
    override fun toString() = "$x:$y"
    fun increaseX() = this.copy(x = x + 1)
    fun increaseY() = this.copy(y = y + 1)
}


object North : Direction {
    override fun turnLeft() = West

    override fun turnRight() = East

    override fun toString() = "N"
}

object South : Direction {
    override fun turnLeft() = East

    override fun turnRight() = West

    override fun toString() = "S"
}

object West : Direction {
    override fun turnLeft() = South
    override fun turnRight() = North

    override fun toString() = "W"
}

object East : Direction {
    override fun turnLeft() = North

    override fun turnRight() = South

    override fun toString() = "E"
}




