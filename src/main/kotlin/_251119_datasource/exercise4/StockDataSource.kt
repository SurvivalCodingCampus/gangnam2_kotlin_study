package _251119_datasource.exercise4

const val FILE_PATH =
    "src\\main\\kotlin\\_251119_datasource\\exercise4\\listing_status.csv"

interface StockDataSource {
    suspend fun getStockListings(): List<StockListing>
}