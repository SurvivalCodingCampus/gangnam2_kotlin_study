package com.survivalcoding.kotlinstudy.`18_result`.mapper

import com.survivalcoding.kotlinstudy.`18_result`.dto.AddressDto
import com.survivalcoding.kotlinstudy.`18_result`.dto.CompanyDto
import com.survivalcoding.kotlinstudy.`18_result`.dto.GeoDto
import com.survivalcoding.kotlinstudy.`18_result`.dto.UserDto
import com.survivalcoding.kotlinstudy.`18_result`.model.Address
import com.survivalcoding.kotlinstudy.`18_result`.model.Company
import com.survivalcoding.kotlinstudy.`18_result`.model.Geo
import com.survivalcoding.kotlinstudy.`18_result`.model.User

fun UserDto.toModel(): User {
    return User(
        id = id ?: -1,
        name = name.orEmpty(),
        username = username.orEmpty(),
        email = email.orEmpty(),
        address = address?.toModel() ?: Address("", "", "", "", Geo(0.0, 0.0)),
        phone = phone.orEmpty(),
        website = website.orEmpty(),
        company = company?.toModel() ?: Company("", "", ""),
    )
}

fun AddressDto.toModel(): Address {
    return Address(
        street = street.orEmpty(),
        suite = suite.orEmpty(),
        city = city.orEmpty(),
        zipcode = zipcode.orEmpty(),
        geo = geo?.toModel() ?: Geo(0.0, 0.0),
    )
}

fun GeoDto.toModel(): Geo {
    return Geo(
        lat = lat?.toDoubleOrNull() ?: 0.0,
        lng = lng?.toDoubleOrNull() ?: 0.0,
    )
}

fun CompanyDto.toModel(): Company {
    return Company(
        name = name.orEmpty(),
        catchPhrase = catchPhrase.orEmpty(),
        bs = bs.orEmpty(),
    )
}