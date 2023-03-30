import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class MaxibonTest {

    private val testMaxibon: Maxibon = Maxibon()

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
}