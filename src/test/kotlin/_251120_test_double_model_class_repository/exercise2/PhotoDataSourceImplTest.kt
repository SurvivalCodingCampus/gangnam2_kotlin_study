package _251120_test_double_model_class_repository.exercise2

import _251120_test_double_model_class_repository.common_config.FILEPATH2
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class PhotoDataSourceImplTest {
    @Test
    fun `photos_json을 읽어서 Photo객체로 변환한다`() = runTest {
        //given
        val photoDatasourceImpl = PhotoDataSourceImpl(FILEPATH2)
        //when
        val photo = photoDatasourceImpl.getAllPhotos()
        //then

        //맨앞
        assertEquals(1, photo.first().albumId)
        assertEquals(1, photo.first().id)
        assertEquals("accusamus beatae ad facilis cum similique qui sunt", photo.first().title)
        assertEquals("https://via.placeholder.com/600/92c952", photo.first().url)
        assertEquals("https://via.placeholder.com/150/92c952", photo.first().thumbnailUrl)
        //맨뒤
        assertEquals(100, photo.last().albumId)
        assertEquals(5000, photo.last().id)
        assertEquals("error quasi sunt cupiditate voluptate ea odit beatae", photo.last().title)
        assertEquals("https://via.placeholder.com/600/6dd9cb", photo.last().url)
        assertEquals("https://via.placeholder.com/150/6dd9cb", photo.last().thumbnailUrl)
    }

}