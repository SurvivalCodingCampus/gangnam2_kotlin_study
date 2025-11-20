package com.luca.kotlinstudy._15_model_repository.model

class User (
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val adress: Address,
    val phone: String,
    val website: String,
    val company: Company,
)
class Address (
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    val geo: com.luca.kotlinstudy._15_model_repository.model.Geo,
)
class Geo (
    val lat: Double,
    val lng: Double,
)

class Company (
    val name: String,
    val catchPhrase: String,
    val bs: String,
)