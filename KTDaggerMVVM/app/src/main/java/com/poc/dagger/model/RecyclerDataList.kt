package com.poc.dagger.model

import dagger.Module

@Module
data class RecyclerDataList(val items:List<RecyclerData>)
data class RecyclerData(val name:String?,val description:String?,val owner:Owner?)
data class Owner(val avatarURL: String?)
