package com.sesac.practice.day14.comment

import com.sesac.practice.day14.decodeFromFile
import java.io.File

class FileCommentDataSourceImpl(
    private val pathname: String,
) : CommentDataSource {

    override suspend fun getComments(): List<Comment> {
        val file = File(pathname)

        return file.decodeFromFile()
    }
}
