package com.survivaalcoding.kotlinstudy.`16_dto_mapper`.example.repository

import com.survivaalcoding.kotlinstudy.`16_dto_mapper`.example.datasource.StoreDataSource
import com.survivaalcoding.kotlinstudy.`16_dto_mapper`.example.dto.StoreDto
import com.survivaalcoding.kotlinstudy.`16_dto_mapper`.example.dto.isValid
import com.survivaalcoding.kotlinstudy.`16_dto_mapper`.example.mapper.toModel
import com.survivaalcoding.kotlinstudy.`16_dto_mapper`.example.model.Store

class StoreRepositoryImpl(private val dataSource: StoreDataSource) : StoreRepository {
    override suspend fun getStores(): List<Store> {
        val stores = dataSource.getStores().body?.stores ?: return emptyList()

        return stores.filter(StoreDto::isValid)
            .map(StoreDto::toModel)
    }
}