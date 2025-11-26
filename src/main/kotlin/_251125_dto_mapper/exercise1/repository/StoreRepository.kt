package _251125_dto_mapper.exercise1.repository

import _251125_dto_mapper.exercise1.model.Store

interface StoreRepository {
    suspend fun deleteInvalidData(): List<Store>
}