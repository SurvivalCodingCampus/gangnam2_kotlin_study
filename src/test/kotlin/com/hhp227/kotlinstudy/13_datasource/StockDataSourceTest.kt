package com.hhp227.kotlinstudy.`13_datasource`

import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class StockDataSourceTest {
    val stockDataSource = StockDataSourceImpl()

    @Test
    fun `파일이 존재하는지 확인`() {
        val stockCsv = this::class.java.classLoader.getResource("listing_status.csv")

        assertNotNull(stockCsv, "listing_status.csv 파일이 존재해야 합니다.")
    }

    @Test
    fun `Stock리스트 크기가 일치한지 테스트`() = runTest {
        val stockListing = stockDataSource.getStockListings()
        val expected = 12414

        assertEquals(expected, stockListing.size)
    }

    @Test
    fun `StockListings 첫번째 객체가 일치한지 테스트`() = runTest {
        val expected = StockListing("-P-HIZ", "Presurance Holdings Inc", "NASDAQ", "Stock", "2023-08-30", "null", "Active")
        val stockListings = stockDataSource.getStockListings()
        val firstStock = stockListings.first()

        assertEquals(expected, firstStock)
    }

    @Test
    fun `User리스트 마지막 객체가 일치한지 테스트`() = runTest {
        val expected = StockListing("ZZZ", "TEST TICKER FOR UTP", "NYSE ARCA", "Stock", "2014-10-31", "null", "Active")
        val stockListings = stockDataSource.getStockListings()
        val lastStock = stockListings.last()

        assertEquals(expected, lastStock)
    }
}