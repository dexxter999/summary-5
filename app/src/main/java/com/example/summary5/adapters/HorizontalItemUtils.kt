package com.example.summary5.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.summary5.network.model.HorizontalItem

class HorizontalItemUtils : DiffUtil.ItemCallback<HorizontalItem>() {
    override fun areItemsTheSame(oldItem: HorizontalItem, newItem: HorizontalItem) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: HorizontalItem, newItem: HorizontalItem) = oldItem == newItem

}