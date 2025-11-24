package com.neouul.sesac.`14-network`.Exercise.repository

import com.neouul.sesac.`14-network`.Exercise.core.makeFileNmae
import com.neouul.sesac.`14-network`.Exercise.core.toFileNameFromUrl
import com.neouul.sesac.`14-network`.Exercise.data_source.ImageDataSource
import java.io.File

class ImageRepositoryImpl(
    private val dataSource: ImageDataSource,
) : ImageRepository {
    // URL에서 이미지를 다운로드하여 지정된 경로에 저장
    override suspend fun saveImage(url: String, path: String) {
        val bytes = dataSource.fetchImage(url)
        dataSource.saveImage(bytes, path)
    }

    // 여러 URL의 이미지들을 지정된 디렉토리에 저장
    override suspend fun saveImages(urls: List<String>, directory: String) {
        val directoryFile = File(directory)
        if (!directoryFile.exists()) {
            // mkdirs()는 중간 경로가 없으면 그것까지 다 만들어줌
            directoryFile.mkdirs()
        }

        urls.forEachIndexed { index, url ->
            val fileName = url.toFileNameFromUrl()
            val bytes = dataSource.fetchImage(url)
            val path = makeFileNmae(directory, fileName)
            dataSource.saveImage(bytes, path)
        }
    }

    // 이미지가 존재하지 않는 경우에만 URL에서 다운로드하여 저장
    override suspend fun saveImageIfNotExists(url: String, path: String): Boolean {
        val file = File(path)
        if (!file.exists()) return false

        val bytes = dataSource.fetchImage(url)
        dataSource.saveImage(bytes, path)
        return true
    }
}