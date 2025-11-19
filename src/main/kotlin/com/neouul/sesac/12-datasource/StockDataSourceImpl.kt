package com.neouul.sesac.`12-datasource`

import java.io.File
import java.time.LocalDate

class StockDataSourceImpl : StockDataSource {
    override suspend fun getStockListings(): List<StockListing> {
        val resultList = mutableListOf<StockListing>()
        val file = File("docs/data_source/listing_status.csv")
        val lines = file.readLines()

        for (line in lines) {
            if (line == lines[0]) continue

            val fields = line.split(',')

            // name이 공백 ("") 이거나 null일 때는 제외함
            if (fields[1].isNotBlank()) {
                resultList.add(
                    StockListing(
                        fields[0],
                        fields[1],
                        fields[2],
                        fields[3],
                        toLocalDate(fields[4]),
                        toNullOrDate(fields[5]),
                        fields[6],
                    )
                )
            }
        }

        return resultList
    }

    // private 함수들 테스트 위해서 public으로
    fun toNullOrDate(string: String): LocalDate? {
        if (string.lowercase() == "null") {
            return null
        }
        return toLocalDate(string)
    }

    fun toLocalDate(string: String): LocalDate {
        return LocalDate.parse(string)
    }
}
