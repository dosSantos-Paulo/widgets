package com.br.widgets.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.br.widgets.databinding.ActivityMainBinding
import com.br.widgets.model.MyButton
import com.br.widgets.view.main.ButtonAction.Companion.callAction

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val buttons = createButtons()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = ButtonsAdapter(buttons)
        }
    }

    private fun createButtons() = mutableListOf<MyButton>().apply {
        ButtonAction.BUTTONS.values().forEach { add(MyButton(it)) }
    }
}