package com.survival.kotlinstudy.day15.datasource

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test


class FileUserDataSourceImplTest {
    @Test
    fun `FileUserDataSource - getUsers 테스트`() = runBlocking {
        val filePath = "data/users.json"
        val datasource = FileUserDataSourceImpl(filePath)
        val list = datasource.getUsers()

        assertEquals(10, list.size)
    }
}