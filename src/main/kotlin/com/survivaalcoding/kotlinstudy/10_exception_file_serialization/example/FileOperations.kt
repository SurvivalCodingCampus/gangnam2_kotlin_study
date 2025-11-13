package com.survivaalcoding.kotlinstudy.`10_exception_file_serialization`.example

import java.io.File

interface FileOperations {
    fun copyFile(source: File, destination: File)
}