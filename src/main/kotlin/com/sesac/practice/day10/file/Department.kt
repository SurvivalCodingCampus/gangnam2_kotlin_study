package com.sesac.practice.day10.file

import kotlinx.serialization.Serializable

@Serializable
data class Department(
    var name: String,
    var leader: Employee,
)
