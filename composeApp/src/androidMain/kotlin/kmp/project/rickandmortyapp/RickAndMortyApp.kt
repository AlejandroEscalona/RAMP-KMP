package kmp.project.rickandmortyapp

import android.app.Application
import kmp.project.rickandmortyapp.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class RickAndMortyApp: Application() {
    override fun onCreate() {
        initKoin{
            androidLogger()
            androidContext(this@RickAndMortyApp)
        }
        super.onCreate()
    }
}