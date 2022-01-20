package com.poc.dagger.di

import com.poc.dagger.MainActivityViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetroModule::class])
interface RetroComponent {

    fun inject(viewModel: MainActivityViewModel)
}