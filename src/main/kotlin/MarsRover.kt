package marsrover

fun execute(input: String): String {

    var direction: Direction = North
    for (command in input) {
        direction = when (command) {
            'R' -> direction.turnRight()

            else -> direction.turnLeft()
        }
    }
    return "0:0:$direction"
}

sealed interface Direction {
    fun turnLeft(): Direction
    fun turnRight(): Direction
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




