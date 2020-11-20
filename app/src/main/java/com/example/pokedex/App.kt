package com.example.pokedex

import android.app.Application
import com.example.pokedex.di.AppModules
import com.example.pokedex.di.NetworkModules
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.fragment.koin.fragmentFactory
import org.koin.core.KoinExperimentalAPI
import org.koin.core.context.startKoin

class App: Application() {
    @KoinExperimentalAPI
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            fragmentFactory()
            modules(listOf(AppModules, NetworkModules))
        }
    }
}