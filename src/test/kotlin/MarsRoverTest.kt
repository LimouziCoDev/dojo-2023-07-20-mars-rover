package marsrover

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


class MarsRoverTest {

    @Test
    fun `Intialisation du rover`() {
        val input = ""
        val output = execute(input)
        assertEquals("0:0:N", output)
    }
}