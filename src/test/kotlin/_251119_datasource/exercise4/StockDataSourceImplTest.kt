package _251119_datasource.exercise4

import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

class StockDataSourceImplTest {
    @Test
    fun `listing_status_csv를 읽어서 StockListing리스트 객체를 반환한다`() = runTest {
        //given
        val stockDataSourceImpl = StockDataSourceImpl()
        //when
        val result = stockDataSourceImpl.getStockListings()
        //then
        //첫 데이터 검사
        assertEquals("-P-HIZ", result[0].symbol)
        assertEquals("Presurance Holdings Inc", result[0].name)
        assertEquals("NASDAQ", result[0].exchange)
        assertEquals("Stock", result[0].assetType)
        assertEquals("2023-08-30", result[0].ipoDate)
        assertEquals("null", result[0].delistingDate)
        assertEquals("Active", result[0].status)
        //마지막 데이터 검사
        assertEquals("ZZZ", result.last().symbol)
        assertEquals("TEST TICKER FOR UTP", result.last().name)
        assertEquals("NYSE ARCA", result.last().exchange)
        assertEquals("Stock", result.last().assetType)
        assertEquals("2014-10-31", result.last().ipoDate)
        assertEquals("null", result.last().delistingDate)
        assertEquals("Active", result.last().status)
    }

    @Test
    fun `name이 없는 경우 빈 값이 들어가야한다 `() = runTest {
        //given
        val stockDataSourceImpl = StockDataSourceImpl()
        //when
        val result = stockDataSourceImpl.getStockListings()
        //then
        assertEquals("", result[result.lastIndex - 1].name)
    }
}