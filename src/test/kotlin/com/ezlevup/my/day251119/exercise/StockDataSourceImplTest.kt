package com.ezlevup.my.day251119.exercise

import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class StockDataSourceImplTest {
    @Test
    fun `Stock 생성자`() {
        // given
        val stockDataSource = StockDataSourceImpl()

        // when & then
        assertNotNull(stockDataSource)
    }

    @Test
    fun `Stock 데이터 가지고 오기`(): Unit = runBlocking {
        // given
        val stockDataSource = StockDataSourceImpl()

        // when
        val stocks = stockDataSource.getStockListings()

        // then
        assertNotNull(stocks)
    }

    @Test
    fun `Stock 데이터 불량이 있다`(): Unit = runBlocking {
        // given
        val stockDataSource = StockDataSourceImpl()

        // when
        val stocks = stockDataSource.getStockListings()
        val invalidCount: Int = stocks.count { it ->
            it.symbol.isNullOrEmpty()
                    || it.name.isNullOrEmpty()
                    || it.exchange.isNullOrEmpty()
                    || it.assetType.isNullOrEmpty()
                    || it.ipoDate == null
                    // || it.delistingDate.isNullOrEmpty()
                    || it.status.isNullOrEmpty()
        }

        // then
        // assertEquals(0, invalidCount)
        assertTrue(0 < invalidCount)
    }
}