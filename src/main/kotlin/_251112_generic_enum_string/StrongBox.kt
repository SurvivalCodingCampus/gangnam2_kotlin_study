package _251112_generic_enum_string

class StrongBox<T> {
    private var instance: T? = null

    fun put(newInstance: T) {
        instance = newInstance
    }

    fun get(): T? {
        return instance
    }
}