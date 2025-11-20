package com.luca.kotlinstudy._14_dataSource

import com.luca.kotlinstudy._14_dataSource.StockDataSourceImpl.Companion.stockFilePath
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test
import kotlin.test.assertIs

class StockListingTest {
    @Test
    fun `stokingList가 잘 파싱되는지 확인`() = runBlocking {
        val dataSource: StockDataSource = StockDataSourceImpl(stockFilePath)
        val listings = dataSource.getStockListings()


        // 첫 번째 데이터 확인 (CSV 내용과 비교)
        val firstStock = listings.first()

        assertEquals("-P-HIZ", firstStock.symbol)
        assertEquals("Presurance Holdings Inc", firstStock.name)
        assertEquals("NASDAQ", firstStock.exchange)
        assertEquals("Stock", firstStock.assetType)
        assertEquals("2023-08-30", firstStock.ipoDate)
        assertEquals("null", firstStock.delistingDate)
        assertEquals("Active", firstStock.status)
    }
}