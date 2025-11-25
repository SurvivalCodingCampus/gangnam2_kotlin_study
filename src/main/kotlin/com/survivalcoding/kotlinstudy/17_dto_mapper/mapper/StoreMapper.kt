package com.survivalcoding.kotlinstudy.`17_dto_mapper`.mapper

import com.survivalcoding.kotlinstudy.`17_dto_mapper`.dto.StoreDto
import com.survivalcoding.kotlinstudy.`17_dto_mapper`.model.Store

fun StoreDto.toStore(): Store {
    return Store(
        address = address,
        createdAt = createdAt,
        name = name,
        remainStat = remainStat,
        stockAt = stockAt,
    )
}
