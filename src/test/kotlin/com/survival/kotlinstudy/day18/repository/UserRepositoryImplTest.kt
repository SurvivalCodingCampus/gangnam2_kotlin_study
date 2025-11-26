package com.survival.kotlinstudy.day18.repository

import com.survival.kotlinstudy.day18.datasource.*
import com.survival.kotlinstudy.day18.util.NetworkError
import com.survival.kotlinstudy.day18.util.Result
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue


class UserRepositoryImplTest {

    @Test
    fun `getUser success`() = runTest {
        val dataSource = MockSuccessUserDataSourceImpl()
        val repository = UserRepositoryImpl(dataSource)

        val result = repository.getUser(1)

        assertTrue(result is Result.Success)
        assertEquals(1, result.data.id)
        assertEquals("홍길동", result.data.name)
    }

    @Test
    fun `getUsers success`() = runTest {
        val dataSource = MockSuccessUserDataSourceImpl()
        val repository = UserRepositoryImpl(dataSource)

        val result = repository.getUsers()

        assertTrue(result is Result.Success)
        assertEquals(3, result.data.size)
        assertEquals(1, result.data[0].id)
        assertEquals("홍길동", result.data[0].name)
        assertEquals(2, result.data[1].id)
        assertEquals("김이박", result.data[1].name)
        assertEquals(3, result.data[2].id)
        assertEquals("한석봉", result.data[2].name)
    }

    @Test
    fun `createUser success`() = runTest {
        val dataSource = MockSuccessUserDataSourceImpl()
        val repository = UserRepositoryImpl(dataSource)

        val result = repository.createUser(dataSource.user1)

        assertTrue(result is Result.Success)
        assertEquals(1, result.data.id)
        assertEquals("홍길동", result.data.name)

    }

    @Test
    fun `JSON 파싱 에러 테스트`() = runTest {
        val dataSource = MockParseErrorUserDataSourceImpl()
        val repository = UserRepositoryImpl(dataSource)

        val result = repository.getUsers()

        assertTrue(result is Result.Error)
        assertTrue(result.error is NetworkError.ParseError)
    }

    @Test
    fun `Timeout 10초 이상 시 테스트`() = runTest {
        val dataSource = MockTimeOutUserDataSourceImpl()
        val repository = UserRepositoryImpl(dataSource)

        val result = repository.getUsers()

        assertTrue(result is Result.Error)
        assertTrue(result.error is NetworkError.Timeout)
    }

    @Test
    fun `Network 에러 발생 시 테스트`() = runTest {
        val datasource = MockNetworkErrorUserDataSourceImpl()
        val repository = UserRepositoryImpl(datasource)

        val result = repository.getUsers()

        assertTrue(result is Result.Error)
        assertTrue(result.error is NetworkError.NetworkUnavailable)

    }


    @Test
    fun `4xx 에러 발생 시 테스트`() = runTest {
        val dataSource = MockHttpErrorUserDataSourceImpl(404)
        val repository = UserRepositoryImpl(dataSource)

        val result = repository.getUsers()

        assertTrue(result is Result.Error)
        assertTrue(result.error is NetworkError.ClientError)
        assertEquals(404, (result.error as NetworkError.ClientError).code)

    }

    @Test
    fun `5xx 에러 발생 시 테스트`() = runTest {
        val dataSource = MockHttpErrorUserDataSourceImpl(500)
        val repository = UserRepositoryImpl(dataSource)

        val result = repository.getUsers()

        assertTrue(result is Result.Error)
        assertTrue(result.error is NetworkError.ServerError)
        assertEquals(500, (result.error as NetworkError.ServerError).code)

    }


}

