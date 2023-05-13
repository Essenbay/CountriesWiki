package com.example.countrieswiki

import android.app.Application
import com.example.countrieswiki.data.AppContainer

class CountriesWikiApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppContainer()
    }
}