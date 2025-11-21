package _251121_ktor.data_source

import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.http.HttpStatusCode

class RemoteDataSourceImplTest {
    private val mockEngine = MockEngine { request ->
        respond(
            content = "",
            status = HttpStatusCode.OK
        )
    }
    val mockClient = HttpClient(mockEngine)
    val remoteDataSourceImpl = RemoteDataSourceImpl(mockClient)
}