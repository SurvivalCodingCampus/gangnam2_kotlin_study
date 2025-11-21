package com.survival.kotlinstudy.day16.datasource

import java.io.File

class MockImageDataSourceImpl : ImageDataSource {

    override suspend fun fetchImage(url: String): ByteArray {

        return byteArrayOf(1, 2, 3)
    }

    override suspend fun saveImage(bytes: ByteArray, path: String) {
        val file = File(path)
        file.writeBytes(bytes)
    }

}