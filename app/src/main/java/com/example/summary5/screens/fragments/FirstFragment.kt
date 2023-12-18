package com.example.summary5.screens.fragments

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.summary5.adapters.HorizontalRecyclerViewAdapter
import com.example.summary5.adapters.VerticalRecyclerViewAdapter
import com.example.summary5.base.BaseFragment
import com.example.summary5.databinding.FragmentFirstBinding
import com.example.summary5.interfaces.Observers
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FirstFragment : BaseFragment<FragmentFirstBinding>(FragmentFirstBinding::inflate), Observers {

    private lateinit var adapter: HorizontalRecyclerViewAdapter
    private lateinit var adapterVertical: VerticalRecyclerViewAdapter
    private val viewModel: MainViewModel by viewModels()

    override fun init() {
        setupRecyclerView()
        observers()
        viewModel.fetchDataFromApi()
    }

    private fun setupRecyclerView() {
        adapter = HorizontalRecyclerViewAdapter()
        binding.horizontalRecycler.adapter = adapter

        adapterVertical = VerticalRecyclerViewAdapter()
        binding.verticalRecycler.adapter = adapterVertical
    }

    override fun observers() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.itemsList.collect { response ->
                    if (response != null) {
                        adapter.submitList(response.newCourses)
                        adapterVertical.submitList(response.activeCourses)
                    }
                }
            }
        }
    }

}