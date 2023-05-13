package com.example.countrieswiki.network

import com.example.countrieswiki.data.Country
import retrofit2.http.GET

interface GeoDBService {
    @GET("all")
    suspend fun getGeoData(): List<Country>
}