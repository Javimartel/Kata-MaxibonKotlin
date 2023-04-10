import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class MaxibonTest {

    private val slackRepository: SlackRepository = SlackRepository()
    private val testMaxibon: Maxibon = Maxibon(slackRepository)

    @Test
    fun `check that there are 10 ice creams when started`() {
        assertEquals(testMaxibon.getMaxibons(), 10)
    }

    @Test
    fun `check that there are 7 ice creams when Pedro takes ice creams`() {
        testMaxibon.takeMaxibon("Pedro")
        assertEquals(testMaxibon.getMaxibons(), 7)
    }

    @Test
    fun `check that there are 9 ice creams when Fran takes ice creams`() {
        testMaxibon.takeMaxibon("Fran")
        assertEquals(testMaxibon.getMaxibons(), 9)
    }

    @Test
    fun `check that there are 10 ice creams when Davide takes ice creams`() {
        testMaxibon.takeMaxibon("Davide")
        assertEquals(testMaxibon.getMaxibons(), 10)
    }

    @Test
    fun `check that there are 8 ice creams when Sergio takes ice creams`() {
        testMaxibon.takeMaxibon("Sergio")
        assertEquals(testMaxibon.getMaxibons(), 8)
    }

    @Test
    fun `check that there are 9 ice creams when Jorge takes ice creams`() {
        testMaxibon.takeMaxibon("Jorge")
        assertEquals(testMaxibon.getMaxibons(), 9)
    }

    @Test
    fun `check that there are 7 ice creams when Sergio and Jorge takes ice creams`() {
        val developers = listOf("Sergio", "Jorge")
        testMaxibon.takeMaxibonInGroupOf(developers)
        assertEquals(testMaxibon.getMaxibons(), 7)
    }

    @Test
    fun `send message with SlackAPI when ice creams are 2 and then there are 12`() {
        val developers = listOf("Sergio", "Fran", "Jorge")
        testMaxibon.takeMaxibonInGroupOf(developers)
        testMaxibon.takeMaxibonInGroupOf(developers)

        assertEquals(testMaxibon.getAPIMessage(), "Hi guys, I'm Jorge. We need more maxibons!")
        assertEquals(testMaxibon.getMaxibons(), 12)
    }
}