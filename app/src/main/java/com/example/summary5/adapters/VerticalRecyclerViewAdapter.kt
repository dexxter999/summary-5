package com.example.summary5.adapters

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.summary5.R
import com.example.summary5.databinding.VerticalItemBinding
import com.example.summary5.network.model.VerticalItem

class VerticalRecyclerViewAdapter :
    ListAdapter<VerticalItem, VerticalRecyclerViewAdapter.VerticalItemViewHolder>(VerticalItemUtils()) {

    inner class VerticalItemViewHolder(private val binding: VerticalItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: VerticalItem) = with(binding) {
            Glide.with(itemView.context).load(item.image).into(view)
            tvTitle.text = item.title
            tvBookTime.text = item.bookingTime

            val mainColor = Color.parseColor("#${item.mainColor}")
            val opacity =
                item.backgroundColorPresent.toInt() * 255 / 100

            val shapeDrawable = ContextCompat.getDrawable(root.context, R.drawable.round_corners) as GradientDrawable
            shapeDrawable.setColor(Color.argb(
                opacity,
                Color.red(mainColor),
                Color.green(mainColor),
                Color.blue(mainColor)
            ))
            root.background = shapeDrawable

            tvTitle.setTextColor(
                mainColor
            )

            tvBookTime.setTextColor(
                mainColor
            )
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerticalItemViewHolder {
        return VerticalItemViewHolder(
            VerticalItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: VerticalItemViewHolder, position: Int) {
        return holder.bind(getItem(position))
    }
}