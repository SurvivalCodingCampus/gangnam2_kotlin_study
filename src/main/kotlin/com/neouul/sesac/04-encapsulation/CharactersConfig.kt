package com.neouul.sesac.`04-encapsulation`

const val MIN_NAME_LENGTH = 3

// Wizard
const val MAX_WIZARD_MP = 10

// Wand
const val MIN_WAND_POWER = 0.5
const val MAX_WAND_POWER = 100.0

fun main(){

    val wandd = Wand("A", MIN_WAND_POWER-1)
}