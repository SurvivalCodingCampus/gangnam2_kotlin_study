package com.survivaalcoding.kotlinstudy.`13_datasource`.example.fourth

import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals
import kotlin.test.assertIs

class StockDataSourceImplTest {
    @Test
    fun `json 데이터를 역직렬화해서 StockListing 객체로 가져온다`() {
        // given
        val symbol = "-P-HIZ"
        val name = "Presurance Holdings Inc"
        val exchange = "NASDAQ"
        val assetType = "Stock"
        val ipoDate = "2023-08-30"
        val delistingDate = null
        val status = "Active"

        val stockListing = StockListing(symbol, name, exchange, assetType, ipoDate, delistingDate, status)

        runBlocking {
            // when
            val actual = StockDataSourceImpl().getStockListings()

            // then
            assertIs<List<StockListing>>(actual)
            assertEquals(actual.size, 12414)
            assertContains(actual, stockListing)
        }
    }
}