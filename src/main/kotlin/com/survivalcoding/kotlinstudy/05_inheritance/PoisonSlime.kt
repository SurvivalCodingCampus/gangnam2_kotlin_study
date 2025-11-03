package com.survivalcoding.kotlinstudy.`05_inheritance`

// 연습문제 3. PoisonSlime 클래스
class PoisonSlime(
    suffix: String
) : Slime(suffix) {
    // 테스트를 위해서 매직 넘버 제거
    companion object {
        const val INITIAL_POISON_COUNT = 5
        const val DAMAGE_RATIO = 5   // 최대 HP의 1/5
    }

    // 캡슐화 -> get 만 가능하게 함
    var poisonCount = INITIAL_POISON_COUNT
        private set

    var lastDamage: Int = 0
        private set


    override fun attack(hero: Hero) {
        // 보통 슬라임과 같은 공격
        super.attack(hero)

        // poisonCount가 0이 아니면 추가 공격
        if (poisonCount > 0) {
            println("추가로, 독 포자를 살포했다!")
            lastDamage = hero.maxHp / DAMAGE_RATIO   // 용사의 최대 HP의 1/5 만큼 데미지
            hero.hp -= lastDamage
            println("${lastDamage} 포인트의 데미지!")
            poisonCount -= 1    // poisonCount 1 감소
        } else {
            lastDamage = 0  // 독 공격이 발생하지 않음
        }
    }
}
