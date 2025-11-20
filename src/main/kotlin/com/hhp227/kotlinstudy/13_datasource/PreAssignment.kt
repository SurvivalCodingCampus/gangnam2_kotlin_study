package com.hhp227.kotlinstudy.`13_datasource`

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

/*
과제1. 간단한 JSON 을 데이터 클래스로 변환
https://jsonplaceholder.typicode.com/todos/1

위 링크에서 제공되는 Json 을 todo.json 으로 저장
todo.json 파일을 읽어서 Todo 객체로 변환하는 기능 작성
Todo, TodoDataSourceImpl 작성
interface TodoDataSource {
    suspend fun getTodo(): Todo
}

과제2. Json List 를 List<Todo> 로 변환
https://jsonplaceholder.typicode.com/todos

List<Todo> 추가
interface TodoDataSource {
    suspend fun getTodos(): List<Todo>
}

과제3. 복잡한 Json List 를 List 로 변환
https://jsonplaceholder.typicode.com/users

interface UserDataSource {
    suspend fun getUsers(): List<User>
}

과제4. 주식 정보 데이터를 제공하는 데이터소스
https://www.alphavantage.co/query?function=LISTING_STATUS&apikey=demo

interface StockDataSource {
    suspend fun getStockListings(): List<StockListing>
}

- 단, 문제가 있는 항목(name 이 비어있는 항목)은 제외할 것

CSV는 JSON 대비 Key 가 없고 내용만 있기 때문에 Json 대비 대략 절반의 메모리만 사용

 */

class TodoDataSourceImpl : TodoDataSource {
    override suspend fun getTodo(): Todo {
        val jsonString = FileLoadUtil.loadFileToString("todo.json")
        return Json.decodeFromString(jsonString)
    }

    override suspend fun getTodos(): List<Todo> {
        val jsonString = FileLoadUtil.loadFileToString("todos.json")
        return Json.decodeFromString(jsonString)
    }
}

interface TodoDataSource {
    suspend fun getTodo(): Todo

    suspend fun getTodos(): List<Todo>
}

@Serializable
data class Todo(val userId: Int, val id: Int, val title: String, val completed: Boolean)

class UserDataSourceImpl : UserDataSource {
    override suspend fun getUsers(): List<User> {
        val jsonString = FileLoadUtil.loadFileToString("users.json")
        return Json.decodeFromString(jsonString)
    }
}

interface UserDataSource {
    suspend fun getUsers(): List<User>
}

@Serializable
data class User(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val address: Address,
    val phone: String,
    val website: String,
    val company: Company
)

@Serializable
data class Address(val street: String, val suite: String, val city: String, val zipcode: String, val geo: Geo)

@Serializable
data class Geo(val lat: String, val lng: String)

@Serializable
data class Company(val name: String, val catchPhrase: String, val bs: String)

interface StockDataSource {
    suspend fun getStockListings(): List<StockListing>
}

class StockDataSourceImpl : StockDataSource {
    override suspend fun getStockListings(): List<StockListing> {
        val data = FileLoadUtil.loadFileToStringList("listing_status.csv")
        val fieldNames = data.first().split(",")
        return data
            .drop(1)
            .map { row -> fieldNames.zip(row.split(",")).toMap().toObject() }
            .filter { it.name.isNotBlank() }
    }
}

fun Map<String, String>.toObject(): StockListing {
    return StockListing(
        getOrDefault("symbol", ""),
        getOrDefault("name", ""),
        getOrDefault("exchange", ""),
        getOrDefault("assetType", ""),
        getOrDefault("ipoDate", ""),
        getOrDefault("delistingDate", "null"),
        getOrDefault("status", "")
    )
}

data class StockListing(
    val symbol: String,
    val name: String,
    val exchange: String,
    val assetType: String,
    val ipoDate: String,
    val delistingDate: String,
    val status: String
)