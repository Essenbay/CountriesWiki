package com.example.countrieswiki.data

import com.squareup.moshi.Json

data class GeoData(
    @Json(name = "")
    val data: List<Country>
)