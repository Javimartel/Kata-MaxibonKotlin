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
        val developer = Developer("Pedro", 3)
        testMaxibon.takeMaxibon(developer)
        assertEquals(7, testMaxibon.getMaxibons())
    }

    @Test
    fun `check that there are 9 ice creams when Fran takes ice creams`() {
        val developer = Developer("Fran", 1)
        testMaxibon.takeMaxibon(developer)
        assertEquals(9, testMaxibon.getMaxibons())
    }

    @Test
    fun `check that there are 10 ice creams when Davide takes ice creams`() {
        val developer = Developer("Davide", 0)
        testMaxibon.takeMaxibon(developer)
        assertEquals(10, testMaxibon.getMaxibons())
    }

    @Test
    fun `check that there are 8 ice creams when Sergio takes ice creams`() {
        val developer = Developer("Sergio", 2)
        testMaxibon.takeMaxibon(developer)
        assertEquals(8, testMaxibon.getMaxibons())
    }

    @Test
    fun `check that there are 9 ice creams when Jorge takes ice creams`() {
        val developer = Developer("Jorge", 1)
        testMaxibon.takeMaxibon(developer)
        assertEquals(9, testMaxibon.getMaxibons())
    }

    @Test
    fun `check that there are 7 ice creams when Sergio and Jorge takes ice creams`() {
        val developers = listOf(
            Developer("Sergio", 2),
            Developer("Jorge", 1)
        )
        testMaxibon.takeMaxibonInGroupOf(developers)
        assertEquals(7, testMaxibon.getMaxibons())
    }

    @Test
    fun `send message with SlackAPI when ice creams are 2 and then there are 12`() {
        val developers = listOf(
            Developer("Sergio", 2),
            Developer("Fran", 1),
            Developer("Jorge", 1)
        )
        testMaxibon.takeMaxibonInGroupOf(developers)
        testMaxibon.takeMaxibonInGroupOf(developers)

        assertEquals("Hi guys, I'm Jorge. We need more maxibons!", testMaxibon.getAPIMessage())
        assertEquals(12, testMaxibon.getMaxibons())
    }

    /*@Test
    fun `check if there are 10 ice creams if the number of maxibons left is lower than the number of maxibons the developer tries to get`() {
        val firstGroupOfDelevopers = listOf("Pedro", "Sergio", "Jorge")
        val secondGroupOfDelevopers = listOf("Sergio", "Pedro")
        testMaxibon.takeMaxibonInGroupOf(firstGroupOfDelevopers)
        testMaxibon.takeMaxibonInGroupOf(secondGroupOfDelevopers)

        assertEquals(10, testMaxibon.getMaxibons())
    }*/
}