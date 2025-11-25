package com.ezlevup.my.core

import java.time.LocalDate
import java.time.format.DateTimeParseException

fun String?.toLocalDateOrNull(): LocalDate? {
    if (this.isNullOrBlank()) return null
    return try {
        LocalDate.parse(this)
    } catch (e: DateTimeParseException) {
        null
    }
}
