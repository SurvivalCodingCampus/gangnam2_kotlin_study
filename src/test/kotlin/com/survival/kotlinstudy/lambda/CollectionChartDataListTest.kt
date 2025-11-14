package com.survival.kotlinstudy.lambda

import kotlinx.serialization.json.Json
import org.junit.Test
import java.io.File
import kotlin.test.assertIs

class CollectionChartDataListTest {

    @Test
    fun `파일에서 json 데이터 읽기`() {
        // given (준비)
        val source = File("chart_data.json")
        val text = source.readText()

        // when (실행)
        val dataList = Json.decodeFromString<CollectionChartData>(text)

        // then (검증)
        assertIs<CollectionChartData>(dataList)
        assertIs<List<CollectionChartDataList>>(dataList.collectionChartDataList)

        for (collectionSalePrice in dataList.collectionChartDataList){
            assertIs<List<CollectionSalePrice>?>(collectionSalePrice.collectionSalePrice)
        }

    }
}