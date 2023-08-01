package com.example.hazardhunt.insight.presenatation

import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.DrawScope
import com.github.tehras.charts.bar.BarChartData
import com.github.tehras.charts.bar.renderer.bar.BarDrawer

class barDrawer : BarDrawer {
    val name = "aaa"
    val nam = name.chars()

    private val barPaint = Paint().apply {
        this.isAntiAlias = true
    }
    override fun drawBar(
        drawScope: DrawScope,
        canvas: Canvas,
        barArea: Rect,
        bar: BarChartData.Bar,
    ) {
        canvas.drawRoundRect(
            barArea.left,
            barArea.top,
            barArea.right,
            barArea.bottom,
            radiusX = 20f,
            radiusY = 20f,
            barPaint.apply {
                color = bar.color
            },
        )
    }
}
