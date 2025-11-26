package com.ezlevup.my.day251126.exercise.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CompanyDto(
    @SerialName("bs")
    val bs: String? = null,
    @SerialName("catchPhrase")
    val catchPhrase: String? = null,
    @SerialName("name")
    val name: String? = null
)