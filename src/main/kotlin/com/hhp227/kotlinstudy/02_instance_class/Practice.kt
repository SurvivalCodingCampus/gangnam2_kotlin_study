package com.hhp227.kotlinstudy.`02_instance_class`

import kotlin.random.Random

/*
연습문제1
현실세계의 성직자 “클레릭" 를 표현하는 클래스 Cleric 를 작성 하시오.
성직자는 용사 처럼 이름과 HP를 가지고 있고, 추가로 마법을 사용하기 위한 MP를 가지고 있다.
Cleric 클래스에 “이름", “HP”, “최대 HP”, “MP”, “최대 MP”를 속성으로 추가 하시오.
또한 HP와 최대 HP는 정수로 초기치 50, MP와 최대 MP는 정수로 초기치 10으로 하고,
최대 HP와 최대 MP는 상수 필드로 선언 하시오.

연습문제2
성직자는 “셀프 에이드" 라는 마법을 사용할 수 있고, MP를 5소비하는 것으로 자신의 HP 를 최대 HP 까지 회복할 수 있다.
연습 1 에 선언한 Cleric 클래스에 “selfAid()” 메소드를 추가 하시오.
또한, 이 메소드는 인수가 없고, 리턴 값도 없다.

연습문제3
성직자는 “기도하기" (pray) 라는 행동을 취할 수 있고, 자신의 MP를 회복한다.
회복량은 기도한 시간(초)에 랜덤하게 0 ~ 2포인트의 보정을 한 양이다 (3초 기도하면 회복량은 3 ~ 5 포인트). 단, 최대 MP 보다 더 회복하는 것은 불가능 하다.
연습 2에서 선언한 Cleric 클래스에 “pray()” 메소드를 추가하시오.
이 메소드는 인수에 “기도할 시간(초)"를 지정할 수 있고, 리턴 값은 “실제로 회복된 MP 양" 을 반환한다.
 */

/*
연습문제1
Cleric클래스에 관하여, 2가지 수정을 하시오
현시점의 Cleric 클래스의 정의에는, 각 인스턴스별로 최대 HP와 최대 MP 필드에 대한 정보를 가지고 있다. 하지만, 모든 성직자의 최대 HP 는 50, 최대 MP 는 10으로 정해져 있어, 각 인스턴스가 각각의 정보를 가지는 것은 메모리 낭비이다.
그래서, 최대 HP, 최대 MP의 필드가 공유 되도록
필드 선언에 적절한 키워드를 추가하시오

연습문제2
아래의 방침에 따라, 생성자를 추가 하시오
이 클래스는 Cleric(“아서스", hp = 40, mp = 5) 와 같이, 이름, HP, MP 를 지정하여 인스턴스화 할 수 있다
이 클래스는 Cleric(“아서스", hp = 35) 와 같이, 이름과 HP만으로 지정하여 인스턴스화 할 수 있다. 이 때, MP는 최대 MP와 같은 값이 초기화 된다
이 클래스는 Cleric(“아서스") 와 같이 이름만을 지정하여 인스턴스화 할 수 있다. 이 때, HP 와 MP 는 최대 HP와 최대 MP로 초기화 된다
이 클래스는 Cleric() 과 같이 이름을 지정하지 않는 경우에는 인스턴스화 할 수 없다고 한다. (이름이 없는 성직자는 존재 할 수 없음)
 */

class Practice(
    val name: String,
    var hp: Int = MAX_HP,
    var mp: Int = MAX_MP
) {
    constructor() : this("") {
        if (name.isEmpty()) {
            throw Exception("name을 지정하지 않으면 안됩니다.")
        }
    }

    fun selfAid() {
        if (mp < 5) return throw Exception("mp가 부족합니다.")
        mp -= 5
        hp = MAX_HP
    }

    fun pray(time: Int): Int {
        if (mp >= MAX_MP) {
            mp = MAX_MP
            return 0
        }
        val result = time + Random.nextInt(0, 3)
        val actualRecovery = minOf(result, MAX_MP - mp)

        mp += actualRecovery
        return actualRecovery
    }

    companion object {
        const val MAX_HP = 50
        const val MAX_MP = 10
    }
}