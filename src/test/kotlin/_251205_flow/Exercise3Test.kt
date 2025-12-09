package _251205_flow

import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

class Exercise3Test {

    @Test
    fun `원하는 결과대로 나와야한다`() = runTest {
        //given
        val expectedResult = listOf("데이터 로딩 중", "5번째 키보드 입력")
        val result = mutableListOf<String>()
        //when
        flows.collect {
            result.add(it)
        }
        //then
        assertEquals(expectedResult, result)
    }

}