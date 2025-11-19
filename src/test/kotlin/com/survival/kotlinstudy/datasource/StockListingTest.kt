package com.survival.kotlinstudy.datasource

import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertIs


class StockListingTest {

    @Test
    fun `csv로 StockListing 만들기 테스트`(): Unit = runBlocking {
        val stockDataSource = StockDataSourceImpl()
        val stockList = stockDataSource.getStockListings()


        assertIs<List<StockListing>>(stockList)
    }

}