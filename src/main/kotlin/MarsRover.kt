package marsrover

fun execute(input: String) : String {

    return "0:0:" + when (input) {
        "R" -> "E"
        "RR" -> "S"
        "RRR" -> "W"
        else -> "N"
    }

}
