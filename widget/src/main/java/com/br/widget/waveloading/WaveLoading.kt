package com.br.widget.waveloading

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.br.widget.R

class WaveLoading(context: Context, attrs: AttributeSet) : View(context, attrs) {
    var firstColor: Int = Color.BLUE
    var secondColor: Int = Color.YELLOW

    var firstWavePaint = Paint().apply {
        color = firstColor
        strokeWidth = 10F
        strokeCap = Paint.Cap.SQUARE
    }

    var waveWidth: Float = width.toFloat()
    var waveInclination = 30F

    init {
        context.theme.obtainStyledAttributes(R.styleable.WaveLoading).apply {
            getColor(R.styleable.WaveLoading_firstColor, Color.BLUE)
            getColor(R.styleable.WaveLoading_secondColor, Color.YELLOW)
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        waveWidth = MeasureSpec.getSize(widthMeasureSpec).toFloat()
    }

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        canvas?.let {
            drawFirstWave(it)
        }
    }

    fun drawFirstWave(canvas: Canvas) {
        canvas.drawLine(0F, 0F, waveWidth, waveInclination, firstWavePaint)
    }
}