package com.example.summary5.network

import com.example.summary5.network.model.ApiResponse
import com.example.summary5.utils.Constants
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface Api {
    @GET(Constants.END_POINT)
    suspend fun getItems(): ApiResponse
}