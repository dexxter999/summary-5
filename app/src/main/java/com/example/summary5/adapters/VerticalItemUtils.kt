package com.example.summary5.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.summary5.network.model.VerticalItem

class VerticalItemUtils : DiffUtil.ItemCallback<VerticalItem>() {
    override fun areItemsTheSame(oldItem: VerticalItem, newItem: VerticalItem) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: VerticalItem, newItem: VerticalItem) = oldItem == newItem
}