package com.survivalcoding.kotlinstudy.`17_dto`.practice.store.repository

import com.survivalcoding.kotlinstudy.`17_dto`.practice.store.data_source.StoreDataSource
import com.survivalcoding.kotlinstudy.`17_dto`.practice.store.data_source.StoreDataSourceImpl
import com.survivalcoding.kotlinstudy.`17_dto`.practice.store.mapper.toStore
import com.survivalcoding.kotlinstudy.`17_dto`.practice.store.model.Store
import kotlinx.coroutines.runBlocking

class StoreRepositoryImpl(
    private val dataSource: StoreDataSource
) : StoreRepository {
    override suspend fun getStores(): List<Store> {
        return dataSource.getStores()
            .filter { it.remain_stat != null && it.stock_at != null && it.created_at != null }
            .map { it.toStore() }
    }

    override suspend fun getStore(code: Int): Store {
        return dataSource.getStore(code).toStore()
    }
}

fun main(): Unit = runBlocking {
    val c1 = StoreDataSourceImpl()
    val c2 = StoreRepositoryImpl(c1).getStores()

    println(c2)
}