package com.neouul.sesac.`15-dto-mapper`.stores.core

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun String.slashFormatToLocalDateTimeOrNull(): LocalDateTime? {
    val formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")
    return runCatching { LocalDateTime.parse(this, formatter) }.getOrNull()
}