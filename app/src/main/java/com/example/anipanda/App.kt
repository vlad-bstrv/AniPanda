package com.example.anipanda

import android.app.Application
import com.example.anipanda.di.appModule
import com.example.anipanda.di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger()
            androidContext(this@App)
            modules(appModule, viewModelsModule)
        }
    }
}