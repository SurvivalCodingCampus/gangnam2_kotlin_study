package com.neouul.sesac.`03-class`

import kotlin.random.Random

//TODO: hp, mp 입력의 범위를 지정해야 한다
class Cleric(
    var name: String,
    var hp: Int = MAX_HP,
    var mp: Int = MAX_MP,
) {
    fun selfAid() {
        val usingMp = 5

        // MP가 5미만일 때
        if (mp < usingMp) {
            println("현재 MP가 5보다 적어 스킬을 사용할 수 없습니다.")
            return
        }

        // HP가 이미 최대일 때
        if (hp == MAX_HP) {
            println("현재 HP가 최대치이므로 스킬을 사용할 수 없습니다.")
            return
        }

        mp -= usingMp
        hp = MAX_HP
    }

    fun pray(sec: Int): Int {
        // 파라미터 sec에 음수가 전달된 경우
        if (sec < 0) {
            println("시간은 0초 미만일 수 없습니다.")
            return 0
        }
        val recentMp = mp
        val randomNumber = Random.nextInt(3)    // 0~2 난수 생성
        mp += sec + randomNumber
        mp = if (mp > MAX_MP) MAX_MP else mp

        return mp - recentMp
    }

    // 매직 넘버를 줄이기 위한 상수 선언
    companion object {
        const val MAX_HP = 50
        const val MAX_MP = 10
    }
}