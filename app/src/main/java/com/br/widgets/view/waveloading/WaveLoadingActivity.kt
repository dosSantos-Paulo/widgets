package com.br.widgets.view.waveloading

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.br.widgets.R

class WaveLoadingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wave_loading)
    }

    companion object {
        fun startActivity(context: Context) {
            context.startActivity(Intent(context, WaveLoadingActivity::class.java))
        }
    }
}