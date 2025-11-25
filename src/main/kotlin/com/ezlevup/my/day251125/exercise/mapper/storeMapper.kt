package com.ezlevup.my.day251125.exercise.mapper

import com.ezlevup.my.day251125.exercise.dto.MaskStoreDto
import com.ezlevup.my.day251125.exercise.model.Store

fun MaskStoreDto.toStore(): List<Store> {
    return stores.orEmpty().filterNotNull()
        .filter { it ->
            it.remainStat != null && it.stockAt != null && it.createdAt != null
        }
        .map { it ->
            Store(
                code = it.code ?: "",
                name = it.name ?: "",
                address = it.addr ?: "",
                createAt = it.createdAt ?: "",
                stockAt = it.stockAt ?: "",
            )
        }
}
