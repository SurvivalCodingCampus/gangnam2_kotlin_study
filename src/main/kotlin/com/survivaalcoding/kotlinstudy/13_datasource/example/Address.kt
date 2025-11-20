package com.survivaalcoding.kotlinstudy.`13_datasource`.example

import kotlinx.serialization.Serializable

@Serializable
data class Address(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    val geo: Geo
)