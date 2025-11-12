package _251112_generic_enum_string

enum class KeyType(val cnt: Int) {
    //열쇠의 종류별로 시도 횟수 저장하기 위한 생성자
    PADLOCK(1024),
    BUTTON(10000),
    DIAL(30000),
    FINGER(1000000)
}