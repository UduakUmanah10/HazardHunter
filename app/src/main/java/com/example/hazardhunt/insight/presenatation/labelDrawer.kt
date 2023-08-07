package com.example.hazardhunt.insight.presenatation

import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.nativeCanvas
import com.github.tehras.charts.bar.renderer.label.LabelDrawer
import com.github.tehras.charts.piechart.utils.toLegacyInt

class labelDrawer : LabelDrawer {

    private val paint = android.graphics.Paint().apply {
        this.textAlign = android.graphics.Paint.Align.CENTER
        this.color = Color.White.toLegacyInt()
        this.textSize = 43f
    }
    override fun drawLabel(
        drawScope: DrawScope,
        canvas: Canvas,
        label: String,
        barArea: Rect,
        xAxisArea: Rect,
    ) {
        canvas.nativeCanvas.drawText(
            label,
            barArea.left + 32f,
            barArea.bottom + 40f,
            paint,

        )
    }
}
