package com.example.summary5.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.summary5.R
import com.example.summary5.databinding.HorizontalItemBinding
import com.example.summary5.network.model.HorizontalItem

class HorizontalRecyclerViewAdapter :
    ListAdapter<HorizontalItem, HorizontalRecyclerViewAdapter.HorizontalItemViewHolder>(HorizontalItemUtils()) {

    inner class HorizontalItemViewHolder(private val binding: HorizontalItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(item: HorizontalItem) = with(binding){
                tvTitle.text = item.title

                when(item.iconType) {
                    SETTINGS -> {
                        val settingsDrawable = ContextCompat.getDrawable(root.context, R.drawable.ic_settings)
                        ivCard.background = settingsDrawable
                        card.setCardBackgroundColor(Color.GREEN)
                    }
                    CARD -> {
                        val cardDrawable = ContextCompat.getDrawable(root.context, R.drawable.ic_card)
                        ivCard.background = cardDrawable
                        card.setCardBackgroundColor(Color.RED)
                    }
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalItemViewHolder {
        return HorizontalItemViewHolder(
            HorizontalItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: HorizontalItemViewHolder, position: Int) {
        return holder.bind(getItem(position))
    }

    companion object {
        const val SETTINGS = "settings"
        const val CARD = "card"
    }
}