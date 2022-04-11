package com.br.widgets.view.circularpercent

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.br.widget.circularpercent.CircularPercent
import com.br.widgets.databinding.ActivityCircularPercentBinding

class CircularPercentActivity : AppCompatActivity(),
    CircularPercent.Companion.CircularPercentInterface {
    val binding by lazy { ActivityCircularPercentBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.textView.text = "0%"
        binding.circularPercent.setNewPercent(0F)
        binding.circularPercent.setCallBackInterface(this)
        setupOnClickListener()
    }

    private fun setupOnClickListener() {
        binding.updateButton.setOnClickListener {
            val newPercent = binding.textField.editText?.text?.toString()?.toFloat()

            newPercent?.let {
                binding.circularPercent.setNewPercent(it / 100)
            }
            binding.textField.editText?.setText("")
        }
    }

    companion object {
        fun startActivity(context: Context) {
            context.startActivity(Intent(context, CircularPercentActivity::class.java))
        }
    }

    @SuppressLint("SetTextI18n")
    override fun setCounter(numberString: String) {
        binding.textView.text = "$numberString%"
    }
}