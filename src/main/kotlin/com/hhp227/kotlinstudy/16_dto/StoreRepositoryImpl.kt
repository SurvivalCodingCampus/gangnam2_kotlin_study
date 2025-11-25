package com.hhp227.kotlinstudy.`16_dto`

class StoreRepositoryImpl(
    private val dataSource: StoreDataSource
) : StoreRepository {
    override suspend fun getStores(): List<Store> {
        val storeList = dataSource.fetchMaskStore().stores
        return storeList
            .filter {
                !it.remainStat.isNullOrBlank() &&
                        !it.stockAt.isNullOrBlank() &&
                        !it.createdAt.isNullOrBlank()
            }
            .mapNotNull { it.toModel() }
    }
}