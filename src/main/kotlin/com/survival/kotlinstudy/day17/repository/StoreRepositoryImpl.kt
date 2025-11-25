package com.survival.kotlinstudy.day17.repository

import com.survival.kotlinstudy.day17.datasource.StoreDataSource
import com.survival.kotlinstudy.day17.mapper.toModel
import com.survival.kotlinstudy.day17.model.Store

class StoreRepositoryImpl(
    private val datasource: StoreDataSource
) : StoreRepository {

    override suspend fun getStores(): List<Store> {
        val stores = datasource.getStores().stores ?: emptyList()

        return stores.filter { it.remainStat != null && it.createdAt != null && it.stockAt != null }
            .map { it.toModel() }
    }
}
