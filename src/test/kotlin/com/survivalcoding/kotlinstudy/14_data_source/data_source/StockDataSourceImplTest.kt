package com.survivalcoding.kotlinstudy.`14_data_source`.data_source

import com.survivalcoding.kotlinstudy.`14_data_source`.model.StockListing
import kotlinx.coroutines.runBlocking
import org.junit.Test
import java.time.LocalDate
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class StockDataSourceImplTest {
    companion object {
        private val dataSource = StockDataSourceImpl()
        private const val SYMBOL = "-P-HIZ"
        private const val NAME = "Presurance Holdings Inc"
        private const val EXCHANGE = "NASDAQ"
        private const val ASSET_TYPE = "Stock"
        private const val IPO_DATE = "2023-08-30"
        private const val STATUS = "Active"
    }

    @Test
    fun `StockListing 리스트 확인`() = runBlocking {
        // when
        val stockList = dataSource.getStockListings()
        val stock = stockList[0]


        // then
        assertIs<List<StockListing>>(stockList)

        assertEquals(SYMBOL, stock.symbol)
        assertEquals(NAME, stock.name)
        assertEquals(EXCHANGE, stock.exchange)
        assertEquals(ASSET_TYPE, stock.assetType)
        assertEquals(LocalDate.parse(IPO_DATE), stock.ipoDate)
        assertEquals(null, stock.delistingDate)
        assertEquals(STATUS, stock.status)
    }

    @Test
    fun `StockListing 랜덤 테스트`() = runBlocking {
        // given
        val stockList = dataSource.getStockListings()

        // when
        val randomStock = stockList.random()

        // then
        assertNotNull(randomStock.symbol)
        assertTrue(randomStock.symbol.isNotBlank())

        assertNotNull(randomStock.name)
        assertTrue(randomStock.name.isNotBlank())

        assertNotNull(randomStock.exchange)
        assertTrue(randomStock.exchange.isNotBlank())

        assertNotNull(randomStock.assetType)
        assertTrue(randomStock.assetType.isNotBlank())

        assertNotNull(randomStock.ipoDate)
        
        randomStock.delistingDate?.let {
            assertIs<LocalDate>(it)
        }

        assertNotNull(randomStock.status)
        assertTrue(randomStock.status.isNotBlank())
    }

    @Test
    fun `모든 StockListing name 필드 비어있지 않음`() = runBlocking {
        // given
        val stockList = dataSource.getStockListings()

        // then
        assertTrue(stockList.all { it.name.isNotBlank() })
    }
}