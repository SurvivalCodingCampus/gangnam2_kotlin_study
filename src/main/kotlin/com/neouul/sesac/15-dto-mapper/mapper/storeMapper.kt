package com.neouul.sesac.`15-dto-mapper`.mapper

import com.neouul.sesac.`15-dto-mapper`.core.slashFormatStringToLocalDateTime
import com.neouul.sesac.`15-dto-mapper`.dto.StoreDTO
import com.neouul.sesac.`15-dto-mapper`.model.Store
import java.time.LocalDateTime

fun StoreDTO.toModel(): Store {
    return Store(
        address = addr ?: "",
        code = code ?: "",
        createdAt = created_at?.slashFormatStringToLocalDateTime()
            ?: LocalDateTime.of(2000, 1, 1, 0, 0, 0),
        latitude = lat ?: 0.0,
        longitude = lng ?: 0.0,
        name = name ?: "",
        remainStat = remain_stat ?: "",
        stockAt = stock_at?.slashFormatStringToLocalDateTime()
            ?: LocalDateTime.of(2000, 1, 1, 0, 0, 0),
    )
}