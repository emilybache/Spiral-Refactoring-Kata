package org.sammancoaching

import java.util.*



class Spiral(val size: Int) : Grid {

    override fun width(): Int {
        return size
    }

    override fun height(): Int {
        return size
    }

    override fun contentAt(x: Int, y: Int): String {
        val s = spiralize()
        return if (s.isNullOrEmpty()) ""
        else "${s[y][x]}"
    }

    fun print(): String {
        return GridPrinter.print(this, false).trim()
    }

    private fun spiralize(): Array<IntArray>? {
        return if (size < 5) {
            null
        } else spiralize(Array(size) { IntArray(size) })
    }

    private fun spiralize(arr: Array<IntArray>): Array<IntArray> {
        val fill = fill(arr)
        val height = fill.size
        val width: Int = fill[0].size
        var lastY = height / 2
        var lastX = if (width % 2 == 0) width / 2 - 1 else width / 2

        // Extra variants
        if (height == 5) {
            lastX = 1
            lastY = 3
        } else if ((height - 5) % 4 == 0) {
            lastX--
            lastY++
        }
        var y = 1
        var x = 0
        var dirX = 1
        var dirY = 0
        var i = 0
        var leftBorder = 0
        var rightBorder = width - 1
        var upperBorder = 0
        var lowerBorder = height - 1
        while (true) {
            if (x == rightBorder && y == upperBorder + 1) {
                x--
                y++
                dirX = 0
                dirY = 1
                upperBorder += 2
            } else if (x == leftBorder && y == lowerBorder - 1) {
                x++
                y--
                dirX = 0
                dirY = -1
                lowerBorder -= 2
            } else if (y == lowerBorder && x == rightBorder - 1) {
                y--
                x--
                dirX = -1
                dirY = 0
                rightBorder -= 2
            } else if (y == upperBorder && x == leftBorder + 1) {
                y++
                x++
                dirX = 1
                dirY = 0
                leftBorder += 2
            }
            fill[y][x] = 0
            if (y == lastY && x == lastX) {
                break
            }
            x += dirX
            y += dirY
            i++
        }
        return fill
    }

    fun fill(arr: Array<IntArray>): Array<IntArray> {
        for (row in arr) {
            Arrays.fill(row, 1)
        }
        return arr
    }


}