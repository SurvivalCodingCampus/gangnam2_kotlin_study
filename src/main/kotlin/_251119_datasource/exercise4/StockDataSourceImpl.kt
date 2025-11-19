package _251119_datasource.exercise4

import java.io.File

class StockDataSourceImpl : StockDataSource {
    override suspend fun getStockListings(): List<StockListing> {
        val file = File(FILE_PATH)
        return csvToObject(file)
    }
}

fun csvToObject(csvFile: File): List<StockListing> {
    val resultList = mutableListOf<StockListing>()
    csvFile.forEachLine {
        val tmp = it.split(",")
        resultList.add(StockListing(tmp[0], tmp[1], tmp[2], tmp[3], tmp[4], tmp[5], tmp[6]))
    }
    resultList.removeAt(0) //첫줄은 제목이므로 제거
    return resultList
}
