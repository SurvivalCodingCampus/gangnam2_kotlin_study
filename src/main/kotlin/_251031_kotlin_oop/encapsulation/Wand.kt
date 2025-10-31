package _251031_kotlin_oop.encapsulation

const val MINIMUM_NAME_LENGTH = 3

const val WAND_MP_MIN = 0.5
const val WAND_MP_MAX = 100.0

class Wand(
    var name: String,
    var power: Double,
) {
    init {
        if (name.isEmpty() || name.length < MINIMUM_NAME_LENGTH) {
            throw IllegalArgumentException("지팡이의 이름은 ${MINIMUM_NAME_LENGTH}글자 이상이어야 합니다.")
        }
        if (power !in WAND_MP_MIN..WAND_MP_MAX) {
            throw IllegalArgumentException("지팡이의 마력은 ${WAND_MP_MIN}이상 ${WAND_MP_MAX}이하여야 합니다.")
        }
    }
}