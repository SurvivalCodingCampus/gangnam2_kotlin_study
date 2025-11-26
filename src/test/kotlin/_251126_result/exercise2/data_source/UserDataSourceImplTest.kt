package _251126_result.exercise2.data_source

import _251126_result.exercise2.core.mockEngine
import _251126_result.exercise2.model.User
import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class UserDataSourceImplTest {
    lateinit var mockClient: HttpClient
    lateinit var userDataSourceImpl: UserDataSourceImpl

    @Before
    fun `모의서버 초기화`() {
        mockClient = HttpClient(mockEngine) {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                })
            }

        }
        userDataSourceImpl = UserDataSourceImpl(mockClient)

    }

    @Test
    fun `getAllUser() - 모든 유저가 리스트형태로 불러와진다`() = runTest {
        //when
        val response = userDataSourceImpl.getAllUser()
        //then
        assertEquals(HttpStatusCode.OK.toString(), response.status)
        assertEquals(
            Json.encodeToString(
                listOf(
                    User(name = "홍길동", age = 43, id = 1),
                    User(name = "이순신", age = 22, id = 2),
                    User(name = "흥부", age = 43, id = 3)
                )
            ),
            Json.encodeToString(response.body)
        )
    }

    @Test
    fun `createUser() - 유저데이터를 생성한다`() = runTest {
        //when
        val response = userDataSourceImpl.createUser(User(name = "홍길동", age = 43, id = 1))
        //then
        assertEquals(User(name = "홍길동", age = 43, id = 1), response.body)
        assertEquals(HttpStatusCode.OK.toString(), response.status)
    }
}