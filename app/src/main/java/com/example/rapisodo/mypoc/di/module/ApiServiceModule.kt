package com.example.rapisodo.mypoc.di.module

import com.example.rapisodo.mypoc.data.source.remote.DadJokeApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class ApiServiceModule {

    @Provides
    internal fun provideDadJokeApi(retrofit: Retrofit): DadJokeApi {
        return retrofit.create<DadJokeApi>(DadJokeApi::class.java)
    }

}
