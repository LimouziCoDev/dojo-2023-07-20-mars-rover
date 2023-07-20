package marsrover

fun execute(input: String) : String {

    return "0:0:" + when (input) {
        "LLL", "R" -> "E"
        "LL", "RR" -> "S"
        "L", "LLLLL", "RRR" -> "W"
        else -> "N"
    }

}
