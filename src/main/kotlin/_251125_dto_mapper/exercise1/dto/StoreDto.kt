package _251125_dto_mapper.exercise1.dto


import kotlinx.serialization.Serializable

@Serializable
data class StoreDto(
    val count: Int?,
    val stores: List<Store>?
)