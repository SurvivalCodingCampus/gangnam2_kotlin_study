package com.sesac.practice.day15.core

import java.io.File

class FileProviderImpl : FileProvider {
    override fun exists(path: String): Boolean = File(path).exists()
}
