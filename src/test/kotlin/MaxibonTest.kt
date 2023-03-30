import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class MaxibonTest {

    @Test
    fun `check that there are 10 ice creams when started`() {
        assertEquals(maxibon(), 10);
    }
}