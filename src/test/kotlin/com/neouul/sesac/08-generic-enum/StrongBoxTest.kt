package com.neouul.sesac.`08-generic-enum`

import org.junit.Assert.*
import org.junit.Test

class StrongBoxTest {
    @Test
    fun `인스턴스 생성 성공 - KeyType 타입의 인자를 전달할 때`() {
        val key = KeyType.PADLOCK
        val strongBox = StrongBox<String>(key)

        assertTrue(strongBox.getKey() is KeyType)
        assertEquals(0, strongBox.getCounter())
        assertNull(strongBox.get())
    }

    @Test
    fun `put 메서드로 필드 값 변경 성공 - 제네릭 타입에 맞는 인자 전달할 때`() {
        val key = KeyType.PADLOCK
        val data = "Hello World!"
        val strongBox = StrongBox<String>(key)

        assertNull(strongBox.getData())
        strongBox.put(data)

        assertEquals(data, strongBox.getData())
    }

    @Test
    fun `get 메서드 null 반환 성공 - 해당 keyType의 시도횟수보다 호출 횟수가 적거나 같을 때`() {
        val key = KeyType.PADLOCK
        val data = "Hello World!"
        val strongBox = StrongBox<String>(key)

        strongBox.put(data)

        // 정해진 횟수까지는 null을 반환, 그 이후부터 data값 반환
        repeat(key.keyNumber){
           assertTrue(strongBox.getCounter() <= strongBox.getKey().keyNumber)
           assertNull(strongBox.get())
        }
    }

    @Test
    fun `get 메서드 data값 반환 성공 - 해당 keyType의 시도횟수를 만족한 이후로`() {
        val key = KeyType.PADLOCK
        val data = "Hello World!"
        val strongBox = StrongBox<String>(key)

        strongBox.put(data)
        // 정해진 횟수까지는 호출해도 null 반환
        repeat(key.keyNumber){
            strongBox.get()
        }

        // 열쇠의 사용횟수에 도달한 이후부터
        assertEquals(key.keyNumber, strongBox.getCounter())
        // get으로 접근하면 data 필드의 값을 리턴
        assertEquals(strongBox.getData(), strongBox.get())

        assertEquals(strongBox.getData(), strongBox.get())
        assertEquals(strongBox.getData(), strongBox.get())
        assertEquals(strongBox.getData(), strongBox.get())
    }
}