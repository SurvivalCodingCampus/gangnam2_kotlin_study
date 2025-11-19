package com.sesac.practice.day13

import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull

class StockDataSourceImplTest {
    @Test
    fun `listing_status_csv 파일을 읽어서 StockListing 객체 리스트로 변환한다`() = runTest {
        // given
        val filename = "data/listing_status.csv"
        val dataSource = StockDataSourceImpl(filename)

        // when
        val stockListings = dataSource.getStockListings()

        // then
        stockListings.forEach {
            assertNotNull(it.name)
        }

        val stockListing = stockListings.first()
        assertEquals("-P-HIZ", stockListing.symbol)
        assertEquals("Presurance Holdings Inc", stockListing.name)
        assertEquals("NASDAQ", stockListing.exchange)
        assertEquals("Stock", stockListing.assetType)
        assertEquals("2023-08-30", stockListing.ipoDate)
        assertNull(stockListing.delistingDate)
        assertEquals("Active", stockListing.status)
    }
}
