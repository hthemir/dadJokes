package com.example.rapisodo.mypoc.di.module

import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import dagger.Module
import dagger.Provides

@Module
abstract class BaseActivityModule {

    @Module
    companion object {

        @JvmStatic
        @Provides
        internal fun providesFragmentManager(activity: AppCompatActivity): FragmentManager {
            return activity.supportFragmentManager
        }
    }
}