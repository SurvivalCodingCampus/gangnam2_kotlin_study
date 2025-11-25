package _251125_dto_mapper.exercise1.repository

import _251125_dto_mapper.exercise1.data_source.StoreDataSourceImpl
import _251125_dto_mapper.exercise1.mapper.toModel
import _251125_dto_mapper.exercise1.model.Store

class StoreRepositoryImpl(
    private val storeDataSourceImpl: StoreDataSourceImpl
) : StoreRepository {
    override suspend fun deleteInvalidData(): List<Store> {
        return storeDataSourceImpl.getAllStore().body.stores.map { it.toModel() }
            .filter { it.remainStat.isNotEmpty() && it.stockAt.isNotEmpty() && it.createdAt.isNotEmpty() }
    }
}