package com.example.rapisodo.mypoc.feature.dadjoke

import android.support.v7.app.AppCompatActivity
import com.example.rapisodo.mypoc.di.module.BaseActivityModule
import dagger.Binds
import dagger.Module

@Module(includes = [(BaseActivityModule::class)])
abstract class DadJokeModule {

    @Binds
    abstract fun activity(activity: DadJokeActivity): AppCompatActivity
}