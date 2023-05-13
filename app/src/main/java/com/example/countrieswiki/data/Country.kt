package com.example.countrieswiki.data

data class Country(
    val name: Name,
    val region: String,
    val area: Double,
    val population: Long,
)

data class Name(
    val common: String,
    val official: String,
)