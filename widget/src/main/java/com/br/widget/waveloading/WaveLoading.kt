package com.br.widget.waveloading

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import com.br.widget.R

class WaveLoading(context: Context, attrs: AttributeSet) : View(context, attrs) {
    var firstColor: Int = Color.BLUE
    var secondColor: Int = Color.YELLOW

    init {
        context.theme.obtainStyledAttributes(R.styleable.WaveLoading).apply {
            getColor(R.styleable.WaveLoading_firstColor, Color.BLUE)
            getColor(R.styleable.WaveLoading_secondColor, Color.YELLOW)
        }
    }
}