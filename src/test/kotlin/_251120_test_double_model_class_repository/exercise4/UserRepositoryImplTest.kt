package _251120_test_double_model_class_repository.exercise4

import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

class UserRepositoryImplTest {
    val mockUserDataSourceImpl = MockUserDataSourceImpl()
    val repository = UserRepositoryImpl(mockUserDataSourceImpl)

    @Test
    fun `Mock객체의 유저가 2개 저장되어있다`() = runTest {
        assertEquals(2, repository.getUsers().size)
    }

    @Test
    fun `유저이름을 정렬하여 10개를 객체로 만들어준다`() = runTest {
        val resultList = repository.getUsersTop10ByUserName()
        assertEquals(2, resultList.size)
        assertEquals(-1,compareValues(resultList[0].name,resultList[1].name))
        //compareValues에서 앞이 사전순이 더 빠르면 -1, 뒤가 더빠르면 1 반환
    }

}