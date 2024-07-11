package com.hazardhunt.safebuddy.insight.presenatation

import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.nativeCanvas
import com.github.tehras.charts.bar.renderer.label.LabelDrawer
import com.github.tehras.charts.piechart.utils.toLegacyInt

typealias GRAPHDEMENSION = Float

const val TEXT_SIZE: GRAPHDEMENSION = 43f
const val LEFT_SIDE_ADDITION: GRAPHDEMENSION = 32f
const val RIGHT_SIDE_ADDITION: GRAPHDEMENSION = 40f

class LabelDrawer : LabelDrawer {

    private val paint = android.graphics.Paint().apply {
        this.textAlign = android.graphics.Paint.Align.CENTER
        this.color = Color.White.toLegacyInt()
        this.textSize = TEXT_SIZE
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
            barArea.left + LEFT_SIDE_ADDITION,
            barArea.bottom + RIGHT_SIDE_ADDITION,
            paint,

        )
    }
}
