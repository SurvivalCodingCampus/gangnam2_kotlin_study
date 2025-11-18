package _251118_coroutine

import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

class MovieTest {
    @Test
    fun `역직렬화가 잘 되었는지 테스트`() = runTest {
        //when
        val deserialization = getMovieInfo()
        //then
        assertEquals("Star Wars", deserialization.title)
    }

}