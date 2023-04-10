import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class MaxibonTest {

    private val slackRepository: SlackRepository = SlackRepository()
    private val testMaxibon: Maxibon = Maxibon(slackRepository)

    @Test
    fun `check that there are 10 ice creams when started`() {
        assertEquals(10, testMaxibon.getMaxibons())
    }

    @Test
    fun `check that there are 7 ice creams when Pedro takes ice creams`() {
        testMaxibon.takeMaxibon("Pedro")
        assertEquals(7, testMaxibon.getMaxibons())
    }

    @Test
    fun `check that there are 9 ice creams when Fran takes ice creams`() {
        testMaxibon.takeMaxibon("Fran")
        assertEquals(9, testMaxibon.getMaxibons())
    }

    @Test
    fun `check that there are 10 ice creams when Davide takes ice creams`() {
        testMaxibon.takeMaxibon("Davide")
        assertEquals(10, testMaxibon.getMaxibons())
    }

    @Test
    fun `check that there are 8 ice creams when Sergio takes ice creams`() {
        testMaxibon.takeMaxibon("Sergio")
        assertEquals(8, testMaxibon.getMaxibons())
    }

    @Test
    fun `check that there are 9 ice creams when Jorge takes ice creams`() {
        testMaxibon.takeMaxibon("Jorge")
        assertEquals(9, testMaxibon.getMaxibons())
    }

    @Test
    fun `check that there are 7 ice creams when Sergio and Jorge takes ice creams`() {
        val developers = listOf("Sergio", "Jorge")
        testMaxibon.takeMaxibonInGroupOf(developers)
        assertEquals(7, testMaxibon.getMaxibons())
    }

    @Test
    fun `send message with SlackAPI when ice creams are 2 and then there are 12`() {
        val developers = listOf("Sergio", "Fran", "Jorge")
        testMaxibon.takeMaxibonInGroupOf(developers)
        testMaxibon.takeMaxibonInGroupOf(developers)

        assertEquals("Hi guys, I'm Jorge. We need more maxibons!", testMaxibon.getAPIMessage())
        assertEquals(12, testMaxibon.getMaxibons())
    }

    @Test
    fun `check if there are 10 ice creams if the number of maxibons left is lower than the number of maxibons the developer tries to get`() {
        val firstGroupOfDelevopers = listOf("Pedro", "Sergio", "Jorge")
        val secondGroupOfDelevopers = listOf("Sergio", "Pedro")
        testMaxibon.takeMaxibonInGroupOf(firstGroupOfDelevopers)
        testMaxibon.takeMaxibonInGroupOf(secondGroupOfDelevopers)

        assertEquals(10, testMaxibon.getMaxibons())
    }
}