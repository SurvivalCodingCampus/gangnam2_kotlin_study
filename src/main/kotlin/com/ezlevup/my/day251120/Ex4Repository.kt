package com.ezlevup.my.day251120

import com.ezlevup.my.day251120.data_source.FileUserDataSourceImpl
import com.ezlevup.my.day251120.data_source.MockUserDataSourceImpl
import com.ezlevup.my.day251120.model.Address
import com.ezlevup.my.day251120.model.Company
import com.ezlevup.my.day251120.model.Geo
import com.ezlevup.my.day251120.model.User
import com.ezlevup.my.day251120.repository.UserRepositoryImpl
import kotlinx.coroutines.runBlocking


fun main(): Unit = runBlocking {
    val userRepository = UserRepositoryImpl(FileUserDataSourceImpl())
    println(userRepository.getUsers().count())
    userRepository.getUsersTop10ByUserName().forEach(::println)


    val users = listOf(
        User(
            id = 1, name = "lee1",
            username = "lee1", email = "lee1@naver.com",
            address = Address(
                street = "lee-street1",
                suite = "lee-suite1",
                city = "Seoul",
                zipcode = "12345",
                geo = Geo(lat = "37.5665", lng = "126.9780")
            ),
            phone = "010-1111-1111",
            website = "lee1.com",
            company = Company(
                name = "LeeCompany1",
                catchPhrase = "First lee company",
                bs = "lee-business-1"
            )
        ),
        User(
            id = 2, name = "lee2",
            username = "lee2", email = "lee2@naver.com",
            address = Address(
                street = "lee-street2",
                suite = "lee-suite2",
                city = "Busan",
                zipcode = "54321",
                geo = Geo(lat = "35.1796", lng = "129.0756")
            ),
            phone = "010-2222-2222",
            website = "lee2.com",
            company = Company(
                name = "LeeCompany2",
                catchPhrase = "Second lee company",
                bs = "lee-business-2"
            )
        )
    )

    UserRepositoryImpl(MockUserDataSourceImpl(users)).getUsersTop10ByUserName().forEach { println(it) }
    UserRepositoryImpl(MockUserDataSourceImpl(users)).getUsers().forEach { println(it) }
}