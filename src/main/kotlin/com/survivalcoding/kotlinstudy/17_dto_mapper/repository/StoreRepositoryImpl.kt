package com.survivalcoding.kotlinstudy.`17_dto_mapper`.repository

import com.survivalcoding.kotlinstudy.`17_dto_mapper`.data_source.StoreDataSource
import com.survivalcoding.kotlinstudy.`17_dto_mapper`.mapper.toStore
import com.survivalcoding.kotlinstudy.`17_dto_mapper`.model.Store

class StoreRepositoryImpl(
    private val dataSource: StoreDataSource
) : StoreRepository {
    override suspend fun getStores(): List<Store> {
        return dataSource.getStores()
            .filter {
                !it.remainStat.isNullOrBlank() &&
                        !it.createdAt.isNullOrBlank() &&
                        !it.stockAt.isNullOrBlank()
            }
            .map { it.toStore() }
    }
}
