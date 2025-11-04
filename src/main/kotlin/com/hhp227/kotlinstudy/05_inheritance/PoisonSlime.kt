package com.hhp227.kotlinstudy.`05_inheritance`

import com.hhp227.kotlinstudy.`02_instance_class`.Hero
import com.hhp227.kotlinstudy.`02_instance_class`.MAX_HP

/*
연습문제1
다음 중에서 “잘못 된 상속" 인 것을 모두 구하시오
    슈퍼클래스           서브클래스
1.  Person             Student
2.  Car                Engine
3.  Father             Child
4.  Food               Susi
5.  SuperMan           Man

솔루션: 2, 3, 5

연습문제2
다음 클래스에 대해 “부모 클래스" 와 “자식 클래스" 를 1개씩 생각 해 보시오
(예)         (1)     (2)     (3)
Character   ?        ?      ?
↑           ↑        ↑      ↑
Hero        Phone    Car    Dictionary
↑           ↑        ↑      ↑
SuperHero   ?        ?      ?

솔루션: 좌측부터 device, vehicle, book
              iPhone, Grandeur, EnglishDictionary
연습문제3
이 클래스를 이용해, 다음 사양을 따르는 PoisonSlime 클래스를 작성하시오
독 슬라임(PoisonSlime) 은, 슬라임 (Slime) 중에서도 특히 “독 공격" 이 되는 것
PoisonSlime 는 아래의 코드로 인스턴스화 되는 클래스임
val poisonSlime = PoisonSlime(“A”);
PoisonSlime은 독 공격 가능 횟수를 저장하는 poisonCount(초기값 5)를 가진다
PoisonSlime attack() 메서드가 호출되면 다음 내용의 공격을 한다
   a. 우선, "보통 슬라임과 같은 공격"을 한다
   b. poisonCount가 0이 아니면 다음을 추가로 수행한다
   c. 화면에 "추가로, 독 포자를 살포했다!"를 표시
   d. 용사의 최대 HP의 1/5에 해당하는 포인트를 용사의 HP로부터 감소시키고, "~포인트의 데미지"라고 표시
   e. poisonCount를 1 감소시킨다
 */

class PoisonSlime(suffix: String) : Slime(suffix) {
    var poisonCount = 5

    override fun attack(hero: Hero) {
        super.attack(hero)
        if (poisonCount > 0) {
            val damage = MAX_HP / 5
            println("추가로, 독 포자를 살포했다!")
            hero.hp -= damage
            println("${damage}포인트의 데미지")
            poisonCount--
        }
    }
}