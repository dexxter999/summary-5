package com.example.summary5.network.model

import com.squareup.moshi.Json

data class VerticalItem(
    @Json(name = "background_color_present")
    val backgroundColorPresent: String,
    @Json(name = "booking_time")
    val bookingTime: String,
    val id: String,
    val image: String,
    @Json(name = "main_color")
    val mainColor: String,
    @Json(name = "play_button_color_present")
    val playButtonColorPresent: String,
    val progress: String,
    val title: String
)