package com.survivaalcoding.kotlinstudy.`14_model_repository`.example.fourth

import java.io.File

class MockUserDataSourceImpl(val file: File) : UserDataSource {
    override suspend fun getUser() = listOf(
        User(
            1L,
            "name1",
            "aaa",
            "user1@gmail.com",
            Address("street", "suite", "city", "01234", Geo("12.23", "33.44")),
            "010-1111-2222",
            "https://url.com",
            Company("company", "unknown", "bs")
        ),
        User(
            2L,
            "name2",
            "aba",
            "user1@gmail.com",
            Address("street", "suite", "city", "01234", Geo("12.23", "33.44")),
            "010-1111-2222",
            "https://url.com",
            Company("company", "unknown", "bs")
        ),
        User(
            3L,
            "name3",
            "zaa",
            "user1@gmail.com",
            Address("street", "suite", "city", "01234", Geo("12.23", "33.44")),
            "010-1111-2222",
            "https://url.com",
            Company("company", "unknown", "bs")
        ),
        User(
            4L,
            "name4",
            "baa",
            "user1@gmail.com",
            Address("street", "suite", "city", "01234", Geo("12.23", "33.44")),
            "010-1111-2222",
            "https://url.com",
            Company("company", "unknown", "bs")
        ),
        User(
            5L,
            "name5",
            "abc",
            "user1@gmail.com",
            Address("street", "suite", "city", "01234", Geo("12.23", "33.44")),
            "010-1111-2222",
            "https://url.com",
            Company("company", "unknown", "bs")
        ),
        User(
            6L,
            "name6",
            "ddd",
            "user1@gmail.com",
            Address("street", "suite", "city", "01234", Geo("12.23", "33.44")),
            "010-1111-2222",
            "https://url.com",
            Company("company", "unknown", "bs")
        ),
        User(
            7L,
            "name7",
            "kkk",
            "user1@gmail.com",
            Address("street", "suite", "city", "01234", Geo("12.23", "33.44")),
            "010-1111-2222",
            "https://url.com",
            Company("company", "unknown", "bs")
        ),
        User(
            8L,
            "name8",
            "zya",
            "user1@gmail.com",
            Address("street", "suite", "city", "01234", Geo("12.23", "33.44")),
            "010-1111-2222",
            "https://url.com",
            Company("company", "unknown", "bs")
        ),
        User(
            9L,
            "name9",
            "que",
            "user1@gmail.com",
            Address("street", "suite", "city", "01234", Geo("12.23", "33.44")),
            "010-1111-2222",
            "https://url.com",
            Company("company", "unknown", "bs")
        ),
        User(
            10L,
            "name10",
            "ioi",
            "user1@gmail.com",
            Address("street", "suite", "city", "01234", Geo("12.23", "33.44")),
            "010-1111-2222",
            "https://url.com",
            Company("company", "unknown", "bs")
        ),
        User(
            11L,
            "name11",
            "app",
            "user1@gmail.com",
            Address("street", "suite", "city", "01234", Geo("12.23", "33.44")),
            "010-1111-2222",
            "https://url.com",
            Company("company", "unknown", "bs")
        )
    )
}