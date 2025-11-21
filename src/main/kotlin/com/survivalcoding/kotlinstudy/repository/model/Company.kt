package com.survivalcoding.kotlinstudy.repository.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Company(
    @SerialName("bs")
    val bs: String,
    @SerialName("catchPhrase")
    val catchPhrase: String,
    @SerialName("name")
    val name: String
)