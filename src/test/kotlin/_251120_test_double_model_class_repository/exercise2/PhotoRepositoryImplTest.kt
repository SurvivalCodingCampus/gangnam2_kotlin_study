package _251120_test_double_model_class_repository.exercise2

import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

class PhotoRepositoryImplTest {
    val mockPhoto = MockPhotoDataSourceImpl()
    val repository = PhotoRepositoryImpl(mockPhoto)

    @Test
    fun `albumId가 1인 모의 데이터의 수는 1개이다`() = runTest {
        assertEquals(1, repository.getPhotos(1).size)
    }

    @Test
    fun `albumId가 9인 모의 데이터의 수는 없다`() = runTest {
        assertEquals(0, repository.getPhotos(9).size)
    }
}