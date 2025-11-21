package com.hhp227.kotlinstudy.`13_datasource`

import java.io.BufferedReader
import java.io.InputStreamReader

object FileLoadUtil {
    fun loadFileToString(filename: String): String {
        val inputStream = this::class.java.classLoader.getResourceAsStream(filename)
            ?: throw IllegalArgumentException("$filename not found")
        return BufferedReader(InputStreamReader(inputStream)).use(BufferedReader::readText)
    }

    fun loadFileToStringList(filename: String): List<String> {
        val inputStream = this::class.java.classLoader.getResourceAsStream(filename)
            ?: throw IllegalArgumentException("$filename not found")
        return BufferedReader(InputStreamReader(inputStream)).use(BufferedReader::readLines)
    }
}