package com.hhp227.kotlinstudy.`11_lambda`

import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertIs
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class ChartDataLoaderTest {
    val chartDataLoader = ChartDataLoader()

    @Test
    fun `파일이 존재하는지 확인`() {
        val resource = this::class.java.classLoader.getResource("chart_data.json")

        assertNotNull(resource, "chart_data.json 파일이 존재해야 합니다.")
    }

    @Test
    fun `파일이 객체로 변환되는지 확인`() {
        val jsonString = chartDataLoader.loadJson()
        val chartData = Json.decodeFromString<ChartData>(jsonString)

        assertIs<String>(jsonString)
        assertNotNull(chartData, "JSON 문자열이 ChartData 객체로 변환되어야 합니다.")
    }

    @Test
    fun `파일 내용이 일치하는지 확인`() {
        val jsonString = chartDataLoader.loadJson()

        assertTrue(jsonString.contains("collectionChartDataList"), "JSON 내용이 예상과 일치해야 합니다.")
        assertTrue(jsonString.contains("collectionName"), "JSON 내용이 예상과 일치해야 합니다.")
        assertTrue(jsonString.contains("collectionSalePrice"), "JSON 내용이 예상과 일치해야 합니다.")
        assertTrue(jsonString.contains("price"), "JSON 내용이 예상과 일치해야 합니다.")
        assertTrue(jsonString.contains("cvtDatetime"), "JSON 내용이 예상과 일치해야 합니다.")

        val chartData = Json.decodeFromString<ChartData>(jsonString)

        assertTrue(chartData.collectionChartDataList.isNotEmpty(), "collectionChartDataList가 비어있으면 안됩니다.")
    }

    @Test
    fun `파일의 저장한 내용이 다시 객체로 변환되고, 내용이 일치하는지 테스트`() {
        val jsonString = chartDataLoader.loadJson()
        val chartData = Json.decodeFromString<ChartData>(jsonString)
        val collectionChartDataList = listOf(
            CollectionChartData("collection1", listOf(SalePrice(58.25, "2023-03-26T08:00:00"), SalePrice(58.50, "2023-03-26T08:00:10"))),
            CollectionChartData("collection2", listOf(SalePrice(58.75, "2023-03-26T08:00:20"), SalePrice(59.00, "2023-03-26T08:00:30"))),
            CollectionChartData("collection3", listOf(SalePrice(59.25, "2023-03-26T08:00:40"), SalePrice(59.50, "2023-03-26T08:00:50"))),
            CollectionChartData("collection4", listOf(SalePrice(59.75, "2023-03-26T08:01:00"), SalePrice(60.00, "2023-03-26T08:01:10"))),
            CollectionChartData("collection5", listOf(SalePrice(60.25, "2023-03-26T08:01:20"), SalePrice(60.50, "2023-03-26T08:01:30"))),
            CollectionChartData("collection6", listOf(SalePrice(60.75, "2023-03-26T08:01:40"), SalePrice(61.00, "2023-03-26T08:01:50"))),
            CollectionChartData("collection7", listOf(SalePrice(61.25, "2023-03-26T08:02:00"), SalePrice(61.50, "2023-03-26T08:02:10"))),
            CollectionChartData("collection8", listOf(SalePrice(61.75, "2023-03-26T08:02:20"), SalePrice(62.00, "2023-03-26T08:02:30"))),
            CollectionChartData("collection9", listOf(SalePrice(62.25, "2023-03-26T08:02:40"), SalePrice(62.50, "2023-03-26T08:02:50"))),
            CollectionChartData("collection10", listOf(SalePrice(62.75, "2023-03-26T08:03:00"), SalePrice(63.00, "2023-03-26T08:03:10"))),
            CollectionChartData("collection11", listOf(SalePrice(63.25, "2023-03-26T08:03:20"), SalePrice(63.50, "2023-03-26T08:03:30"))),
            CollectionChartData("collection12", listOf(SalePrice(63.75, "2023-03-26T08:03:40"), SalePrice(64.00, "2023-03-26T08:03:50"))),
            CollectionChartData("collection13", listOf(SalePrice(64.25, "2023-03-26T08:04:00"), SalePrice(64.50, "2023-03-26T08:04:10"))),
            CollectionChartData("collection14", listOf(SalePrice(64.75, "2023-03-26T08:04:20"), SalePrice(65.00, "2023-03-26T08:04:30"))),
            CollectionChartData("collection15", listOf(SalePrice(65.25, "2023-03-26T08:04:40"), SalePrice(65.50, "2023-03-26T08:04:50"))),
            CollectionChartData("collection16", listOf(SalePrice(65.75, "2023-03-26T08:05:00"), SalePrice(66.00, "2023-03-26T08:05:10"))),
            CollectionChartData("collection17", listOf(SalePrice(66.25, "2023-03-26T08:05:20"), SalePrice(66.50, "2023-03-26T08:05:30"))),
            CollectionChartData("collection18", listOf(SalePrice(66.75, "2023-03-26T08:05:40"), SalePrice(67.00, "2023-03-26T08:05:50"))),
            CollectionChartData("collection19", listOf(SalePrice(67.25, "2023-03-26T08:06:00"), SalePrice(67.50, "2023-03-26T08:06:10"))),
            CollectionChartData("collection20", listOf(SalePrice(67.75, "2023-03-26T08:06:20"), SalePrice(68.00, "2023-03-26T08:06:30"))),
            CollectionChartData("collection21", listOf(SalePrice(68.25, "2023-03-26T08:06:40"), SalePrice(68.50, "2023-03-26T08:06:50"))),
            CollectionChartData("collection22", listOf(SalePrice(68.75, "2023-03-26T08:07:00"), SalePrice(69.00, "2023-03-26T08:07:10"))),
            CollectionChartData("collection23", listOf(SalePrice(69.25, "2023-03-26T08:07:20"), SalePrice(69.50, "2023-03-26T08:07:30"))),
            CollectionChartData("collection24", listOf(SalePrice(69.75, "2023-03-26T08:07:40"), SalePrice(70.00, "2023-03-26T08:07:50"))),
            CollectionChartData("collection25", listOf(SalePrice(70.25, "2023-03-26T08:08:00"), SalePrice(70.50, "2023-03-26T08:08:10"))),
            CollectionChartData("collection26", listOf(SalePrice(70.75, "2023-03-26T08:08:20"), SalePrice(71.00, "2023-03-26T08:08:30"))),
            CollectionChartData("collection27", listOf(SalePrice(71.25, "2023-03-26T08:08:40"), SalePrice(71.50, "2023-03-26T08:08:50"))),
            CollectionChartData("collection28", listOf(SalePrice(71.75, "2023-03-26T08:09:00"), SalePrice(72.00, "2023-03-26T08:09:10"))),
            CollectionChartData("collection29", listOf(SalePrice(72.25, "2023-03-26T08:09:20"), SalePrice(72.50, "2023-03-26T08:09:30"))),
            CollectionChartData("collection30", listOf(SalePrice(72.75, "2023-03-26T08:09:40"), SalePrice(73.00, "2023-03-26T08:09:50"))),
            CollectionChartData("collection31", listOf(SalePrice(73.25, "2023-03-26T08:10:00"), SalePrice(73.50, "2023-03-26T08:10:10"))),
            CollectionChartData("collection32", listOf(SalePrice(73.75, "2023-03-26T08:10:20"), SalePrice(74.00, "2023-03-26T08:10:30"))),
            CollectionChartData("collection33", listOf(SalePrice(74.25, "2023-03-26T08:10:40"), SalePrice(74.50, "2023-03-26T08:10:50"))),
            CollectionChartData("collection34", listOf(SalePrice(74.75, "2023-03-26T08:11:00"), SalePrice(75.00, "2023-03-26T08:11:10"))),
            CollectionChartData("collection35", listOf(SalePrice(75.25, "2023-03-26T08:11:20"), SalePrice(75.50, "2023-03-26T08:11:30"))),
            CollectionChartData("collection36", listOf(SalePrice(75.75, "2023-03-26T08:11:40"), SalePrice(76.00, "2023-03-26T08:11:50"))),
            CollectionChartData("collection37", listOf(SalePrice(76.25, "2023-03-26T08:12:00"), SalePrice(76.50, "2023-03-26T08:12:10"))),
            CollectionChartData("collection38", listOf(SalePrice(76.75, "2023-03-26T08:12:20"), SalePrice(77.00, "2023-03-26T08:12:30"))),
            CollectionChartData("collection39", listOf(SalePrice(77.25, "2023-03-26T08:12:40"), SalePrice(77.50, "2023-03-26T08:12:50"))),
            CollectionChartData("collection40", listOf(SalePrice(77.75, "2023-03-26T08:13:00"), SalePrice(78.00, "2023-03-26T08:13:10"))),
            CollectionChartData("collection41", listOf(SalePrice(78.25, "2023-03-26T08:13:20"), SalePrice(78.50, "2023-03-26T08:13:30"))),
            CollectionChartData("collection42", listOf(SalePrice(78.75, "2023-03-26T08:13:40"), SalePrice(79.00, "2023-03-26T08:13:50"))),
            CollectionChartData("collection43", listOf(SalePrice(79.25, "2023-03-26T08:14:00"), SalePrice(79.50, "2023-03-26T08:14:10"))),
            CollectionChartData("collection44", listOf(SalePrice(79.75, "2023-03-26T08:14:20"), SalePrice(80.00, "2023-03-26T08:14:30"))),
            CollectionChartData("collection45", listOf(SalePrice(80.25, "2023-03-26T08:14:40"), SalePrice(80.50, "2023-03-26T08:14:50"))),
            CollectionChartData("collection46", listOf(SalePrice(80.75, "2023-03-26T08:15:00"), SalePrice(81.00, "2023-03-26T08:15:10"))),
            CollectionChartData("collection47", listOf(SalePrice(81.25, "2023-03-26T08:15:20"), SalePrice(81.50, "2023-03-26T08:15:30"))),
            CollectionChartData("collection48", listOf(SalePrice(81.75, "2023-03-26T08:15:40"), SalePrice(82.00, "2023-03-26T08:15:50"))),
            CollectionChartData("collection49", listOf(SalePrice(82.25, "2023-03-26T08:16:00"), SalePrice(82.50, "2023-03-26T08:16:10"))),
            CollectionChartData("collection50", listOf(SalePrice(82.75, "2023-03-26T08:16:20"), SalePrice(83.00, "2023-03-26T08:16:30"))),
            CollectionChartData("collection51", listOf(SalePrice(83.25, "2023-03-26T08:16:40"), SalePrice(83.50, "2023-03-26T08:16:50"))),
            CollectionChartData("collection52", listOf(SalePrice(83.75, "2023-03-26T08:17:00"), SalePrice(84.00, "2023-03-26T08:17:10"))),
            CollectionChartData("collection53", listOf(SalePrice(84.25, "2023-03-26T08:17:20"), SalePrice(84.50, "2023-03-26T08:17:30"))),
            CollectionChartData("collection54", listOf(SalePrice(84.75, "2023-03-26T08:17:40"), SalePrice(85.00, "2023-03-26T08:17:50"))),
            CollectionChartData("collection55", listOf(SalePrice(85.25, "2023-03-26T08:18:00"), SalePrice(85.50, "2023-03-26T08:18:10"))),
            CollectionChartData("collection56", listOf(SalePrice(85.75, "2023-03-26T08:18:20"), SalePrice(86.00, "2023-03-26T08:18:30"))),
            CollectionChartData("collection57", listOf(SalePrice(86.25, "2023-03-26T08:18:40"), SalePrice(86.50, "2023-03-26T08:18:50"))),
            CollectionChartData("collection58", listOf(SalePrice(86.75, "2023-03-26T08:19:00"), SalePrice(87.00, "2023-03-26T08:19:10"))),
            CollectionChartData("collection59", listOf(SalePrice(87.25, "2023-03-26T08:19:20"), SalePrice(87.50, "2023-03-26T08:19:30"))),
            CollectionChartData("collection60", listOf(SalePrice(87.75, "2023-03-26T08:19:40"), SalePrice(88.00, "2023-03-26T08:19:50"))),
            CollectionChartData("collection61", listOf(SalePrice(88.25, "2023-03-26T08:20:00"), SalePrice(88.50, "2023-03-26T08:20:10"))),
            CollectionChartData("collection62", listOf(SalePrice(88.75, "2023-03-26T08:20:20"), SalePrice(89.00, "2023-03-26T08:20:30"))),
            CollectionChartData("collection63", listOf(SalePrice(89.25, "2023-03-26T08:20:40"), SalePrice(89.50, "2023-03-26T08:20:50"))),
            CollectionChartData("collection64", listOf(SalePrice(89.75, "2023-03-26T08:21:00"), SalePrice(90.00, "2023-03-26T08:21:10"))),
            CollectionChartData("collection65", listOf(SalePrice(90.25, "2023-03-26T08:21:20"), SalePrice(90.50, "2023-03-26T08:21:30"))),
            CollectionChartData("collection66", listOf(SalePrice(90.75, "2023-03-26T08:21:40"), SalePrice(91.00, "2023-03-26T08:21:50"))),
            CollectionChartData("collection67", listOf(SalePrice(91.25, "2023-03-26T08:22:00"), SalePrice(91.50, "2023-03-26T08:22:10"))),
            CollectionChartData("collection68"), // salePrice 없는 경우
            CollectionChartData("collection69", listOf(SalePrice(92.25, "2023-03-26T08:22:40"), SalePrice(92.50, "2023-03-26T08:22:50"))),
            CollectionChartData("collection70", listOf(SalePrice(92.75, "2023-03-26T08:23:00"), SalePrice(93.00, "2023-03-26T08:23:10"))),
            CollectionChartData("collection71", listOf(SalePrice(93.25, "2023-03-26T08:23:20"), SalePrice(93.50, "2023-03-26T08:23:30"))),
            CollectionChartData("collection72", listOf(SalePrice(93.75, "2023-03-26T08:23:40"), SalePrice(94.00, "2023-03-26T08:23:50"))),
            CollectionChartData("collection73", listOf(SalePrice(94.25, "2023-03-26T08:24:00"), SalePrice(94.50, "2023-03-26T08:24:10"))),
            CollectionChartData("collection74", listOf(SalePrice(94.75, "2023-03-26T08:24:20"), SalePrice(95.00, "2023-03-26T08:24:30"))),
            CollectionChartData("collection75", listOf(SalePrice(95.25, "2023-03-26T08:24:40"), SalePrice(95.50, "2023-03-26T08:24:50")))
        )
        val expectedChartData = ChartData(collectionChartDataList)

        assertTrue(chartData == expectedChartData)
    }
}