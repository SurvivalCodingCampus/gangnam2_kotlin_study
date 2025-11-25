package _251121_ktor.exercise4.data_source

import io.ktor.client.engine.mock.*
import io.ktor.http.*
import io.ktor.http.HttpMethod.Companion.Get
import java.io.File

val mockEngine = MockEngine { request ->
    when (request.method) {
        Get -> {
            when (request.url.toString()) {
                "http://localhost/iu.com" -> {
                    respond(
                        status = HttpStatusCode.OK,
                        content = File("iu.txt").readBytes()
                    )
                }

                else -> {
                    respond(
                        status = HttpStatusCode.NotFound,
                        content = "{}"
                    )
                }
            }
        }

        else -> {
            respond(
                status = HttpStatusCode.NotFound,
                content = "{}"
            )
        }
    }

}
