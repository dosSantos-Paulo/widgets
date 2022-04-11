package com.br.widgets.view.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.br.widgets.databinding.MyButtonLayoutBinding
import com.br.widgets.model.MyButton
import com.br.widgets.view.main.ButtonAction.Companion.callAction

class ButtonsAdapter(private var buttons: MutableList<MyButton>) :
    RecyclerView.Adapter<ButtonsAdapter.Holder>() {

    class Holder(private val binding: MyButtonLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(button: MyButton) {
            binding.button.text = button.type.title
            binding.button.setOnClickListener {
                button.callAction(binding.root.context)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = Holder(
        MyButtonLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )


    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.onBind(buttons[position])
    }

    override fun getItemCount() = buttons.size
}