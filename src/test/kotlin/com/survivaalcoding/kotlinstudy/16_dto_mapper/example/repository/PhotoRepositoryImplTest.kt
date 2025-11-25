package com.survivaalcoding.kotlinstudy.`16_dto_mapper`.example.repository

import com.survivaalcoding.kotlinstudy.`16_dto_mapper`.example.datasource.PhotoDataSource
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Test

class PhotoRepositoryImplTest {
    val dataSource: PhotoDataSource = MockPhotoDataSourceImpl()
    val repository: PhotoRepository = PhotoRepositoryImpl(dataSource)

    @Test
    fun `Photo 전체 데이터를 조회한다`() = runTest {
        // given
        // when
        val actual = repository.getPhotos()

        // then
        assertEquals(6, actual.size)
    }
}
