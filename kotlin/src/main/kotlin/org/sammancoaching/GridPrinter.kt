package org.sammancoaching

import java.util.stream.Collectors
import kotlin.math.max


class GridPrinter {
    companion object {
        fun print(grid: Grid, includeLabels: Boolean = true): String {
            val fieldWidth = max("${grid.width()}".length, "${grid.height()}".length)
            val allContent = ArrayList<List<String>>()

            if (includeLabels) {
                val header_row = ArrayList<String>()
                header_row.add("".padStart(fieldWidth))
                for (i: Int in 0 until grid.width()) {
                    header_row.add("$i".padStart(fieldWidth))
                }
                allContent.add(header_row)
            }

            for (j: Int in 0 until grid.height()) {
                val rowContents = ArrayList<String>()
                if (includeLabels) {
                    val y_coords = "$j".padStart(fieldWidth)
                    rowContents.add(y_coords)
                }
                for (i: Int in 0 until grid.width()) {
                    rowContents.add(grid.contentAt(i, j).padStart(fieldWidth))
                }
                allContent.add(rowContents)
            }
            return allContent
                .stream()
                .map{row -> row.stream().collect(Collectors.joining(" "))}
                .collect(Collectors.joining("\n"))
        }
    }
}
