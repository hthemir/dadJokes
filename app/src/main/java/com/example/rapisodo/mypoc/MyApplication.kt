package com.example.rapisodo.mypoc

import com.example.rapisodo.mypoc.di.DaggerAppComponent
import com.google.android.gms.ads.MobileAds
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class MyApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
        appComponent.inject(this)
        return appComponent
    }

    override fun onCreate() {
        super.onCreate()
        MobileAds.initialize(this, "ca-app-pub-5364425353095108~3821841778");
    }
}