package com.survivalcoding.kotlinstudy.`03_encapsulation`.practice

/*
1번.
다음 2개의 클래스 “Wizard (마법사)”, “Wand (지팡이)” 를 작성하시오. 마법사는 지팡이를 들 수 있습니다.

작성한 Wand 클래스와 Wizard 클래스에 대해, 아래의 규칙에 따라 타당성 검사를 추가하시오.
부정한 값이 설정 될 경우에는 “IllegalArgumentException(“메세지")” 를 작성하여 프로그램을 중단 시킵니다.
1) 마법사나 지팡이의 이름은 null 일 수 없고, 반드시 3문자 이상이어야 한다
2) 지팡이의 마력은 0.5 이상 100.0 이하여야 한다.
3) 마법사의 MP는 0 이상이어야 한다.
4) HP가 음수가 되는 상황에서는 대신 0을 설정 되도록 한다.
*/

/*
2번. Person 클래스를 작성하시오.

1) 이름과 태어난 해를 생성자로 받는다 (name, birthYear)
2) 이름과 태어난 해는 한번 정해지면 수정이 불가능하다.
3) age 프로퍼티를 통해 나이를 제공하지만, 임의로 수정은 불가능하다.
4) 나이 계산은 올해년도에서 birthYear 년도를 뺀 값을 리턴한다
    a. 현재 시간과 날짜를 구하는 방법은 검색 해 볼 것
*/

class Wizard(
    name: String,           // 이름
    hp: Int,                // 체력
    mp: Int = DEFAULT_MP,   // 마나
    wand: Wand?,            // 완드
) {
    // 이름이 3자 미만인 상황
    var name: String = name
        set(value) {
            if (value.length < 3) {
                throw IllegalArgumentException("이름이 3자 이상이어야 합니다.")
            }

            if (value.length > 8) {
                throw IllegalArgumentException("이름이 8자 이하이어야 합니다.")
            }

            if (value.contains(" ")) {
                throw IllegalArgumentException("이름에 공백이 포함되어 있습니다.")
            }

            if (value.contains(Regex("[^A-Za-z0-9가-힣]"))) {
                throw IllegalArgumentException("이름에 특수문자가 포함되어 있습니다.")
            }

            field = value
        }

    // mp가 음수가 되는 상황
    var mp: Int = mp
        set(value) {
            if (value < 0) {
                throw IllegalArgumentException("MP는 0 이상이어야 합니다.")
            }

            if (value > 1000) {
                throw IllegalArgumentException("MP는 1000 이하이어야 합니다.")
            }

            field = value
        }

    // hp가 음수가 되는 상황
    var hp: Int = hp
        set(value) {
            field = if (value < 0) 0 else value
        }

    companion object {
        const val DEFAULT_MP = 0
    }
}