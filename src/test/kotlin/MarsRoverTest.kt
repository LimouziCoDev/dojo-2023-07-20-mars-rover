package marsrover

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


class MarsRoverTest {

    @Test
    fun `initialize rover`() {
        val input = ""
        val output = execute(input)
        assertEquals("0:0:N", output)
    }
    @Test
    fun `turn rover right`() {
        val input = "R"
        val output = execute(input)
        assertEquals("0:0:E", output)
    }
    @Test
    fun `turn rover right twice`() {
        val input = "RR"
        val output = execute(input)
        assertEquals("0:0:S", output)
    }
    @Test
    fun `turn rover right three times`() {
        val input = "RRR"
        val output = execute(input)
        assertEquals("0:0:W", output)
    }
    @Test
    fun `turn rover right four times`() {
        val input = "RRRR"
        val output = execute(input)
        assertEquals("0:0:N", output)
    }
}