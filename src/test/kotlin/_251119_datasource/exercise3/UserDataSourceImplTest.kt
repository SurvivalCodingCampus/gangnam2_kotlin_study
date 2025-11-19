package _251119_datasource.exercise3

import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class UserDataSourceImplTest {
    @Test
    fun `user_json을 읽어서 User 리스트 객체를 반환한다`() = runTest {
        //given
        val userDataSourceImpl = UserDataSourceImpl()
        //when
        val users = userDataSourceImpl.getUsers()
        //then

        //맨앞
        assertEquals(1, users[0].id)
        assertEquals("Leanne Graham", users[0].name)
        assertEquals("Bret", users[0].username)
        assertEquals("Sincere@april.biz", users[0].email)
        assertEquals("Kulas Light", users[0].address.street)
        assertEquals("Apt. 556", users[0].address.suite)
        assertEquals("Gwenborough", users[0].address.city)
        assertEquals("92998-3874", users[0].address.zipcode)
        assertEquals("-37.3159", users[0].address.geo.lat)
        assertEquals("81.1496", users[0].address.geo.lng)
        assertEquals("1-770-736-8031 x56442", users[0].phone)
        assertEquals("hildegard.org", users[0].website)
        assertEquals("Romaguera-Crona", users[0].company.name)
        assertEquals("Multi-layered client-server neural-net", users[0].company.catchPhrase)
        assertEquals("harness real-time e-markets", users[0].company.bs)
        //맨뒤
        assertEquals(10, users.last().id)
        assertEquals("Clementina DuBuque", users.last().name)
        assertEquals("Moriah.Stanton", users.last().username)
        assertEquals("Rey.Padberg@karina.biz", users.last().email)
        assertEquals("Kattie Turnpike", users.last().address.street)
        assertEquals("Suite 198", users.last().address.suite)
        assertEquals("Lebsackbury", users.last().address.city)
        assertEquals("31428-2261", users.last().address.zipcode)
        assertEquals("-38.2386", users.last().address.geo.lat)
        assertEquals("57.2232", users.last().address.geo.lng)
        assertEquals("024-648-3804", users.last().phone)
        assertEquals("ambrose.net", users.last().website)
        assertEquals("Hoeger LLC", users.last().company.name)
        assertEquals("Centralized empowering task-force", users.last().company.catchPhrase)
        assertEquals("target end-to-end models", users.last().company.bs)


    }

}