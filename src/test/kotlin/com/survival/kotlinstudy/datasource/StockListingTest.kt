package com.survival.kotlinstudy.datasource

import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs


class StockListingTest {

    @Test
    fun `csv로 StockListing 만들기 테스트`(): Unit = runBlocking {
        val stockDataSource = StockDataSourceImpl()
        val stockList = stockDataSource.getStockListings()

        val stock = stockList.first()
        assertIs<List<StockListing>>(stockList)
        assertEquals("-P-HIZ",stock.symbol)
        assertEquals("Presurance Holdings Inc",stock.name)
        assertEquals("NASDAQ",stock.exchange)
        assertEquals("Stock",stock.assetType)
        assertEquals("2023-08-30",stock.ipoDate)
        assertEquals("null",stock.delistingDate)
        assertEquals("Active",stock.status)
    }

}