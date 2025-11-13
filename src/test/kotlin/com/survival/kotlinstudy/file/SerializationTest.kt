package com.survival.kotlinstudy.file

import kotlinx.serialization.json.Json
import org.junit.Test
import java.io.File
import kotlin.test.assertEquals

class SerializationTest {

    @Test
    fun `직렬화 테스트`() {
        // given (준비)
        val file = File("company.txt")
        val employee = Employee(name = "홍길동", age = 41)
        val leader = Department(name = "총무부", leader = employee)

        // when (실행)
        val leaderString = Json.encodeToString(leader)
        file.writeText(leaderString)


        // then (검증)
        assertEquals(leaderString,file.readText())
    }
}