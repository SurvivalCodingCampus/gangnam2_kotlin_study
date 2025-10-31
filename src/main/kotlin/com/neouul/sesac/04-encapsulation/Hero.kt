package com.neouul.sesac.`04-encapsulation`

class Hero(
    var name: String,
    private var hp: Int,
    var sword: Sword? = null,
) {
    fun bye(){
        println("바이바이")
    }

    private fun die(){
        println("You Died")
    }
}