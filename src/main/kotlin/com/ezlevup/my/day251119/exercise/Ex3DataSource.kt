package com.ezlevup.my.day251119.exercise

import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.io.File

@Serializable
data class User(
    var id: Long? = 0,
    var name: String? = null,
    var username: String? = null,
    var email: String? = null,
    var address: Address? = null,
    var phone: String? = null,
    var website: String? = null,
    var company: Company? = null,
)

@Serializable
data class Address(
    var street: String,
    var suite: String,
    var city: String,
    var zipcode: String,
    var geo: Geo,
)

@Serializable
data class Geo(
    var lat: String,
    var lng: String,
)

@Serializable
data class Company(
    var name: String,
    var catchPhrase: String,
    var bs: String,
)


interface UserDataSource {
    suspend fun getUsers(): List<User>
}

class UserDataSourceImpl : UserDataSource {
    override suspend fun getUsers(): List<User> {
        val file = File("user_ex3.json")
        val json = file.readText()
        return Json.decodeFromString<List<User>>(json)
    }
}

fun main(): Unit = runBlocking {
    val userData = UserDataSourceImpl()
    val users = userData.getUsers()
    users.take(5).forEach { println(it) }
    println(users.count())

    // 불량 데이터 확인
    users.filter { it ->
        it.id == 0L
                || it.name.isNullOrEmpty()
                || it.username.isNullOrEmpty()
                || it.email.isNullOrEmpty()
                || it.address == null
                || it.phone.isNullOrEmpty()
                || it.website.isNullOrEmpty()
                || it.company == null
    }.forEach { println(it) }
}
