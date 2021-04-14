package com.serlife.movies

import android.app.Application
import com.serlife.movies.di.networkModule
import com.serlife.movies.di.repositoryModule
import com.serlife.movies.di.viewModelModule
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin { modules(viewModelModule, repositoryModule, networkModule) }
    }
}