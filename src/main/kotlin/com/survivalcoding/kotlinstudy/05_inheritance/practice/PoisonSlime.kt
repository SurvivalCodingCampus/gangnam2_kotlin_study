package com.survivalcoding.kotlinstudy.`05_inheritance`.practice

import com.survivalcoding.kotlinstudy.`02_instance_class`.Hero

/*
이 클래스를 이용해, 다음 사양을 따르는 PoisonSlime 클래스를 작성하시오

1. 독 슬라임(PoisonSlime) 은, 슬라임 (Slime) 중에서도 특히 “독 공격" 이 되는 것
2. PoisonSlime 는 아래의 코드로 인스턴스화 되는 클래스임
    val poisonSlime = PoisonSlime(“A”);
3. PoisonSlime은 독 공격 가능 횟수를 저장하는 poisonCount(초기값 5)를 가진다
4. PoisonSlime attack() 메서드가 호출되면 다음 내용의 공격을 한다
   a. 우선, "보통 슬라임과 같은 공격"을 한다
   b. poisonCount가 0이 아니면 다음을 추가로 수행한다
   c. 화면에 "추가로, 독 포자를 살포했다!"를 표시
   d. 용사의 최대 HP의 1/5에 해당하는 포인트를 용사의 HP로부터 감소시키고, "~포인트의 데미지"라고 표시
   e. poisonCount를 1 감소시킨다
*/

class PoisonSlime(
    poisonCount: Int = DEFAULT_POISON_COUNT
) : Slime("PoisonSlime") {
    // poisonCount를 내부에서만 변경
    private var _poisonCount = poisonCount

    val poisonCount: Int
        get() = _poisonCount

    // attack() 재정의
    override fun attack(hero: Hero) {
        val poisonDamage = hero.maxHp / 5 // 최대체력의 1/5

        // 보통 슬라임 공격
        super.attack(hero)

        // poisonCount가 남아있다면 추가 공격
        if (_poisonCount <= 0) {
            return
        }
        println("추가로, 독 포자를 살포했다!")
        hero.hp -= poisonDamage
        println("${poisonDamage}포인트의 데미지")
        _poisonCount--
    }

    companion object {
        const val DEFAULT_POISON_COUNT = 5 // 포이즌 카운트의 기본값
    }
}