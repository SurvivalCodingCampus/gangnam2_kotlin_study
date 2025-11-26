package _251125_dto_mapper.exercise1.mapper

import _251125_dto_mapper.exercise1.dto.StoreDto
import _251125_dto_mapper.exercise1.model.Store

fun StoreDto.toModel(): Store {

    return Store(
        addr = addr ?: "",
        code = code ?: "",
        createdAt = createdAt ?: "",
        lat = lat ?: 0.0,
        lng = lng ?: 0.0,
        name = name ?: "",
        remainStat = remainStat ?: "",
        stockAt = stockAt ?: "",
        type = type ?: ""
    )

}