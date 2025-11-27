package com.luca.kotlinstudy._18_result.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Company(
    @SerialName("bs")
    val bs: String? = null,
    @SerialName("catchPhrase")
    val catchPhrase: String? = null,
    @SerialName("name")
    val name: String? = null,
)