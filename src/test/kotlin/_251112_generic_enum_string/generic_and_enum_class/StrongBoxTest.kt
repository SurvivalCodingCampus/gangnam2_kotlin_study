package _251112_generic_enum_string.generic_and_enum_class

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class StrongBoxTest {
    @Test
    fun `열쇠 시도횟수가 도달하기 전에 금고 잠금이 해제되지 않는지 테스트`() {
        //given
        val strongBox1 = StrongBox<String>(KeyType.PADLOCK)
        strongBox1.put("금고에 저장")
        val strongBox2 = StrongBox<String>(KeyType.BUTTON)
        strongBox2.put("금고에 저장")
        val strongBox3 = StrongBox<String>(KeyType.DIAL)
        strongBox3.put("금고에 저장")
        val strongBox4 = StrongBox<String>(KeyType.FINGER)
        strongBox4.put("금고에 저장")
        //when
        val returnStrongBox1 = strongBox1.get()
        val returnStrongBox2 = strongBox2.get()
        val returnStrongBox3 = strongBox3.get()
        val returnStrongBox4 = strongBox4.get()
        //then
        assertEquals(null, returnStrongBox1)
        assertEquals(null, returnStrongBox2)
        assertEquals(null, returnStrongBox3)
        assertEquals(null, returnStrongBox4)
    }

    @Test
    fun `열쇠 시도횟수를 넘은 경우 금고 잠금이 정상적으로 해제되는지 테스트`() {
        //given
        val strongBox1 = StrongBox<String>(KeyType.PADLOCK)
        strongBox1.put("금고에 저장")
        val strongBox2 = StrongBox<String>(KeyType.BUTTON)
        strongBox2.put("금고에 저장")
        val strongBox3 = StrongBox<String>(KeyType.DIAL)
        strongBox3.put("금고에 저장")
        val strongBox4 = StrongBox<String>(KeyType.FINGER)
        strongBox4.put("금고에 저장")
        //when
        repeat(strongBox1.kt.cnt) {
            strongBox1.get()
        }
        repeat(strongBox2.kt.cnt) {
            strongBox2.get()
        }
        repeat(strongBox3.kt.cnt) {
            strongBox3.get()
        }
        repeat(strongBox4.kt.cnt) {
            strongBox4.get()
        }
        val returnStrongBox1 = strongBox1.get()
        val returnStrongBox2 = strongBox2.get()
        val returnStrongBox3 = strongBox3.get()
        val returnStrongBox4 = strongBox4.get()
        //then
        assertNotEquals(null, returnStrongBox1)
        assertNotEquals(null, returnStrongBox2)
        assertNotEquals(null, returnStrongBox3)
        assertNotEquals(null, returnStrongBox4)
    }
}