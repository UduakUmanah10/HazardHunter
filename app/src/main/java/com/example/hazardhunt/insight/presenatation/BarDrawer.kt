package com.example.hazardhunt.insight.presenatation

import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.DrawScope
import com.github.tehras.charts.bar.BarChartData
import com.github.tehras.charts.bar.renderer.bar.BarDrawer

typealias RADIUSDIMENSION =Float

const val RADIUS:RADIUSDIMENSION =16f
const val RIGHT_BAR_ADDITOIN:RADIUSDIMENSION =24f
class BarDrawer : BarDrawer {

    private val barPaint = Paint().apply {
        this.isAntiAlias = true
    }

    override fun drawBar(
        drawScope: DrawScope,
        canvas: Canvas,
        barArea: Rect,
        bar: BarChartData.Bar,
    ) {
        // canvas.drawRoundRect(
        // barArea.left,
        // 0f,
        // barArea.right+24f,
        // barArea.bottom,
        // radiusX = 16f,
        // radiusY = 16f,
        // barPaint.apply {
        //    color = Color.White
        //  },
        // )

        canvas.drawRoundRect(
            barArea.left,
            barArea.top,
            barArea.right + RIGHT_BAR_ADDITOIN,
            barArea.bottom,
            radiusX = RADIUS,
            radiusY = RADIUS,
            barPaint.apply {
                color = bar.color
            },
        )
    }
}
