package com.luca.kotlinstudy._17_dto.repository

import com.luca.kotlinstudy._17_dto.datasource.StoreDataSource
import com.luca.kotlinstudy._17_dto.mapper.toModel
import com.luca.kotlinstudy._17_dto.model.Store

class StoreRepositoryImpl(
    private val dataSource: StoreDataSource
) : StoreRepository {

    override suspend fun getStores(): List<Store> {
        val response = dataSource.getStores()
        val dtoList = response.body ?: return emptyList()

        return dtoList
            .filter { !it.remainStat.isNullOrBlank() }
            .filter { !it.stockAt.isNullOrBlank() }
            .filter { !it.createdAt.isNullOrBlank() }
            .map { it.toModel() }
    }
}
