package com.example.summary5.screens.fragments

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.summary5.network.Api
import com.example.summary5.network.model.ApiResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val api: Api) : ViewModel() {
    private val _itemsList = MutableStateFlow<ApiResponse?>(null)
    val itemsList = _itemsList.asStateFlow()

    fun fetchDataFromApi() {
        viewModelScope.launch {
            try {
                val response = api.getItems()
                _itemsList.value = response
                Log.d("SampleFragmentViewModel", "Data loaded successfully: $response")
            } catch (e: Exception) {
                Log.e("SampleFragmentViewModel", "Error loading data: ${e.message}", e)
            }
        }
    }
}