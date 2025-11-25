package _251125_dto_mapper.exercise1.mapper

import _251125_dto_mapper.exercise1.dto.StoreDto
import _251125_dto_mapper.exercise1.model.Store

fun StoreDto.toStore(): List<Store> {
    val storeList = this.stores ?: emptyList()
//    val resultList = mutableListOf<Store>()
//
//    storeList.forEach {
//        resultList.add(
//            Store(
//                addr = it.addr ?: "",
//                code = it.code ?: "",
//                createdAt = it.createdAt ?: "",
//                lat = it.lat ?: 0.0,
//                lng = it.lng ?: 0.0,
//                name = it.name ?: "",
//                remainStat = it.remainStat ?: "",
//                stockAt = it.stockAt ?: "",
//                type = it.type ?: ""
//            )
//        )
//    }
    //함수형 프로그래밍으로 리펙토링
    val resultList = storeList.map {
        Store(
            addr = it.addr ?: "",
            code = it.code ?: "",
            createdAt = it.createdAt ?: "",
            lat = it.lat ?: 0.0,
            lng = it.lng ?: 0.0,
            name = it.name ?: "",
            remainStat = it.remainStat ?: "",
            stockAt = it.stockAt ?: "",
            type = it.type ?: ""
        )
    }
    return resultList.toList()

}