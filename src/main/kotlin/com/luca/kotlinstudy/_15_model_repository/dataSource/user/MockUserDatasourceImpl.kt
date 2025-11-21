package com.luca.kotlinstudy._15_model_repository.dataSource.user

import com.luca.kotlinstudy._15_model_repository.model.Address
import com.luca.kotlinstudy._15_model_repository.model.Company
import com.luca.kotlinstudy._15_model_repository.model.Geo
import com.luca.kotlinstudy._15_model_repository.model.User

class MockUserDatasourceImpl : UserDatasource {
    override suspend fun getUsers(): List<User> {
        return listOf(
            User(
                id = 1,
                name = "Luca",
                username = "aluca",
                email = "luca@test.com",
                address = Address(
                    street = "Street 1",
                    suite = "Suite 101",
                    city = "Busan",
                    zipcode = "11111",
                    geo = Geo(35.1, 129.1)
                ),
                phone = "010-1111-2222",
                website = "luca.dev",
                company = Company(
                    name = "Luca Corp",
                    catchPhrase = "Coding everyday",
                    bs = "software"
                )
            ),
            User(
                id = 2,
                name = "Ming",
                username = "bing",
                email = "ming@test.com",
                address = Address(
                    street = "Street 2",
                    suite = "Suite 202",
                    city = "Seoul",
                    zipcode = "22222",
                    geo = Geo(37.5, 127.0)
                ),
                phone = "010-2222-3333",
                website = "ming.dev",
                company = Company(
                    name = "Ming Inc",
                    catchPhrase = "Keep improving",
                    bs = "tech"
                )
            ),
            User(
                id = 3,
                name = "Sena",
                username = "csena",
                email = "sena@test.com",
                address = Address(
                    street = "Street 3",
                    suite = "Suite 303",
                    city = "Daegu",
                    zipcode = "33333",
                    geo = Geo(35.8, 128.6)
                ),
                phone = "010-3333-4444",
                website = "sena.dev",
                company = Company(
                    name = "Sena LLC",
                    catchPhrase = "Always forward",
                    bs = "it"
                )
            )
        )
    }
}