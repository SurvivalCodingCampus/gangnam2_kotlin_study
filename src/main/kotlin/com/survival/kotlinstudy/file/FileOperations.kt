package com.survival.kotlinstudy.file

import java.io.File

interface FileOperations {
    fun copyFile(source: File, destination: File)
}