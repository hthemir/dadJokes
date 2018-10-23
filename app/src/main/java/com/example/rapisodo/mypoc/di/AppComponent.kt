package com.example.rapisodo.mypoc.di

import android.app.Application
import com.example.rapisodo.mypoc.di.module.ActivityBindingsModule
import com.example.rapisodo.mypoc.di.module.ApiServiceModule
import com.example.rapisodo.mypoc.di.module.NetworkModule
import com.example.rapisodo.mypoc.di.module.ViewModelBindindsModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        (NetworkModule::class),
        (ApiServiceModule::class),
        (ActivityBindingsModule::class),
        (ViewModelBindindsModule::class),
        (AndroidSupportInjectionModule::class)
    ]
)
interface AppComponent : AndroidInjector<DaggerApplication> {

    override fun inject(daggerApplication: DaggerApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}