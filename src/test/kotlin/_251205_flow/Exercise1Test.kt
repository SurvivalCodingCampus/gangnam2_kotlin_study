package _251205_flow

import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

class Exercise1Test {

    @Test
    fun `20과_40이_collect되어야한다`() = runTest{
        //given
        val result:MutableList<Int> = mutableListOf()
        val expectList = listOf(20,40)
        //when
        flow.collect {
            result.add(it)
        }
        //then
        assertEquals(expectList,result)
    }

}