package com.hhp227.kotlinstudy.`15_http`.image

import kotlin.collections.MutableMap.MutableEntry

class LruCache<K, V>(private val maxSize: Int) : LinkedHashMap<K, V>(maxSize, 0.75f, true) {
    override fun removeEldestEntry(eldest: MutableEntry<K, V>?): Boolean {
        return size > maxSize
    }
}