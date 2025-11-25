package com.neouul.sesac.`15-dto-mapper`.stores.mapper

import com.neouul.sesac.`15-dto-mapper`.stores.core.EMPTY_DOUBLE
import com.neouul.sesac.`15-dto-mapper`.stores.core.EMPTY_LOCALDATETIME
import com.neouul.sesac.`15-dto-mapper`.stores.core.EMPTY_STRING
import com.neouul.sesac.`15-dto-mapper`.stores.core.slashFormatStringToLocalDateTime
import com.neouul.sesac.`15-dto-mapper`.stores.dto.StoreDTO
import com.neouul.sesac.`15-dto-mapper`.stores.model.Store

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