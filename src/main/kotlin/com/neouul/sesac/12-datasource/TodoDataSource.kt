package com.neouul.sesac.`12-datasource`

interface TodoDataSource {
    suspend fun getTodo(): Todo

}