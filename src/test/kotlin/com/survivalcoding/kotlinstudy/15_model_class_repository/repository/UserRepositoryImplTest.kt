package com.survivalcoding.kotlinstudy.`15_model_class_repository`.repository

import com.survivalcoding.kotlinstudy.`15_model_class_repository`.data_source.MockUserDataSourceImpl
import com.survivalcoding.kotlinstudy.`15_model_class_repository`.data_source.UserDataSource
import com.survivalcoding.kotlinstudy.`15_model_class_repository`.model.Address
import com.survivalcoding.kotlinstudy.`15_model_class_repository`.model.Company
import com.survivalcoding.kotlinstudy.`15_model_class_repository`.model.Geo
import com.survivalcoding.kotlinstudy.`15_model_class_repository`.model.User
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals

class UserRepositoryImplTest {

    companion object {
        private const val MOCK_DATA_SIZE = 3
    }

    private val repo = UserRepositoryImpl(MockUserDataSourceImpl())

    @Test
    fun `전체 유저 가져오기`() = runBlocking {
        // when
        val result = repo.getUsers()

        // then
        assertEquals(MOCK_DATA_SIZE, result.size)
    }

    @Test
    fun `username 기준으로 정렬된 top10 반환`() = runBlocking {
        // when
        val result = repo.getUsersTop10ByUserName()
        val expected = result.sortedBy { it.username }  // 정렬 확인

        // then
        assertEquals(expected, result)

        // mock 데이터 3개이므로 그대로 3개 반환
        assertEquals(MOCK_DATA_SIZE, result.size)
    }

    @Test
    fun `정렬 후 상위 10개만 반환`() = runBlocking {
        // given
        val dataSource = mockk<UserDataSource>()

        // dummy user 15명 생성
        val dummyUsers = (1..15).map { index ->
            User(
                id = index,
                name = "name$index",
                username = "user$index",
                email = "email$index@test.com",
                address = Address(
                    street = "street",
                    suite = "suite",
                    city = "city",
                    zipcode = "zip",
                    geo = Geo("0.0", "0.0")
                ),
                phone = "000",
                website = "test.com",
                company = Company("cname", "catch", "bs")
            )
        }

        // MockK → getUsers() 호출 시 dummyUsers 리턴하도록 설정
        coEvery { dataSource.getUsers() } returns dummyUsers

        val repo = UserRepositoryImpl(dataSource)

        // when
        val result = repo.getUsersTop10ByUserName()

        // then
        assertEquals(10, result.size)  // 진짜 10개만 잘려야 함

        // 정렬된 상태인지 확인 (username 기준)
        val expectedSorted = dummyUsers.sortedBy { it.username }.take(10)
        assertEquals(expectedSorted, result)
    }
}

