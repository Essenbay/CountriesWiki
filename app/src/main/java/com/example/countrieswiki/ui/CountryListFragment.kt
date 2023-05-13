package com.example.countrieswiki.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.countrieswiki.databinding.FragmentCountryListBinding
import com.example.countrieswiki.viewModel.CountryListViewModel
import kotlinx.coroutines.launch

class CountryListFragment : Fragment() {
    private var _binding: FragmentCountryListBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
        "Cannot access FragmentPhotoGalleryBinding"
    }
    private val viewModel: CountryListViewModel by viewModels { CountryListViewModel.Factory }
    private val countryListAdapter = CountriesViewAdapter(emptyList())
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCountryListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.countryList.layoutManager = LinearLayoutManager(context)
        binding.countryList.adapter = countryListAdapter

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.countriesUI.collect {
                    countryListAdapter.updateData(it)
                }
            }
        }
    }


    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}