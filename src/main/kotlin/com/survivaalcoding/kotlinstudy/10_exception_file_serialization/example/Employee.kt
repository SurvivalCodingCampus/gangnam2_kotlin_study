package com.survivaalcoding.kotlinstudy.`10_exception_file_serialization`.example

import kotlinx.serialization.Serializable

@Serializable
data class Employee(var name: String, var age: Int)