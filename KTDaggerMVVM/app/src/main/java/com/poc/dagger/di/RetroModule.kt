package com.poc.dagger.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RetroModule {
    val mBaseURL = "https://api.github.com/search/" // repositories?q=newyork

    @Singleton
    @Provides
    fun getRetroServiceInterface(retrofit: Retrofit): RetroService {
        return retrofit.create(RetroService::class.java)
    }

    @Singleton
    @Provides
    fun getRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(mBaseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}