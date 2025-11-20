package _251120_test_double_model_class_repository.exercise4

import _251120_test_double_model_class_repository.common_config.FILEPATH4
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

class UserDataSourceImplTest {

    @Test
    fun `users_json을 읽어서 User객체로 변환한다`() = runTest {
        //given
        val userDataSourceImpl = UserDataSourceImpl(FILEPATH4)
        //when
        val user = userDataSourceImpl.getAllUser()
        //then

        //맨앞
        assertEquals(1, user.first().id)
        assertEquals("Leanne Graham", user.first().name)
        assertEquals("Bret", user.first().username)
        assertEquals("Sincere@april.biz", user.first().email)
        assertEquals("Kulas Light", user.first().address.street)
        assertEquals("Apt. 556", user.first().address.suite)
        assertEquals("Gwenborough", user.first().address.city)
        assertEquals("92998-3874", user.first().address.zipcode)
        assertEquals("-37.3159", user.first().address.geo.lat)
        assertEquals("81.1496", user.first().address.geo.lng)
        assertEquals("1-770-736-8031 x56442", user.first().phone)
        assertEquals("hildegard.org", user.first().website)
        assertEquals("Romaguera-Crona", user.first().company.name)
        assertEquals("Multi-layered client-server neural-net", user.first().company.catchPhrase)
        assertEquals("harness real-time e-markets", user.first().company.bs)

        //맨뒤
        assertEquals(10, user.last().id)
        assertEquals("Clementina DuBuque", user.last().name)
        assertEquals("Moriah.Stanton", user.last().username)
        assertEquals("Rey.Padberg@karina.biz", user.last().email)
        assertEquals("Kattie Turnpike", user.last().address.street)
        assertEquals("Suite 198", user.last().address.suite)
        assertEquals("Lebsackbury", user.last().address.city)
        assertEquals("31428-2261", user.last().address.zipcode)
        assertEquals("-38.2386", user.last().address.geo.lat)
        assertEquals("57.2232", user.last().address.geo.lng)
        assertEquals("024-648-3804", user.last().phone)
        assertEquals("ambrose.net", user.last().website)
        assertEquals("Hoeger LLC", user.last().company.name)
        assertEquals("Centralized empowering task-force", user.last().company.catchPhrase)
        assertEquals("target end-to-end models", user.last().company.bs)
    }
}