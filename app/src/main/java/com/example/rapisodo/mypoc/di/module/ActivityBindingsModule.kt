package com.example.rapisodo.mypoc.di.module

import com.example.rapisodo.mypoc.feature.dadjoke.DadJokeActivity
import com.example.rapisodo.mypoc.feature.dadjoke.DadJokeModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingsModule {

    @ContributesAndroidInjector(modules = [(DadJokeModule::class)])
    abstract fun dadJokeActivity(): DadJokeActivity
}
