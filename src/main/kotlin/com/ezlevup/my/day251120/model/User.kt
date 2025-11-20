package com.ezlevup.my.day251120.model

import kotlinx.serialization.Serializable


@Serializable
data class User(
    var id: Int,
    var name: String,
    var username: String,
    var email: String,
    var address: Address,
    var phone: String,
    var website: String,
    var company: Company,
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
