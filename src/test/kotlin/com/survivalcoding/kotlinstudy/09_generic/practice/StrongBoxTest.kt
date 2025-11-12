package com.survivalcoding.kotlinstudy.`09_generic`.practice

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class StrongBoxTest {
    @Test
    fun `금고에 물건이 잘 들어가나 확인`() {
        val strongBox1: StrongBox<String> = StrongBox(KeyType.PADLOCK)
        val strongBox2: StrongBox<Int> = StrongBox(KeyType.DIAL)
        val strongBox3: StrongBox<String> = StrongBox(KeyType.BUTTON)

        strongBox1.put("노트북")
        strongBox2.put(7)
        strongBox3.put("컴퓨터")

        assertEquals(strongBox1.instance, "노트북")
        assertEquals(strongBox2.instance, 7)
        assertEquals(strongBox3.instance, "컴퓨터")
    }

    @Test
    fun `시도 횟수에 도달하면 물건이 나오는지 확인`() {
        val strongBox1: StrongBox<String> = StrongBox(KeyType.PADLOCK)
        val strongBox2: StrongBox<Int> = StrongBox(KeyType.DIAL)
        val padlockAttempts: Int = 1023
        val dialAttempts: Int = 29999

        strongBox1.put("노트북")
        strongBox2.put(7)

        repeat(padlockAttempts){
            strongBox1.get()
        }

        repeat(dialAttempts){
            strongBox2.get()
        }

        // 마지막 리턴값 확인
        val padlockLast = strongBox1.get()
        val dialLast = strongBox2.get()

        assertEquals("노트북", padlockLast)
        assertEquals(7, dialLast)
    }

    @Test
    fun `물건을 새로 넣으면 count가 초기화 되는지 확인`() {
        val strongBox1: StrongBox<String> = StrongBox(KeyType.PADLOCK)
        val padlockAttempts: Int = 1024
        val expect = 0

        strongBox1.put("노트북")

        repeat(padlockAttempts){
            strongBox1.get()
        }

        strongBox1.put("컴퓨터")

        assertEquals(strongBox1.count, expect)
    }

    @Test
    fun `물건이 이미 들어가있으면 put()이 안되는지 확인`() {
        val strongBox1: StrongBox<String> = StrongBox(KeyType.PADLOCK)

        strongBox1.put("노트북")
        strongBox1.put("컴퓨터")

        assertEquals(strongBox1.instance, "노트북")
    }
}
