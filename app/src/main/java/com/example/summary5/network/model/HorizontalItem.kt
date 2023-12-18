package com.example.summary5.network.model

import com.squareup.moshi.Json

data class HorizontalItem(
    val duration: String,
    @Json(name = "icon_type")
    val iconType: String,
    val id: String,
    @Json(name = "main_color")
    val mainColor: String,
    val question: String,
    val title: String
)