package com.br.widgets.view.main

import android.content.Context
import com.br.widgets.model.MyButton
import com.br.widgets.view.circularpercent.CircularPercentActivity
import com.br.widgets.view.waveloading.WaveLoadingActivity

class ButtonAction {
    companion object {
        fun MyButton.callAction(context: Context) {
            when (this.type) {
                BUTTONS.WAVE_LOADING -> WaveLoadingActivity.startActivity(context)
                BUTTONS.CIRCULAR_PERCENT -> CircularPercentActivity.startActivity(context)
            }
        }
    }

    enum class BUTTONS(val title: String) {
        WAVE_LOADING("Wave Loading"),
        CIRCULAR_PERCENT("Circular Percent")
    }
}