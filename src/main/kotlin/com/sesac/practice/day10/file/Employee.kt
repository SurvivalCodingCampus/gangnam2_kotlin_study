package com.sesac.practice.day10.file

import kotlinx.serialization.Serializable

@Serializable
data class Employee(
    var name: String,
    var age: Int,
)
