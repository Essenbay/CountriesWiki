package com.example.countrieswiki.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.countrieswiki.CountriesWikiApplication
import com.example.countrieswiki.data.CountriesRepository
import com.example.countrieswiki.databinding.FragmentCountryListBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CountryListFragment : Fragment() {
    private var _binding: FragmentCountryListBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
        "Cannot access FragmentPhotoGalleryBinding"
    }
    private lateinit var repository: CountriesRepository

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
        repository =
            (requireActivity().application as CountriesWikiApplication).container.countriesRepository

        fetchCountries()
    }

    private fun fetchCountries() = viewLifecycleOwner.lifecycleScope.launch {
        val response = repository.getCountries()
        Log.d("Response", response.toString())
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}