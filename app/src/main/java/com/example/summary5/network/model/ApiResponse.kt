package com.example.summary5.network.model

import com.squareup.moshi.Json

data class ApiResponse(
    @Json(name = "new_courses")
    val newCourses: List<HorizontalItem>?,
    @Json(name = "active_courses")
    val activeCourses: List<VerticalItem>
)
