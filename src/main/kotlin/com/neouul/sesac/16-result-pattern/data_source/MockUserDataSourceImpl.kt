package com.neouul.sesac.`16-result-pattern`.data_source

import com.neouul.sesac.`16-result-pattern`.dto.UserDTO
import com.neouul.sesac.`16-result-pattern`.model.User
import com.neouul.sesac.core.Response
import kotlinx.coroutines.delay
import kotlinx.coroutines.withTimeout
import kotlinx.serialization.json.Json

class MockUserDataSourceImpl : UserDataSource {
    private val mockJson = """[
  {
    "id": 101,
    "name": "Alex Johnson",
    "username": "alexj",
    "email": "alex.j@example.com",
    "phone": "1-555-123-4567"
  },
  {
    "id": 102,
    "name": "Samantha Lee",
    "username": "samanthal",
    "email": "sam.lee@example.com",
    "phone": "1-555-987-6543"
  },
  {
    "id": 103,
    "name": "Michael Chen",
    "username": "mikec",
    "email": "michael.c@example.com",
    "phone": "1-555-500-1000"
  }
]"""
    private val invalidJson = """{
    "id": "??",
    "name": "Guest User",
    "username": null,
    "email": "guest@example.com",
    "phone": null
  }"""
    private val validJson = """{
    "id": 101,
    "name": "Alex Johnson",
    "username": "alexj",
    "email": "alex.j@example.com",
    "phone": "1-555-123-4567"
  }"""

    private val headers = mapOf("Content-Type" to listOf("application/json"))

    override suspend fun getUser(userId: Int): Response<UserDTO?> {
        return when (userId) {
            102 -> Response(
                STATUS_NOT_FOUND_VALUE,
                headers,
                null
            )

            103 -> Response(
                STATUS_NOT_MODIFIED_VALUE,
                headers,
                null
            )

            104 -> Response(
                STATUS_OK_VALUE,
                headers,
                Json.decodeFromString<UserDTO>(invalidJson)
            )

            else -> Response(
                STATUS_OK_VALUE,
                headers,
                Json.decodeFromString<UserDTO>(validJson)
            )
        }
    }

    override suspend fun getUsers(): Response<List<UserDTO?>?> {
        return Response(
            STATUS_OK_VALUE,
            headers,
            Json.decodeFromString<List<UserDTO>>(mockJson)
        )
    }

    override suspend fun createUser(user: User): Response<UserDTO?> {
        when (user.name) {
            "404" -> return Response(
                STATUS_NOT_FOUND_VALUE,
                headers,
                null
            )

            "304" -> return Response(
                STATUS_NOT_MODIFIED_VALUE,
                headers,
                null
            )

            "Timeout" -> {
                withTimeout(1L) {
                    delay(100L)
                }
                return Response(
                    STATUS_OK_VALUE,
                    headers,
                    null
                )
            }

            else -> return Response(
                STATUS_OK_VALUE,
                headers,
                UserDTO(
                    user.userId,
                    user.name,
                    user.userName,
                    user.email,
                    user.phone,
                )
            )

        }
    }

    companion object {
        private const val STATUS_OK_VALUE = 200
        private const val STATUS_NOT_FOUND_VALUE = 404
        private const val STATUS_NOT_MODIFIED_VALUE = 304
        private const val STATUS_BAD_GATEWAY_VALUE = 502
    }
}
