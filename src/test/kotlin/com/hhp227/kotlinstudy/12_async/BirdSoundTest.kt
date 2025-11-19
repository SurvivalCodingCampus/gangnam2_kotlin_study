package com.hhp227.kotlinstudy.`12_async`

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

class BirdSoundTest {
    @Test
    fun `각 새가 지정된 횟수만큼 소리를 내는지 테스트`() = runTest {
        val outputs = mutableListOf<String>()
        val birdSound = BirdSound()
        val job = birdSound.launchBirdSounds {
            outputs.add(it)
        }

        job.join()
        println(outputs)
        assertEquals(4, outputs.count { it == "꾸우" })
        assertEquals(4, outputs.count { it == "까악" })
        assertEquals(4, outputs.count { it == "짹짹" })
    }

    @Test
    fun `모든 새 코루틴은 완료 후 종료된다`() = runTest {
        val outputs = mutableListOf<String>()
        val birdSound = BirdSound()
        val job = birdSound.launchBirdSounds {
            outputs.add(it)
        }

        advanceUntilIdle()

        assertTrue(job.isCompleted)
        assertEquals(12, outputs.size)
    }

    @Test
    fun `10초 후 모든 코루틴이 취소된다`() = runTest {
        val birdSound = BirdSound()
        val results = mutableListOf<String>()
        val job = launch {
            birdSound.launchBirdSoundsInfinite { sound ->
                results.add(sound)
            }
                .join()
        }

        advanceTimeBy(5_000) // 5초 경과 → 소리가 계속 나야 함
        assertTrue(results.isNotEmpty())

        advanceUntilIdle()

        assertTrue(job.isCompleted) // 코루틴 종료

        val currentSize = results.size

        advanceTimeBy(5_000) // 소리가 나지 않아야 함
        assertTrue(currentSize == results.size)
    }
}