package marsrover

fun execute(input: String) : String {

    return if (input == "R") {
        "0:0:E"
    } else {
        "0:0:N"
    }

}
