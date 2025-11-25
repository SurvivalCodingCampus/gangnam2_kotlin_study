package com.sesac.practice.day16.repository

import com.sesac.practice.day16.datasource.StoreDataSource
import com.sesac.practice.day16.mapper.toModel
import com.sesac.practice.day16.model.Store

class StoreRepositoryImpl(
    private val dataSource: StoreDataSource,
) : StoreRepository {

    override suspend fun getStores(): List<Store> {
        val response = dataSource.getStores()

        val storeDtos = response.body?.stores ?: emptyList()

        return storeDtos.map { it.toModel() }
            .filter { it.remainStatus.isNotBlank() && it.stockAt != null && it.createdAt != null }
    }
}
