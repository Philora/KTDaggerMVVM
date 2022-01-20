package com.poc.dagger

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.poc.dagger.di.RetroService
import com.poc.dagger.model.RecyclerDataList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    @Inject
    lateinit var mService: RetroService

    private lateinit var liveData: MutableLiveData<RecyclerDataList>

    init {
        // Here we has to init View Model
        (application as MyApplication).getRetroComponent().inject(this)
        liveData = MutableLiveData()
    }

    fun getLivaDataObserve(): MutableLiveData<RecyclerDataList> {
        return liveData
    }

    fun makeAPICall() {
        val call: Call<RecyclerDataList>? = mService.getDataListAPI("alt")
        call?.enqueue(object : Callback<RecyclerDataList> {
            override fun onFailure(call: Call<RecyclerDataList>, t: Throwable) {
                liveData.postValue(null)
            }

            override fun onResponse(call: Call<RecyclerDataList>, response: Response<RecyclerDataList>) {
                if (response.isSuccessful){
                    liveData.postValue(response.body())
                }else{
                    liveData.postValue(null)
                }
            }
        })
    }
}