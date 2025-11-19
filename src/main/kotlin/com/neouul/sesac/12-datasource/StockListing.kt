package com.neouul.sesac.`12-datasource`

import java.time.LocalDate

data class StockListing(
    val symbol: String,
    val name: String,
    val exchange: String,
    val assetType: String,
    val ipoDate: LocalDate,
    val delistingDate: LocalDate? = null,
    val status: String,
)

// enum 클래스로 데이터 범위를 한정하고 싶었으나,
// 공백인 name을 제외하는 것을 고려하면 다른 필드에서 null값을 가지는 것이 자연스러워 보이지는 않음
// 그런데 ipoDate와 delistingDate는 LocalDate? 타입으로 하고 널 허용 하고싶은데...
enum class AssetType {
    ETF, STOCK
}

enum class Status {
    ACTIVE
}