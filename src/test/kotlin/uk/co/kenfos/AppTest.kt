package uk.co.kenfos

import kotlin.test.Test
import kotlin.test.assertNotNull

class AppTest {
    @Test fun testAppHasAGreeting() {
        val app = App()
        assertNotNull(app.main, "OK")
    }
}
