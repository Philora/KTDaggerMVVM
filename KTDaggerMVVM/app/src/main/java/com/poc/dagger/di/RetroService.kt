package com.poc.dagger.di

import com.poc.dagger.model.RecyclerDataList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {

    @GET("repositories")
    fun getDataListAPI(@Query("q")query: String): Call<RecyclerDataList>?

}