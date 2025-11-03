package com.survivalcoding.kotlinstudy.`05_inheritance`

// 연습문제 3. PoisonSlime 클래스
class PoisonSlime(
    suffix: String
) : Slime(suffix) {
    var poisonCount = 5

    override fun attack(hero: Hero) {
        // 보통 슬라임과 같은 공격
        super.attack(hero)

        // poisonCount가 0이 아니면 추가 공격
        if (poisonCount > 0) {
            println("추가로, 독 포자를 살포했다!")
            val damage = hero.maxHp / 5  // 용사의 최대 HP의 1/5 만큼 데미지
            hero.hp -= damage
            println("${damage} 포인트의 데미지!")
            poisonCount -= 1  // poisonCount 1 감소
        }
    }
}
