package _251112_generic_enum_string

class StrongBox<T>(keyType: KeyType) {
    private var instance: T? = null
    private var cnt = 0 //외부에서 횟수 조작 못하게 private로 막음
    val kt = keyType

    init {
        when (kt) {
            KeyType.PADLOCK -> {
                cnt = 1024
            }

            KeyType.BUTTON -> {
                cnt = 10000
            }

            KeyType.DIAL -> {
                cnt = 30000
            }

            KeyType.FINGER -> {
                cnt = 1000000
            }
        }

    }

    fun put(newInstance: T) {
        instance = newInstance
    }

    fun get(): T? {
        if (cnt == 0) {
            return instance
        } else {
            cnt -= 1
            println("count가 ${cnt}번 남아 금고를 열 수 없습니다.")
            return null
        }

    }
}

fun main() {
    val strongBox = StrongBox<String>(KeyType.PADLOCK)
    repeat(1025) {
        strongBox.get()
    }
}