package marsrover.marsrover

import marsrover.execute
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
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
    @ParameterizedTest
    @CsvSource("1,0:0:W", "2,0:0:S", "3,0:0:E", "4,0:0:N", "5,0:0:W")
    fun `turn rover left`(times: Int, expected: String) {
        val input = "L".repeat(times)
        val output = execute(input)
        assertEquals(expected, output)
    }

    @Test
    fun  `turn rover right twice then left`() {
        val input = "RRL"
        val output = execute(input)
        assertEquals("0:0:E", output)
    }

    @Test
    fun  `increase Y when moving north`() {
        val input = "M"
        val output = execute(input)
        assertEquals("0:1:N", output)
    }

    @Test
    fun  `increase Y by 2 when moving north twice`() {
        val input = "MM"
        val output = execute(input)
        assertEquals("0:2:N", output)
    }

    @Test
    fun  `increase X by 1 when moving forward facing East`() {
        val input = "RM"
        val output = execute(input)
        assertEquals("1:0:E", output)
    }

    @Test
    fun  `increase X by 2 when moving forward twice facing East`() {
        val input = "RMM"
        val output = execute(input)
        assertEquals("2:0:E", output)
    }
}