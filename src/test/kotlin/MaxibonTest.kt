import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class MaxibonTest {

    private val testMaxibon: Maxibon = Maxibon()

    @Test
    fun `check that there are 10 ice creams when started`() {
        assertEquals(testMaxibon.getMaxibons(), 10)
    }
}