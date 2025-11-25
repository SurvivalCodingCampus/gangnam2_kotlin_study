package com.sesac.practice.day15.core

interface FileProvider {
    fun exists(path: String): Boolean
}
