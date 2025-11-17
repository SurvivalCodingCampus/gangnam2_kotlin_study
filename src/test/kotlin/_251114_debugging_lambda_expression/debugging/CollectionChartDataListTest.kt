package _251114_debugging_lambda_expression.debugging

import kotlinx.serialization.json.Json
import org.junit.Before
import org.junit.Test
import java.io.File
import java.io.FileNotFoundException
import kotlin.test.assertEquals


class CollectionChartDataListTest {

    companion object{
        val firstCollectionName = "collection1"
        val firstCollectionSalePrice = listOf(CollectionSale(price = 58.25, cvtDatetime ="2023-03-26T08:00:00" ),CollectionSale(price = 58.50, cvtDatetime ="2023-03-26T08:00:10" ))
    }

    @Test
    fun `역직렬화 테스트`(){
        //given
        val file = File(JSON_FILE_PATH).readText()
        //when
        val extractObject = jsonToObject(file)
        //then
        assertEquals(firstCollectionName,extractObject.collectionChartDataList[0].collectionName)
        assertEquals(firstCollectionSalePrice.size,extractObject.collectionChartDataList[0].collectionSalePrice.size)
        assertEquals(firstCollectionSalePrice[0].price,extractObject.collectionChartDataList[0].collectionSalePrice[0].price)
        assertEquals(firstCollectionSalePrice[1].price,extractObject.collectionChartDataList[0].collectionSalePrice[1].price)
        assertEquals(firstCollectionSalePrice[0].cvtDatetime,extractObject.collectionChartDataList[0].collectionSalePrice[0].cvtDatetime)
        assertEquals(firstCollectionSalePrice[1].cvtDatetime,extractObject.collectionChartDataList[0].collectionSalePrice[1].cvtDatetime)


    }
}