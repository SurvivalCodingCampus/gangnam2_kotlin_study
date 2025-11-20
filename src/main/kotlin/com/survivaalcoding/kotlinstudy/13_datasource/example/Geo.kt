package com.survivaalcoding.kotlinstudy.`13_datasource`.example

import kotlinx.serialization.Serializable

@Serializable
data class Geo(val lat: String, val lng: String)