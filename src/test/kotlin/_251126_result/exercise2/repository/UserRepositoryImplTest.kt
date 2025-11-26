package _251126_result.exercise2.repository

import _251126_result.exercise2.core.NetworkError
import _251126_result.exercise2.core.Result
import _251126_result.exercise2.core.mockEngine
import _251126_result.exercise2.data_source.UserDataSourceImpl
import _251126_result.exercise2.model.User
import io.ktor.client.*
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class UserRepositoryImplTest {
    lateinit var userDataSourceImpl: UserDataSourceImpl
    lateinit var userRepositoryImpl: UserRepositoryImpl

    @Before
    fun `setup`() {
        val mockClient = HttpClient(mockEngine)
        userDataSourceImpl = UserDataSourceImpl(mockClient)
        userRepositoryImpl = UserRepositoryImpl(userDataSourceImpl)
    }

    @Test
    fun `findUser() - id값에 해당하는 유저를 반환받는다`() = runTest {
        val result = userRepositoryImpl.findUser(2)
        if (result is Result.Success) {
            assertEquals("""{"name":"홍길동","age":43,"id":2}""", result.data)
        }
    }

    @Test
    fun `findUser() - id값에 해당하는 유저가 없는경우 만들어놓은 NetworkError를 반환받는다`() = runTest {
        val result = userRepositoryImpl.findUser(2)
        if (result is Result.Error) {
            assertEquals(NetworkError.UserNotFoundError, result.error)
        }
    }

    @Test
    fun `findUser() - id값이 4인경우 클라이언트 에러를 반환받는다`() = runTest {
        val result = userRepositoryImpl.findUser(4)
        if (result is Result.Error) {
            assertEquals(NetworkError.NetWorkUnavailable, result.error)
        }
    }

    @Test
    fun `findUser() - id값이 5인경우 클라이언트 에러를 반환받는다`() = runTest {
        val result = userRepositoryImpl.findUser(5)
        if (result is Result.Error) {
            assertEquals(NetworkError.HttpError(500), result.error)
        }
    }

    @Test
    fun `getAllUsers() - 유저들의 리스트를 반환받는다`() = runTest {
        //when
        val result = userRepositoryImpl.getAllUsers()

        if (result is Result.Success) {
            assertEquals(
                Json.decodeFromString("""[{"name":"홍길동","age":43,"id":1},{"name":"이순신","age":22,"id":2},{"name":"흥부","age":43,"id":3}]"""),
                result.data
            )
        }

    }

    @Test
    fun `createUser() - 유저를 잘 생성한다`() = runTest {
        //when
        val result = userRepositoryImpl.createUser(Json.encodeToString(User(name = "이순신", age = 32, id = 2)))
        //then
        if (result is Result.Success) {
            assertEquals(User(name = "이순신", age = 32, id = 2), result.data)
        }
    }

    @Test
    fun `createUser() - 이상한 Json데이터가 오면 ParseError를 반환한다`() = runTest {
        //when
        val result =
            userRepositoryImpl.createUser("""{"age": 9999,"id" : 2}""")
        //then
        if (result is Result.Error) {
            assertEquals(NetworkError.ParseError, result.error)
        } else {
            throw Exception("디버깅용")
        }
    }

}