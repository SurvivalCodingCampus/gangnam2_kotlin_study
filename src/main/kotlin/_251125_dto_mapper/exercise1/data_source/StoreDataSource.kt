package _251125_dto_mapper.exercise1.data_source

import _251125_dto_mapper.exercise1.core.Response
import _251125_dto_mapper.exercise1.dto.Stores

interface StoreDataSource {
    suspend fun getAllStore(): Response<Stores>
}