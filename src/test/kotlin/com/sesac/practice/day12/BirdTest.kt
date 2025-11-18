package com.sesac.practice.day12

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

class BirdTest {
    @Test
    fun `새들이 4번만 운다`() = runTest {
        // given
        val cryTimes = 4

        val sound1 = "꾸우"
        val delayTimeMillis1 = 1000L
        val bird1 = Bird(sound1, delayTimeMillis1)

        val sound2 = "까악"
        val delayTimeMillis2 = 2000L
        val bird2 = Bird(sound2, delayTimeMillis2)

        val sound3 = "짹쨱"
        val delayTimeMillis3 = 3000L
        val bird3 = Bird(sound3, delayTimeMillis3)

        // when
        var result1 = ""
        var result2 = ""
        var result3 = ""

        val job1 = launch {
            repeat(cryTimes) {
                result1 += bird1.cry()
            }
        }

        val job2 = launch {
            repeat(cryTimes) {
                result2 += bird2.cry()
            }
        }

        val job3 = launch {
            repeat(cryTimes) {
                result3 += bird3.cry()
            }
        }

        job1.join()
        job2.join()
        job3.join()

        // then
        assertEquals(sound1.repeat(cryTimes), result1)
        assertEquals(sound2.repeat(cryTimes), result2)
        assertEquals(sound3.repeat(cryTimes), result3)
    }

    @Test
    fun `새들이 10초 동안 운다`() = runTest {
        // given
        val timeMillis = 10_000L

        val sound1 = "꾸우"
        val delayTimeMillis1 = 1000L
        val bird1 = Bird(sound1, delayTimeMillis1)

        val sound2 = "까악"
        val delayTimeMillis2 = 2000L
        val bird2 = Bird(sound2, delayTimeMillis2)

        val sound3 = "짹쨱"
        val delayTimeMillis3 = 3000L
        val bird3 = Bird(sound3, delayTimeMillis3)

        // when
        var result1 = ""
        var result2 = ""
        var result3 = ""

        val job1 = launch {
            while (true) {
                result1 += bird1.cry()
            }
        }

        val job2 = launch {
            while (true) {
                result2 += bird2.cry()
            }
        }

        val job3 = launch {
            while (true) {
                result3 += bird3.cry()
            }
        }

        delay(timeMillis)
        job1.cancel()
        job2.cancel()
        job3.cancel()

        // then
        assertEquals(sound1.repeat(9), result1)
        assertEquals(sound2.repeat(4), result2)
        assertEquals(sound3.repeat(3), result3)
    }
}
