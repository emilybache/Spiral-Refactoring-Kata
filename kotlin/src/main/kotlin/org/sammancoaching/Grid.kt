package org.sammancoaching
interface Grid {
    fun width(): Int
    fun height(): Int
    fun contentAt(x: Int, y: Int): String
}