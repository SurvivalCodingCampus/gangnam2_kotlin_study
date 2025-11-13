package com.survivaalcoding.kotlinstudy.`09_generic_enum_string`.example

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class StrongBoxTest {
    @Test
    fun `PADLOCK 열쇠를 가진 금고를 생성할 수 있다`() {
        // given
        val padlock = KeyType.PADLOCK

        // when
        val integerStrongBox = StrongBox<Int>(padlock)

        // then
        assertThat(integerStrongBox).isNotNull
    }

    @Test
    fun `BUTTON 열쇠를 가진 금고를 생성할 수 있다`() {
        // given
        val button = KeyType.BUTTON

        // when
        val integerStrongBox = StrongBox<Int>(button)

        // then
        assertThat(integerStrongBox).isNotNull
    }

    @Test
    fun `PADLOCK 열쇠로 한 번 금고를 열면 null을 반환한다`() {
        // given
        val padlock = KeyType.PADLOCK
        val integerStrongBox = StrongBox<Int>(padlock)

        // when
        val actual = integerStrongBox.get()

        // then
        assertThat(actual).isNull()
    }

    @Test
    fun `PADLOCK 열쇠 횟수 -1번 열어도 null을 반환한다`() {
        // given
        val padlock = KeyType.PADLOCK
        val integerStrongBox = StrongBox<Int>(padlock)
        integerStrongBox.put(1_000_000_000)

        // when
        val actual = (0..<padlock.count).map {
            integerStrongBox.get()
        }.last()

        // then
        assertThat(actual).isNull()
    }

    @Test
    fun `PADLOCK 열쇠 횟수만큼 열면 금고의 데이터를 반환한다`() {
        // given
        val oneBillion = 1_000_000_000
        val padlock = KeyType.PADLOCK

        val integerStrongBox = StrongBox<Int>(padlock)
        integerStrongBox.put(oneBillion)

        // when
        val actual = (0..padlock.count).map {
            integerStrongBox.get()
        }.last()

        // then
        assertThat(actual).isEqualTo(oneBillion)
    }

    @Test
    fun `PADLOCK 열쇠 횟수 +1번 열여서 한 번 열린 금고는 계속 데이터를 반환한다`() {
        // given
        val oneBillion = 1_000_000_000
        val padlock = KeyType.PADLOCK

        val integerStrongBox = StrongBox<Int>(padlock)
        integerStrongBox.put(oneBillion)

        // when
        val actual = (0..padlock.count + 1).map {
            integerStrongBox.get()
        }.last()

        // then
        assertThat(actual).isEqualTo(oneBillion)
    }

    @Test
    fun `FINGER 열쇠 횟수 -1번 열어도 null을 반환한다`() {
        // given
        val finger = KeyType.FINGER
        val integerStrongBox = StrongBox<Int>(finger)
        integerStrongBox.put(1_000_000_000)

        // when
        val actual = (0..<finger.count).map {
            integerStrongBox.get()
        }.last()

        // then
        assertThat(actual).isNull()
    }

    @Test
    fun `FINGER 열쇠 횟수만큼 열면 금고의 데이터를 반환한다`() {
        // given
        val oneBillion = 1_000_000_000
        val finger = KeyType.FINGER

        val integerStrongBox = StrongBox<Int>(finger)
        integerStrongBox.put(oneBillion)

        // when
        val actual = (0..finger.count).map {
            integerStrongBox.get()
        }.last()

        // then
        assertThat(actual).isEqualTo(oneBillion)
    }

    @Test
    fun `FINGER 열쇠 횟수 +1번 열여서 한 번 열린 금고는 계속 데이터를 반환한다`() {
        // given
        val oneBillion = 1_000_000_000
        val finger = KeyType.FINGER

        val integerStrongBox = StrongBox<Int>(finger)
        integerStrongBox.put(oneBillion)

        // when
        val actual = (0..finger.count + 1).map {
            integerStrongBox.get()
        }.last()

        // then
        assertThat(actual).isEqualTo(oneBillion)
    }
}