package com.survivalcoding.kotlinstudy.`02_instance_class`

import kotlin.random.Random

/*
Cleric클래스에 관하여, 2가지 수정을 하시오

1. 현시점의 Cleric 클래스의 정의에는, 각 인스턴스별로 최대 HP와 최대 MP 필드에 대한 정보를 가지고 있다.
   하지만, 모든 성직자의 최대 HP 는 50, 최대 MP 는 10으로 정해져 있어, 각 인스턴스가 각각의 정보를 가지는 것은 메모리 낭비이다.
   그래서, 최대 HP, 최대 MP의 필드가 공유 되도록 필드 선언에 적절한 키워드를 추가하시오

2. 아래의 방침에 따라, 생성자를 추가 하시오
A) 이 클래스는 Cleric(“아서스", hp = 40, mp = 5) 와 같이, 이름, HP, MP 를 지정하여 인스턴스화 할 수 있다
B) 이 클래스는 Cleric(“아서스", hp = 35) 와 같이, 이름과 HP만으로 지정하여 인스턴스화 할 수 있다. 이 때, MP는 최대 MP와 같은 값이 초기화 된다
C) 이 클래스는 Cleric(“아서스") 와 같이 이름만을 지정하여 인스턴스화 할 수 있다. 이 때, HP 와 MP 는 최대 HP와 최대 MP로 초기화 된다
D) 이 클래스는 Cleric() 과 같이 이름을 지정하지 않는 경우에는 인스턴스화 할 수 없다고 한다. (이름이 없는 성직자는 존재 할 수 없음)
*/

class Cleric(
    var name: String,
    var hp: Int = MAX_HP,
    val maxHp: Int = MAX_HP,
    var mp: Int = MAX_MP,
    val maxMp: Int = MAX_MP,
) {
    companion object {
        const val MAX_HP = 50   // 최대체력
        const val MAX_MP = 10   // 최대마나
        const val AID_COST = 5  // selfAid() 사용마나
    }

    fun selfAid() {
        if (mp < AID_COST) {
            return
        }

        mp -= AID_COST
        hp = maxHp
    }

    fun pray(time: Int): Int {
        val mpRecovery = time + Random.nextInt(0, 3)
        var actualRecovery: Int

        if ((mp + mpRecovery) < maxMp) {
            actualRecovery = mpRecovery
            mp += mpRecovery
        } else {
            actualRecovery = maxMp - mp
            mp = maxMp
        }

        return actualRecovery
    }
}