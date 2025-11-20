package _251120_test_double_model_class_repository.exercise5

import _251120_test_double_model_class_repository.common_config.FILEPATH5
import _251120_test_double_model_class_repository.exercise3.TodoDataSourceImpl
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class AlbumDataSourceImplTest {
    @Test
    fun `albums_json을 읽어서 Album객체로 변환한다`() = runTest {
        //given
        val albumDataSourceImpl = AlbumDataSourceImpl(FILEPATH5)
        //when
        val album = albumDataSourceImpl.getAllAlbum()
        //then
        //맨앞
        assertEquals(1, album.first().userId)
        assertEquals(1, album.first().id)
        assertEquals("quidem molestiae enim", album.first().title)
        //맨뒤
        assertEquals(10, album.last().userId)
        assertEquals(100, album.last().id)
        assertEquals("enim repellat iste", album.last().title)
    }
}
