package com.example.countrieswiki.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.countrieswiki.CountriesWikiApplication
import com.example.countrieswiki.data.CountriesRepository
import com.example.countrieswiki.data.Country
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

//Todo: Add progress bar
class CountryListViewModel(private val repository: CountriesRepository) : ViewModel() {
    private val _countriesUI: MutableStateFlow<List<Country>> = MutableStateFlow(emptyList())
    val countriesUI: StateFlow<List<Country>> = _countriesUI.asStateFlow()

    init {
        viewModelScope.launch {
            _countriesUI.update {
                repository.getCountries()
            }
        }
    }

    companion object {
        val Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
                val application = extras[APPLICATION_KEY] as CountriesWikiApplication
                val repository = application.container.countriesRepository
                return CountryListViewModel(repository) as T
            }
        }
    }
}