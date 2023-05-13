package com.example.countrieswiki.data

import com.example.countrieswiki.network.GeoDBService

//Todo: Implement Builder
class CountriesRepository(private val service: GeoDBService) {
    suspend fun getCountries(): List<Country> = service.getGeoData()
}