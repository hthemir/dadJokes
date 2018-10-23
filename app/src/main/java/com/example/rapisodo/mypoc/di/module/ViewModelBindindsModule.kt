package com.example.rapisodo.mypoc.di.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.rapisodo.mypoc.base.ViewModelFactory
import com.example.rapisodo.mypoc.di.annotation.ViewModelKey
import com.example.rapisodo.mypoc.feature.dadjoke.DadJokeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelBindindsModule {

    @Binds
    @IntoMap
    @ViewModelKey(DadJokeViewModel::class)
    abstract fun dadJokeViewModel(viewModel: DadJokeViewModel) : ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}