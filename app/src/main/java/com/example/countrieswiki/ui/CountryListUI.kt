package com.example.countrieswiki.ui

import com.example.countrieswiki.data.Country

data class CountryListUI(
    val countries: List<Country>,
    val query: String
)