package com.sesac.practice.day11.debug

import kotlinx.serialization.json.Json
import org.junit.Test
import java.io.File
import kotlin.test.assertEquals
import kotlin.test.assertNull

class ChartDataTest {
    @Test
    fun `json 차트 데이터를 역직렬화한다`() {
        // given
        val file = File("data/chart_data.json")
        val json = file.readText()

        // when
        val chartData = Json.decodeFromString<ChartData>(json)

        // then
        assertEquals(75, chartData.collectionChartDataList?.size)

        val diffData = chartData.collectionChartDataList?.get(67)
        assertEquals("collection68", diffData?.collectionName)
        assertNull(diffData?.collectionSalePrice)
    }
}
