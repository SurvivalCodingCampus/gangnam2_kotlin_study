package com.survivalcoding.kotlinstudy.`12_debugging_lamda`

import java.io.File
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull

class CollectionChartDataTest {

    companion object {
        private const val TEST_FILE_PATH =
            "src/test/kotlin/com/survivalcoding/kotlinstudy/12_debugging_lamda/test_chart_data.json"

        // 첫 번째 데이터
        private const val FIRST_NAME = "collection1"
        private const val FIRST_PRICE = 10.5
        private const val FIRST_DATETIME = "2023-01-01T00:00:00"

        // 두 번째 데이터
        private const val SECOND_NAME = "collection2"

        private const val EXPECTED_LIST_SIZE = 2
        private const val FIRST_PRICE_LIST_SIZE = 1
    }

    @Test
    fun `Json 역직렬화 - CollectionChartDataList 생성`() {
        // given
        val file = File(TEST_FILE_PATH)

        // when
        val result = deserialize(file)

        // then
        assertNotNull(result)
        assertEquals(EXPECTED_LIST_SIZE, result.collectionChartDataList.size)
    }

    @Test
    fun `첫번째 아이템 올바르게 파싱`() {
        // given
        val file = File(TEST_FILE_PATH)

        // when
        val result = deserialize(file)
        val first = result.collectionChartDataList[0]

        // then
        assertEquals(FIRST_NAME, first.collectionName)
        assertNotNull(first.collectionSalePrice)
        assertEquals(FIRST_PRICE_LIST_SIZE, first.collectionSalePrice.size)
        assertEquals(FIRST_PRICE, first.collectionSalePrice[0].price)
        assertEquals(FIRST_DATETIME, first.collectionSalePrice[0].cvtDatetime)
    }

    @Test
    fun `두번째 아이템 올바르게 파싱 - salePrice는 null 이어야 정상`() {
        // given
        val file = File(TEST_FILE_PATH)

        // when
        val result = deserialize(file)
        val second = result.collectionChartDataList[1]

        // then
        assertEquals(SECOND_NAME, second.collectionName)
        assertNull(second.collectionSalePrice)
    }
}
