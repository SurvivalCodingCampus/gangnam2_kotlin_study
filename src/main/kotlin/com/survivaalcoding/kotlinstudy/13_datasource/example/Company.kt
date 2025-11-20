package com.survivaalcoding.kotlinstudy.`13_datasource`.example

import kotlinx.serialization.Serializable

@Serializable
data class Company(val name: String, val catchPhrase: String, val bs: String)