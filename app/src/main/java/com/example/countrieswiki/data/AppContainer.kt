package com.example.countrieswiki.data

import com.example.countrieswiki.network.GeoDBService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppContainer {
    private val BASE_URL = "https://restcountries.com/v3.1/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val geoDBService by lazy {
        retrofit.create(GeoDBService::class.java)
    }

    val countriesRepository: CountriesRepository by lazy {
        CountriesRepository(geoDBService)
    }
}