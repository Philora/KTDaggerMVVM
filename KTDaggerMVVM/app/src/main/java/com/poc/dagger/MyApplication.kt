package com.poc.dagger

import android.app.Application
import com.poc.dagger.di.DaggerRetroComponent
import com.poc.dagger.di.RetroModule
import com.poc.dagger.di.RetroComponent

class MyApplication : Application() {

    private lateinit var retroComponent: RetroComponent

    override fun onCreate() {
        super.onCreate()
        retroComponent = DaggerRetroComponent.builder()
            .retroModule(RetroModule())
            .build()
    }

    fun getRetroComponent(): RetroComponent{
        return retroComponent
    }
}