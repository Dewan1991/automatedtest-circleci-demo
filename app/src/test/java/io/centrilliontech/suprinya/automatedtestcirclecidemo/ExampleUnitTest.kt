package io.centrilliontech.suprinya.automatedtestcirclecidemo

import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.hamcrest.Matchers.`is` as _is
import org.mockito.Mockito.`when` as _when

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertThat(4, _is(2 + 2))
    }

    @Test
    fun message_isCorrect() {
        val actualMessage = "Message"
        val expectedMessage = "Messages"
        assertThat(actualMessage, _is(expectedMessage))
    }
}
