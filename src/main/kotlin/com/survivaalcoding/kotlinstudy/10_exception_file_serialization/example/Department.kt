package com.survivaalcoding.kotlinstudy.`10_exception_file_serialization`.example

import kotlinx.serialization.Serializable

@Serializable
data class Department(var name: String, var leader: Employee)