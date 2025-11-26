package com.ezlevup.my.day251126.exercise.repository

import com.ezlevup.my.core.RepositoryResult
import com.ezlevup.my.day251121.exercise.model.Post
import com.ezlevup.my.day251126.exercise.data_source.UserDataSourceImpl
import com.ezlevup.my.day251126.exercise.model.NetworkError
import com.ezlevup.my.day251126.exercise.model.User
import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.client.plugins.*
import io.ktor.http.*
import io.ktor.utils.io.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.fail

class UserRepositoryImplTest {
    private lateinit var mockEngine: MockEngine
    private lateinit var mockEngineId8: MockEngine
    private lateinit var mockUsers: List<User>
    private lateinit var mockUserId8: Post
    private lateinit var userJsonText: String
    private lateinit var userJsonText8: String

    @Before
    fun setUp() {
        userJsonText = """
                    [
                      {
                        "id": 1,
                        "name": "Leanne Graham",
                        "username": "Bret",
                        "email": "Sincere@april.biz",
                        "address": {
                          "street": "Kulas Light",
                          "suite": "Apt. 556",
                          "city": "Gwenborough",
                          "zipcode": "92998-3874",
                          "geo": {
                            "lat": "-37.3159",
                            "lng": "81.1496"
                          }
                        },
                        "phone": "1-770-736-8031 x56442",
                        "website": "hildegard.org",
                        "company": {
                          "name": "Romaguera-Crona",
                          "catchPhrase": "Multi-layered client-server neural-net",
                          "bs": "harness real-time e-markets"
                        }
                      },
                      {
                        "id": 2,
                        "name": "Ervin Howell",
                        "username": "Antonette",
                        "email": "Shanna@melissa.tv",
                        "address": {
                          "street": "Victor Plains",
                          "suite": "Suite 879",
                          "city": "Wisokyburgh",
                          "zipcode": "90566-7771",
                          "geo": {
                            "lat": "-43.9509",
                            "lng": "-34.4618"
                          }
                        },
                        "phone": "010-692-6593 x09125",
                        "website": "anastasia.net",
                        "company": {
                          "name": "Deckow-Crist",
                          "catchPhrase": "Proactive didactic contingency",
                          "bs": "synergize scalable supply-chains"
                        }
                      },
                      {
                        "id": 3,
                        "name": "Clementine Bauch",
                        "username": "Samantha",
                        "email": "Nathan@yesenia.net",
                        "address": {
                          "street": "Douglas Extension",
                          "suite": "Suite 847",
                          "city": "McKenziehaven",
                          "zipcode": "59590-4157",
                          "geo": {
                            "lat": "-68.6102",
                            "lng": "-47.0653"
                          }
                        },
                        "phone": "1-463-123-4447",
                        "website": "ramiro.info",
                        "company": {
                          "name": "Romaguera-Jacobson",
                          "catchPhrase": "Face to face bifurcated interface",
                          "bs": "e-enable strategic applications"
                        }
                      },
                      {
                        "id": 4,
                        "name": "Patricia Lebsack",
                        "username": "Karianne",
                        "email": "Julianne.OConner@kory.org",
                        "address": {
                          "street": "Hoeger Mall",
                          "suite": "Apt. 692",
                          "city": "South Elvis",
                          "zipcode": "53919-4257",
                          "geo": {
                            "lat": "29.4572",
                            "lng": "-164.2990"
                          }
                        },
                        "phone": "493-170-9623 x156",
                        "website": "kale.biz",
                        "company": {
                          "name": "Robel-Corkery",
                          "catchPhrase": "Multi-tiered zero tolerance productivity",
                          "bs": "transition cutting-edge web services"
                        }
                      },
                      {
                        "id": 5,
                        "name": "Chelsey Dietrich",
                        "username": "Kamren",
                        "email": "Lucio_Hettinger@annie.ca",
                        "address": {
                          "street": "Skiles Walks",
                          "suite": "Suite 351",
                          "city": "Roscoeview",
                          "zipcode": "33263",
                          "geo": {
                            "lat": "-31.8129",
                            "lng": "62.5342"
                          }
                        },
                        "phone": "(254)954-1289",
                        "website": "demarco.info",
                        "company": {
                          "name": "Keebler LLC",
                          "catchPhrase": "User-centric fault-tolerant solution",
                          "bs": "revolutionize end-to-end systems"
                        }
                      },
                      {
                        "id": 6,
                        "name": "Mrs. Dennis Schulist",
                        "username": "Leopoldo_Corkery",
                        "email": "Karley_Dach@jasper.info",
                        "address": {
                          "street": "Norberto Crossing",
                          "suite": "Apt. 950",
                          "city": "South Christy",
                          "zipcode": "23505-1337",
                          "geo": {
                            "lat": "-71.4197",
                            "lng": "71.7478"
                          }
                        },
                        "phone": "1-477-935-8478 x6430",
                        "website": "ola.org",
                        "company": {
                          "name": "Considine-Lockman",
                          "catchPhrase": "Synchronised bottom-line interface",
                          "bs": "e-enable innovative applications"
                        }
                      },
                      {
                        "id": 7,
                        "name": "Kurtis Weissnat",
                        "username": "Elwyn.Skiles",
                        "email": "Telly.Hoeger@billy.biz",
                        "address": {
                          "street": "Rex Trail",
                          "suite": "Suite 280",
                          "city": "Howemouth",
                          "zipcode": "58804-1099",
                          "geo": {
                            "lat": "24.8918",
                            "lng": "21.8984"
                          }
                        },
                        "phone": "210.067.6132",
                        "website": "elvis.io",
                        "company": {
                          "name": "Johns Group",
                          "catchPhrase": "Configurable multimedia task-force",
                          "bs": "generate enterprise e-tailers"
                        }
                      },
                      {
                        "id": 8,
                        "name": "Nicholas Runolfsdottir V",
                        "username": "Maxime_Nienow",
                        "email": "Sherwood@rosamond.me",
                        "address": {
                          "street": "Ellsworth Summit",
                          "suite": "Suite 729",
                          "city": "Aliyaview",
                          "zipcode": "45169",
                          "geo": {
                            "lat": "-14.3990",
                            "lng": "-120.7677"
                          }
                        },
                        "phone": "586.493.6943 x140",
                        "website": "jacynthe.com",
                        "company": {
                          "name": "Abernathy Group",
                          "catchPhrase": "Implemented secondary concept",
                          "bs": "e-enable extensible e-tailers"
                        }
                      },
                      {
                        "id": 9,
                        "name": "Glenna Reichert",
                        "username": "Delphine",
                        "email": "Chaim_McDermott@dana.io",
                        "address": {
                          "street": "Dayna Park",
                          "suite": "Suite 449",
                          "city": "Bartholomebury",
                          "zipcode": "76495-3109",
                          "geo": {
                            "lat": "24.6463",
                            "lng": "-168.8889"
                          }
                        },
                        "phone": "(775)976-6794 x41206",
                        "website": "conrad.com",
                        "company": {
                          "name": "Yost and Sons",
                          "catchPhrase": "Switchable contextually-based project",
                          "bs": "aggregate real-time technologies"
                        }
                      },
                      {
                        "id": 10,
                        "name": "Clementina DuBuque",
                        "username": "Moriah.Stanton",
                        "email": "Rey.Padberg@karina.biz",
                        "address": {
                          "street": "Kattie Turnpike",
                          "suite": "Suite 198",
                          "city": "Lebsackbury",
                          "zipcode": "31428-2261",
                          "geo": {
                            "lat": "-38.2386",
                            "lng": "57.2232"
                          }
                        },
                        "phone": "024-648-3804",
                        "website": "ambrose.net",
                        "company": {
                          "name": "Hoeger LLC",
                          "catchPhrase": "Centralized empowering task-force",
                          "bs": "target end-to-end models"
                        }
                      }
                    ]
                    """.trimIndent()

        mockEngine = MockEngine { request ->
            respond(
                content = ByteReadChannel(userJsonText),
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
    }

    @Test
    fun getUser(): Unit = runBlocking {
        // given
        val repository = UserRepositoryImpl(UserDataSourceImpl())

        // when
        val userId = 1
        val result = repository.getUser(userId)

        // then
        when (result) {
            is RepositoryResult.Success -> {
                val user = result.data
                assertNotNull(user)
                assertEquals(userId, user.id)
            }

            is RepositoryResult.Error -> {
                val error = result.error
                println(error.toString())
            }
        }
    }

    @Test
    fun getUsers(): Unit = runBlocking {
        // given
        val repository = UserRepositoryImpl(UserDataSourceImpl())

        // when
        val userId = 1
        val result = repository.getUsers()

        // then
        when (result) {
            is RepositoryResult.Success -> {
                val users = result.data
                assertNotNull(users)
            }

            is RepositoryResult.Error -> {
                val error = result.error
                println(error.toString())
            }
        }
    }

    @Test
    fun createUser(): Unit = runBlocking {
        // given
        val repository = UserRepositoryImpl(UserDataSourceImpl())

        // when
        val user = User(id = 11)
        val result = repository.createUser(user)

        // then
        when (result) {
            is RepositoryResult.Success -> {
                val userData: User = result.data
                assertNotNull(user)
                assertEquals(user.id, userData.id)
                println(user.toString())
            }

            is RepositoryResult.Error -> {
                val error = result.error
                println(error.toString())
            }
        }
    }


    @Test
    fun `getUser 타임아웃`(): Unit = runBlocking {
        // given
        val client: HttpClient = HttpClient(MockEngine) {
            engine {
                addHandler { request ->
                    delay(1000) // 1초 지연
                    respond("OK", HttpStatusCode.OK)
                }
            }

            install(HttpTimeout) {
                requestTimeoutMillis = 500 // 0.5초
            }
        }

        val repository = UserRepositoryImpl(UserDataSourceImpl(client))

        // when
        val userId = 1
        val result = repository.getUser(userId)

        // then
        when (result) {
            is RepositoryResult.Success -> {
                val user = result.data
                assertNotNull(user)
                assertEquals(userId, user.id)
            }

            is RepositoryResult.Error -> {
                val error = result.error
                assertTrue(error is NetworkError.Timeout)
                println(error.toString())
            }
        }
    }


    @Test
    fun `getUser 상태코드 404 `(): Unit = runBlocking {
        // given
        val client: HttpClient = HttpClient(MockEngine) {
            engine {
                addHandler { request ->
                    respond("404 Not Found", HttpStatusCode.NotFound)
                }
            }
        }

        val repository = UserRepositoryImpl(UserDataSourceImpl(client))

        // when
        val userId = 1
        val result = repository.getUser(userId)

        // then
        when (result) {
            is RepositoryResult.Success -> {
                fail("Success가 발생하면 안 됩니다")
            }

            is RepositoryResult.Error -> {
                val error = result.error
                assertTrue(error is NetworkError.HttpClientError)
                assertEquals(404, (error as NetworkError.HttpClientError).code)
                println(error.toString())
            }
        }
    }


    @Test
    fun `getUser 상태코드 500 `(): Unit = runBlocking {
        // given
        val client: HttpClient = HttpClient(MockEngine) {
            engine {
                addHandler { request ->
                    respond("500 Internal Server Error", HttpStatusCode.InternalServerError)
                }
            }
        }

        val repository = UserRepositoryImpl(UserDataSourceImpl(client))

        // when
        val userId = 1
        val result = repository.getUser(userId)

        // then
        when (result) {
            is RepositoryResult.Success -> {
                fail("Success가 발생하면 안 됩니다")
            }

            is RepositoryResult.Error -> {
                val error = result.error
                assertTrue(error is NetworkError.HttpServerError)
                assertEquals(500, (error as NetworkError.HttpServerError).code)
                println(error.toString())
            }
        }
    }


    @Test
    fun `getUser JSON 파싱 에러 `(): Unit = runBlocking {
        // given
        val client: HttpClient = HttpClient(MockEngine) {
            engine {
                addHandler { request ->
                    respond(
                        content = "{ id: 1, name: \"Leanne Graham\" ", // 오류 JSON
                        status = HttpStatusCode.OK,
                        headers = headersOf(HttpHeaders.ContentType, "application/json")
                    )
                }
            }
        }

        val repository = UserRepositoryImpl(UserDataSourceImpl(client))

        // when
        val userId = 1
        val result = repository.getUser(userId)

        // then
        when (result) {
            is RepositoryResult.Success -> {
                fail("Success가 발생하면 안 됩니다")
            }

            is RepositoryResult.Error -> {
                val error = result.error
                assertTrue(error is NetworkError.ParseError)
                println(error.toString())
            }
        }
    }

}