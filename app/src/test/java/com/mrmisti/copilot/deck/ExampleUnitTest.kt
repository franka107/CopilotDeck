package com.mrmisti.copilot.deck

import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertIs

class MainActivityTest {

    @Test
    fun `MainTest is boolean`() = runTest {
        assertIs<Boolean>(true)
    }
}
