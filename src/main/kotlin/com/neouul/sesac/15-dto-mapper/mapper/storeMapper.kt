package com.neouul.sesac.`15-dto-mapper`.mapper

import com.neouul.sesac.`15-dto-mapper`.core.*
import com.neouul.sesac.`15-dto-mapper`.dto.StoreDTO
import com.neouul.sesac.`15-dto-mapper`.model.Store
import java.time.LocalDateTime

fun StoreDTO.toModel(): Store {
    return Store(
        address = addr ?: EMPTY_STRING,
        code = code ?: EMPTY_STRING,
        createdAt = created_at?.slashFormatStringToLocalDateTime() ?: EMPTY_LOCALDATETIME,
        latitude = lat ?: EMPTY_DOUBLE,
        longitude = lng ?: EMPTY_DOUBLE,
        name = name ?: EMPTY_STRING,
        remainStat = remain_stat ?: EMPTY_STRING,
        stockAt = stock_at?.slashFormatStringToLocalDateTime() ?: EMPTY_LOCALDATETIME,
    )
}