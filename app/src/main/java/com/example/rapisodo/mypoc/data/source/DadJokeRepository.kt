package com.example.rapisodo.mypoc.data.source

import com.example.rapisodo.mypoc.data.model.service.CharadaResponse
import com.example.rapisodo.mypoc.data.model.service.DadJokeResponse
import com.example.rapisodo.mypoc.data.source.remote.DadJokeApi
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

open class DadJokeRepository @Inject constructor(private val dadJokeApi: DadJokeApi) {

    open fun getRandomDadJoke() : Single<DadJokeResponse> {
        return dadJokeApi.getRandomDadJoke()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    open fun getCharada() : Observable<CharadaResponse> {
        return dadJokeApi.getCharada()
    }
}