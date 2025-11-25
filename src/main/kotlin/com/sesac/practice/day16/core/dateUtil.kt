package com.sesac.practice.day16.core

import java.time.DateTimeException
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private val DATE_TIME_FORMATTER: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")
private val DATE_FORMATTER: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

fun parseDateTime(dateTime: String?): LocalDateTime? = dateTime?.let {
    try {
        LocalDateTime.parse(dateTime, DATE_TIME_FORMATTER)
    } catch (_: DateTimeException) {
        null
    }
}

fun parseDate(date: String?): LocalDate? = date?.let {
    try {
        LocalDate.parse(date, DATE_FORMATTER)
    } catch (_: DateTimeException) {
        null
    }
}
