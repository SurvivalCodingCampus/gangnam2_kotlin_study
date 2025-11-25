package com.neouul.sesac.`15-dto-mapper`.stores.repository

import com.neouul.sesac.`15-dto-mapper`.stores.data_source.RemoteDataSource
import com.neouul.sesac.`15-dto-mapper`.stores.mapper.toModel
import com.neouul.sesac.`15-dto-mapper`.stores.model.Store

class StoreRepositoryImpl(
    private val dataSource: RemoteDataSource,
) : StoreRepository {
    override suspend fun getStores(): List<Store> {
        val response = dataSource.getStores()

        if (response.body?.count != null && response.body.stores != null) {
            return response.body.stores
                .filter { it?.remain_stat != null && it.stock_at != null && it.created_at != null }
                .map { it?.toModel() as Store }
        }
        return listOf()
    }
}