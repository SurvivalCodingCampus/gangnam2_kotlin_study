package com.hhp227.kotlinstudy.`17_result`

import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class MyResultTest {
    @Test
    fun `성공시 MyResult의 데이터와 상태가 같은지 테스트`() = runTest {
        val result = MyResult<String, String>(status = MyResult.Status.Error).success("Hello world")

        assertEquals("Hello world", result.data)
        assertNull(result.error)
        assertEquals(MyResult.Status.Success, result.status)
    }

    @Test
    fun `실패시 MyResult의 데이터와 상태가 같은지 테스트`() = runTest {
        val result = MyResult<String, String>(status = MyResult.Status.Success).error("에러 발생")

        assertNull(result.data)
        assertEquals("에러 발생", result.error)
        assertEquals(MyResult.Status.Error, result.status)
    }
}