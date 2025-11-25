package com.neouul.sesac.`15-dto-mapper`.core

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun String.slashFormatStringToLocalDateTime(): LocalDateTime {
    val formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")
    return LocalDateTime.parse(this, formatter)
}