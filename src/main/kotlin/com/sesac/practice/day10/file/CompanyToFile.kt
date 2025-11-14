package com.sesac.practice.day10.file

import kotlinx.serialization.json.Json
import java.io.File

class CompanyToFile {
    companion object {
        const val FILE_NAME = "company.txt"

        fun toFile(department: Department) {
            val json = Json.encodeToString(department)
            val file = File(FILE_NAME)
            file.writeText(json)
        }
    }
}
