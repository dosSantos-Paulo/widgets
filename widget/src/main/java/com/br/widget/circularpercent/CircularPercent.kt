package com.br.widget.circularpercent

import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import android.view.animation.DecelerateInterpolator
import com.br.widget.R
import java.math.RoundingMode
import java.text.DecimalFormat

class CircularPercent(context: Context, attrs: AttributeSet) : View(context, attrs) {

    private var circularInterface: CircularPercentInterface? = null

    private var startAngle = 0f
    private var endAngle = 270f
    private var layoutWidth = 0
    private var layoutHeight = 0
    private var itemStroke = 8f
    private var oldAngle = 0F
    private var itemColor = Color.BLACK
    private val paint = Paint().apply {
        color = itemColor
        strokeCap = Paint.Cap.ROUND
        style = Paint.Style.STROKE
        strokeWidth = itemStroke
    }

    private val rectF = RectF(itemStroke, itemStroke, 0f, 0f)

    private fun setEndAngle(angle: Float) {
        val df = DecimalFormat("#.#").apply {
            roundingMode = RoundingMode.DOWN
        }

        val percent = df.format((angle / 360F) * 100)

        circularInterface?.setCounter(percent)
        endAngle = angle
    }

    init {
        context.theme.obtainStyledAttributes(R.styleable.CircularPercent).apply {
            itemColor = getColor(R.styleable.CircularPercent_circleColor, itemColor)
            itemStroke = getDimension(R.styleable.CircularPercent_circleStrokeWidth, itemStroke)
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        layoutWidth = MeasureSpec.getSize(widthMeasureSpec)
        layoutHeight = MeasureSpec.getSize(heightMeasureSpec)
        rectF.bottom = (layoutHeight.coerceAtMost(layoutHeight) - itemStroke)
        rectF.right = (layoutHeight.coerceAtMost(layoutHeight) - itemStroke)
    }

    fun setCallBackInterface(circularInterface: CircularPercentInterface) {
        this.circularInterface = circularInterface
    }

    fun setNewPercent(newPercent: Float) {
        configAnimation(newPercent * 360f)
        oldAngle = newPercent * 360f
    }

    private fun configAnimation(angle: Float) {
        val objectAnimator = ObjectAnimator.ofFloat(this, "endAngle", oldAngle, angle)
        objectAnimator.run {
            duration = 3000L
            interpolator = DecelerateInterpolator()
            addUpdateListener { invalidate() }
        }
        objectAnimator.start()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawArc(rectF, startAngle, endAngle, false, paint)
    }

    companion object {
        interface CircularPercentInterface {
            fun setCounter(numberString: String)
        }
    }

}