package com.luca.kotlinstudy._15_model_repository.repository.photo

import com.luca.kotlinstudy._15_model_repository.dataSource.photo.MockPhotoDatasourceImpl
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test

class PhotoRepositoryImplTest {

    private val mockDataSource = MockPhotoDatasourceImpl()
    private val repository = PhotoRepositoryImpl(mockDataSource)

    @Test
    fun `albumId에 해당하는 아이디만 조회된다`() = runBlocking {
        val result = repository.getPhotos(1)

        assertTrue(result.isNotEmpty())
        assertTrue(result.all { it.albumId == 1 })
    }

    @Test
    fun `해당 albumId가 없으면 빈 리스트를 반환한다`() = runBlocking {
        val result = repository.getPhotos(999)

        assertTrue(result.isEmpty())
    }
}
