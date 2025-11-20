package _251119_datasource.exercise3

import kotlinx.serialization.Serializable

const val FILE_PATH =
    "src\\main\\kotlin\\_251119_datasource\\exercise3\\users.json"

interface UserDataSource {
    suspend fun getUsers(): List<User>
}

@Serializable
data class User(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val address: Address,
    val phone: String,
    val website: String,
    val company: Company
)

@Serializable
data class Company(
    val name: String,
    val catchPhrase: String,
    val bs: String
)

@Serializable
data class Address(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    val geo: Geo
)

@Serializable
data class Geo(
    val lat: String,
    val lng: String
)