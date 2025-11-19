package com.survivalcoding.kotlinstudy.`14_data_source`.data_source

import com.survivalcoding.kotlinstudy.`14_data_source`.model.Todo

interface TodoDataSource {
    suspend fun getTodo() : Todo
}
