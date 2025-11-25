package com.sesac.practice.day16.mapper

import com.sesac.practice.day16.core.parseDateTime
import com.sesac.practice.day16.dto.StoreDto
import com.sesac.practice.day16.model.Store

fun StoreDto.toModel(): Store = Store(
    address = addr ?: "주소 없음",
    createdAt = parseDateTime(createdAt),
    latitude = lat,
    longitude = lng,
    name = name ?: "이름 없음",
    remainStatus = remainStat ?: "",
    stockAt = parseDateTime(stockAt),
    type = type ?: "",
)
