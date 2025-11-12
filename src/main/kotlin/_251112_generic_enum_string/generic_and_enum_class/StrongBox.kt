package _251112_generic_enum_string.generic_and_enum_class

class StrongBox<T>(keyType: KeyType) {
    private var instance: T? = null
    val kt = keyType
    private var cnt = keyType.cnt
    //private var cnt = 0
//    init {
//        when (kt) {
//            KeyType.PADLOCK -> {
//                cnt = 1024
//            }
//
//            KeyType.BUTTON -> {
//                cnt = 10000
//            }
//
//            KeyType.DIAL -> {
//                cnt = 30000
//            }
//
//            KeyType.FINGER -> {
//                cnt = 1000000
//            }
//        }
//
//    }

    fun put(newInstance: T) {
        instance = newInstance
    }

    fun get(): T? {
        if (cnt == 0) {
            println("금고가 열렸습니다.")
            return instance
        } else {
            println("count가 ${cnt}번 남아 금고를 열 수 없습니다.")
            cnt -= 1
            return null
        }

    }
}