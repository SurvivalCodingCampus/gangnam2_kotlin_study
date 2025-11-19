package com.neouul.sesac.`12-datasource`

import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test
import java.time.LocalDate

class StockDataSourceImplTest {
    @Test
    fun `인스턴스가 잘 생성되는가`() {
        val stockDataSourceImpl = StockDataSourceImpl()

        assertTrue(stockDataSourceImpl is StockDataSourceImpl)
        assertTrue(stockDataSourceImpl is StockDataSource)
    }

    @Test
    fun `toLocalDate 메서드가 localDate을 적절히 반환되는가 - "2025-11-11"일 때`() {
        // given
        val string = "2025-11-11"

        // when
        val localDate = StockDataSourceImpl().toLocalDate(string)

        // then
        assertTrue(localDate is LocalDate)
        assertEquals(2025, localDate.year)
        assertEquals(11, localDate.monthValue)
        assertEquals(11, localDate.dayOfMonth)
    }

    @Test
    fun `toNullOrDate 메서드가 localDate?을 적절히 반환되는가 - "null"일 때`() {
        // given
        val string = "null"

        // when
        val localDate = StockDataSourceImpl().toNullOrDate(string)

        // then
        assertNull(localDate)
    }

    @Test
    fun `toNullOrDate 메서드가 localDate?을 적절히 반환되는가 - "2025-11-11"일 때`() {
        // given
        val string = "2025-11-11"

        // when
        val localDate = StockDataSourceImpl().toNullOrDate(string)

        // then
        assertTrue(localDate is LocalDate)
        assertEquals(2025, localDate?.year)
        assertEquals(11, localDate?.monthValue)
        assertEquals(11, localDate?.dayOfMonth)
    }

    @Test
    fun `연습문제 4 - getStockListings 메서드가 List StockListing을 적절히 반환하는가`() = runBlocking {
        // given
        val stockDataSourceImpl = StockDataSourceImpl()

        // when
        val list = stockDataSourceImpl.getStockListings()

        // then
        list.forEach {
            assertTrue(it.name != "")
            assertTrue(it.symbol is String)
            assertTrue(it.name is String)
            assertTrue(it.exchange is String)
            assertTrue(it.assetType is String)
            assertTrue(it.ipoDate is LocalDate)
            assertTrue(it.delistingDate is LocalDate?)
            assertTrue(it.status is String)
        }
    }
}