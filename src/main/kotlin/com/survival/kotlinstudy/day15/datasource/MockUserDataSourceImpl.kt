package com.survival.kotlinstudy.day15.datasource

import com.survival.kotlinstudy.datasource.Address
import com.survival.kotlinstudy.datasource.Company
import com.survival.kotlinstudy.datasource.Geo
import com.survival.kotlinstudy.day15.model.User

class MockUserDataSourceImpl: UserDataSource {

    val user1 = User(
        id = 1,
        name = "AA",
        username = "a",
        email = "sda@com",
        address = Address(
            street = "길",
            suite = "suite",
            city = "city",
            zipcode = "zipcode",
            geo = Geo(lat = "121", lng = "1213")
        ),
        phone = "010101",
        website = "2323@m",
        company = Company(
            name = "Romaguera-Jacobson",
            catchPhrase = "Face to face bifurcated interface",
            bs = "e-enable strategic applications")
    )
    val user2 = User(
        id = 1,
        name = "b",
        username = "b",
        email = "sda@com",
        address = Address(
            street = "길",
            suite = "suite",
            city = "city",
            zipcode = "zipcode",
            geo = Geo(lat = "121", lng = "1213")
        ),
        phone = "010101",
        website = "2323@m",
        company = Company(
            name = "Romaguera-Jacobson",
            catchPhrase = "Face to face bifurcated interface",
            bs = "e-enable strategic applications")
    )
    val user3 = User(
        id = 1,
        name = "c",
        username = "c",
        email = "sda@com",
        address = Address(
            street = "길",
            suite = "suite",
            city = "city",
            zipcode = "zipcode",
            geo = Geo(lat = "121", lng = "1213")
        ),
        phone = "010101",
        website = "2323@m",
        company = Company(
            name = "Romaguera-Jacobson",
            catchPhrase = "Face to face bifurcated interface",
            bs = "e-enable strategic applications")
    )
    val user4 = User(
        id = 1,
        name = "d",
        username = "d",
        email = "sda@com",
        address = Address(
            street = "길",
            suite = "suite",
            city = "city",
            zipcode = "zipcode",
            geo = Geo(lat = "121", lng = "1213")
        ),
        phone = "010101",
        website = "2323@m",
        company = Company(
            name = "Romaguera-Jacobson",
            catchPhrase = "Face to face bifurcated interface",
            bs = "e-enable strategic applications")
    )
    val user5 = User(
        id = 5,
        name = "e",
        username = "e",
        email = "sda@com",
        address = Address(
            street = "길",
            suite = "suite",
            city = "city",
            zipcode = "zipcode",
            geo = Geo(lat = "121", lng = "1213")
        ),
        phone = "010101",
        website = "2323@m",
        company = Company(
            name = "Romaguera-Jacobson",
            catchPhrase = "Face to face bifurcated interface",
            bs = "e-enable strategic applications")
    )
    val user6 = User(
        id = 6,
        name = "f",
        username = "f",
        email = "sda@com",
        address = Address(
            street = "길",
            suite = "suite",
            city = "city",
            zipcode = "zipcode",
            geo = Geo(lat = "121", lng = "1213")
        ),
        phone = "010101",
        website = "2323@m",
        company = Company(
            name = "Romaguera-Jacobson",
            catchPhrase = "Face to face bifurcated interface",
            bs = "e-enable strategic applications")
    )
    val user7 = User(
        id = 7,
        name = "g",
        username = "g",
        email = "sda@com",
        address = Address(
            street = "길",
            suite = "suite",
            city = "city",
            zipcode = "zipcode",
            geo = Geo(lat = "121", lng = "1213")
        ),
        phone = "010101",
        website = "2323@m",
        company = Company(
            name = "Romaguera-Jacobson",
            catchPhrase = "Face to face bifurcated interface",
            bs = "e-enable strategic applications")
    )
    val user8 = User(
        id = 8,
        name = "h",
        username = "h",
        email = "sda@com",
        address = Address(
            street = "길",
            suite = "suite",
            city = "city",
            zipcode = "zipcode",
            geo = Geo(lat = "121", lng = "1213")
        ),
        phone = "010101",
        website = "2323@m",
        company = Company(
            name = "Romaguera-Jacobson",
            catchPhrase = "Face to face bifurcated interface",
            bs = "e-enable strategic applications")
    )
    val user9 = User(
        id = 9,
        name = "i",
        username = "i",
        email = "sda@com",
        address = Address(
            street = "길",
            suite = "suite",
            city = "city",
            zipcode = "zipcode",
            geo = Geo(lat = "121", lng = "1213")
        ),
        phone = "010101",
        website = "2323@m",
        company = Company(
            name = "Romaguera-Jacobson",
            catchPhrase = "Face to face bifurcated interface",
            bs = "e-enable strategic applications")
    )
    val user10 = User(
        id = 10,
        name = "j",
        username = "j",
        email = "sda@com",
        address = Address(
            street = "길",
            suite = "suite",
            city = "city",
            zipcode = "zipcode",
            geo = Geo(lat = "121", lng = "1213")
        ),
        phone = "010101",
        website = "2323@m",
        company = Company(
            name = "Romaguera-Jacobson",
            catchPhrase = "Face to face bifurcated interface",
            bs = "e-enable strategic applications")
    )
    val list = listOf(user1,user2,user3,user4,user5,user6,user7,user8,user10,user9)


    override suspend fun getUsers(): List<User> {
        return list
    }
}