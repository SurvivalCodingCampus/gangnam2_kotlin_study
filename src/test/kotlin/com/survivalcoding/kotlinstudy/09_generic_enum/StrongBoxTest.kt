package com.survivalcoding.kotlinstudy.`09_generic_enum`

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import kotlin.test.assertNull

class StrongBoxTest {
    companion object {
        private const val secretString = "비밀이야"
        private const val secretString2 = "아니야"
        private const val secretInt = 1
        private const val secretDouble = 1.00
        private val secretList = listOf<String>("a", "b", "c")
    }

    /**
     * 헬퍼함수
     *
     * 한도까지 반복하고 값을 리턴
     */
    private fun <T> getAfterLimit(box: StrongBox<T>): T? {
        repeat(box.keyType.limit - 1) { box.get() } // 직전까지 검사
        return box.get() // 리턴이 필요
    }

    @Test
    fun `금고에 저장 성공`() {
        val box1 = StrongBox<String>(KeyType.PADLOCK)
        val box2 = StrongBox<String>(KeyType.BUTTON)
        val box3 = StrongBox<String>(KeyType.DIAL)
        val box4 = StrongBox<String>(KeyType.FINGER)

        box1.put(secretString)
        box2.put(secretString)
        box3.put(secretString)
        box4.put(secretString)

        assertEquals(secretString, getAfterLimit(box1))
        assertEquals(secretString, getAfterLimit(box2))
        assertEquals(secretString, getAfterLimit(box3))
        assertEquals(secretString, getAfterLimit(box4))
    }

    @Test
    fun `금고에 저장 성공 - 다양한 타입`() {
        // given
        val boxInt = StrongBox<Int>(KeyType.PADLOCK)
        val boxDouble = StrongBox<Double>(KeyType.PADLOCK)
        val boxList = StrongBox<List<String>>(KeyType.PADLOCK)

        // when
        boxInt.put(secretInt)
        boxDouble.put(secretDouble)
        boxList.put(secretList)

        // then
        assertEquals(secretInt, getAfterLimit(boxInt))
        assertEquals(secretDouble, getAfterLimit(boxDouble))
        assertEquals(secretList, getAfterLimit(boxList))
    }


    @Test
    fun `금고 저장 성공 - 1개만 저장 (덮어쓰기)`() {
        // given
        val box = StrongBox<String>(KeyType.PADLOCK)

        // when
        box.put(secretString)
        box.put(secretString2) // 덮어쓰기 발생

        // then
        assertEquals(secretString2, getAfterLimit(box))
    }

    @Test
    fun `금고 열기 실패 - 한도 도달 전`() {
        // given
        val box = StrongBox<String>(KeyType.PADLOCK)

        // when
        box.put(secretString)
        repeat(KeyType.PADLOCK.limit - 2) { box.get() } // 아직 한도 도달 전
        val result = box.get() // limit -1 번째에서 unlock 시도

        // then
        assertNotEquals(secretString, result) // 아직 열리면 안 됨
        assertNull(result) // null이어야 함
    }

    @Test
    fun `금고 열기 성공 - 한도 도달`() {
        // given
        val box = StrongBox<String>(KeyType.PADLOCK)

        // when
        box.put(secretString)
        val result = getAfterLimit(box)

        // then
        assertEquals(secretString, result)
    }

    @Test
    fun `금고 열기 성공 - 금고가 비었을 때 null`() {
        // given
        val box = StrongBox<String>(KeyType.PADLOCK)

        // then
        assertEquals(null, getAfterLimit(box)) // 금고는 열리지만 내용물이 없으므로 null
    }

    @Test
    fun `금고 열기 실패 - 한도 초과시 초기화`() {
        // given
        val box = StrongBox<String>(KeyType.PADLOCK)
        box.put(secretString)

        // when
        getAfterLimit(box) // unlock
        val result = box.get() // 다시 시도

        // then
        assertEquals(1, box.count) // 초기화 되는지 확인
        assertNotEquals(secretString, result) // 열리면 안됨
        assertNull(result) // null이어야 함
    }
}