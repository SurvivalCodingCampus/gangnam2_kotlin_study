package com.survivalcoding.kotlinstudy.`18_result`.practice.mapper

import com.survivalcoding.kotlinstudy.`18_result`.practice.dto.AddressDto
import com.survivalcoding.kotlinstudy.`18_result`.practice.dto.CompanyDto
import com.survivalcoding.kotlinstudy.`18_result`.practice.dto.GeoDto
import com.survivalcoding.kotlinstudy.`18_result`.practice.dto.UserDto
import com.survivalcoding.kotlinstudy.`18_result`.practice.model.Address
import com.survivalcoding.kotlinstudy.`18_result`.practice.model.Company
import com.survivalcoding.kotlinstudy.`18_result`.practice.model.Geo
import com.survivalcoding.kotlinstudy.`18_result`.practice.model.User

fun UserDto.toDomain(): User =
    User(
        id = id ?: 0,
        name = name ?: "",
        username = username ?: "",
        email = email ?: "",
        address = address?.toDomain()
            ?: Address(
                street = "",
                suite = "",
                city = "",
                zipcode = "",
                geo = Geo(lat = "", lng = "")
            ),
        phone = phone ?: "",
        website = website ?: "",
        company = company?.toDomain()
            ?: Company(
                name = "",
                catchPhrase = "",
                bs = ""
            )
    )

fun AddressDto.toDomain(): Address =
    Address(
        street = street ?: "",
        suite = suite ?: "",
        city = city ?: "",
        zipcode = zipcode ?: "",
        geo = geo?.toDomain() ?: Geo(lat = "", lng = "")
    )

fun GeoDto.toDomain(): Geo =
    Geo(
        lat = lat ?: "",
        lng = lng ?: ""
    )

fun CompanyDto.toDomain(): Company =
    Company(
        name = name ?: "",
        catchPhrase = catchPhrase ?: "",
        bs = bs ?: ""
    )

