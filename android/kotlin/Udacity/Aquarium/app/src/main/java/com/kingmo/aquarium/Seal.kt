package com.kingmo.aquarium

//sealed class: can only override Seal in this file only.
sealed class Seal(val type: String)

class SeaLion(type: String): Seal(type)

class Walrus(type: String): Seal(type)

