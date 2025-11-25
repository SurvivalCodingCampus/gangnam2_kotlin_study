package _251125_dto_mapper.exercise2.data_source

import _251125_dto_mapper.exercise2.core.Response
import _251125_dto_mapper.exercise2.dto.PhotoDto

interface PhotoDataSource {
    suspend fun getAllPhoto(): Response<List<PhotoDto>>
}