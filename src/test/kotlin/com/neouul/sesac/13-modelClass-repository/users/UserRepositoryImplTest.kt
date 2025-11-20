package com.neouul.sesac.`13-modelClass-repository`.users

import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.plus
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test

class UserRepositoryImplTest {
    @Test
    fun `getUsers가 User List를 반환하는지 - Mocking`() = runBlocking {
        // given:
        // TodoDataSourceImpl를 모킹하여 실제 함수가 어떤 값을 반환하는지에 상관없이
        // 항상 정해진 리스트를 반환하게 된다
        val mockDataSource = mockk<UserDataSourceImpl>()
        // suspend 함수는 coEvery 사용해야 함
        coEvery { mockDataSource.loadUsers() } returns listOf(
            User(1, "", "q", "", Address("", "", "", "", Geo("", "")), "", "", Company("", "", "")),
            User(1, "", "w", "", Address("", "", "", "", Geo("", "")), "", "", Company("", "", "")),
            User(1, "", "e", "", Address("", "", "", "", Geo("", "")), "", "", Company("", "", "")),
            User(1, "", "r", "", Address("", "", "", "", Geo("", "")), "", "", Company("", "", "")),
            User(1, "", "t", "", Address("", "", "", "", Geo("", "")), "", "", Company("", "", "")),
            User(1, "", "y", "", Address("", "", "", "", Geo("", "")), "", "", Company("", "", "")),
            User(1, "", "u", "", Address("", "", "", "", Geo("", "")), "", "", Company("", "", "")),
            User(1, "", "i", "", Address("", "", "", "", Geo("", "")), "", "", Company("", "", "")),
            User(1, "", "a", "", Address("", "", "", "", Geo("", "")), "", "", Company("", "", "")),
            User(1, "", "s", "", Address("", "", "", "", Geo("", "")), "", "", Company("", "", "")),
            User(1, "", "d", "", Address("", "", "", "", Geo("", "")), "", "", Company("", "", "")),
            User(1, "", "z", "", Address("", "", "", "", Geo("", "")), "", "", Company("", "", "")),
            User(1, "", "x", "", Address("", "", "", "", Geo("", "")), "", "", Company("", "", "")),
            User(1, "", "c", "", Address("", "", "", "", Geo("", "")), "", "", Company("", "", "")),
        )
        val userRepository = UserRepositoryImpl(mockDataSource)

        // when:
        val result = userRepository.getUsers()

        // then:
        // 14개의 인스턴스가 결과 리스트에 들어있는지
        assertEquals("q", result[0].username)
        assertEquals("w", result[1].username)
        assertEquals("e", result[2].username)
        assertEquals("r", result[3].username)
        assertEquals("t", result[4].username)
        assertEquals("y", result[5].username)
        assertEquals("u", result[6].username)
        assertEquals("i", result[7].username)
        assertEquals("a", result[8].username)
        assertEquals("s", result[9].username)
        assertEquals("d", result[10].username)
        assertEquals("z", result[11].username)
        assertEquals("x", result[12].username)
        assertEquals("c", result[13].username)
    }

    @Test
    fun `getUsersTop10ByUserName가 userName으로 정렬된 데이터 중 상위 10개를 반환하는지 - Mocking`() = runBlocking {
        // given:
        // UserDataSourceImpl를 모킹하여 실제 함수가 어떤 값을 반환하는지에 상관없이
        // 항상 정해진 리스트를 반환하게 된다
        val mockDataSource = mockk<UserDataSourceImpl>()
        // suspend 함수는 coEvery 사용해야 함
        coEvery { mockDataSource.loadUsers() } returns listOf(
            User(1, "", "j", "", Address("", "", "", "", Geo("", "")), "", "", Company("", "", "")),
            User(1, "", "w", "", Address("", "", "", "", Geo("", "")), "", "", Company("", "", "")),
            User(1, "", "e", "", Address("", "", "", "", Geo("", "")), "", "", Company("", "", "")),
            User(1, "", "r", "", Address("", "", "", "", Geo("", "")), "", "", Company("", "", "")),
            User(1, "", "h", "", Address("", "", "", "", Geo("", "")), "", "", Company("", "", "")),
            User(1, "", "y", "", Address("", "", "", "", Geo("", "")), "", "", Company("", "", "")),
            User(1, "", "g", "", Address("", "", "", "", Geo("", "")), "", "", Company("", "", "")),
            User(1, "", "i", "", Address("", "", "", "", Geo("", "")), "", "", Company("", "", "")),
            User(1, "", "a", "", Address("", "", "", "", Geo("", "")), "", "", Company("", "", "")),
            User(1, "", "f", "", Address("", "", "", "", Geo("", "")), "", "", Company("", "", "")),
            User(1, "", "d", "", Address("", "", "", "", Geo("", "")), "", "", Company("", "", "")),
            User(1, "", "z", "", Address("", "", "", "", Geo("", "")), "", "", Company("", "", "")),
            User(1, "", "b", "", Address("", "", "", "", Geo("", "")), "", "", Company("", "", "")),
            User(1, "", "c", "", Address("", "", "", "", Geo("", "")), "", "", Company("", "", "")),
        )
        val userRepository = UserRepositoryImpl(mockDataSource)

        // when:
        val result = userRepository.getUsersTop10ByUserName()

        // then:
        // 10개의 인스턴스가 결과 리스트에 유저이름 순서대로 들어있는지
//        result.forEach { println(it) }
        assertEquals("a", result[0].username)
        assertEquals("b", result[1].username)
        assertEquals("c", result[2].username)
        assertEquals("d", result[3].username)
        assertEquals("e", result[4].username)
        assertEquals("f", result[5].username)
        assertEquals("g", result[6].username)
        assertEquals("h", result[7].username)
        assertEquals("i", result[8].username)
        assertEquals("j", result[9].username)
    }
}