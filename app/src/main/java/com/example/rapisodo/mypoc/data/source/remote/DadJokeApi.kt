package com.example.rapisodo.mypoc.data.source.remote

import com.example.rapisodo.mypoc.data.model.service.CharadaResponse
import com.example.rapisodo.mypoc.data.model.service.DadJokeResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers

interface DadJokeApi {

    @Headers("Accept: application/json")
    @GET("/")
    fun getRandomDadJoke(): Single<DadJokeResponse>

//    @GET
//    abstract fun getCardImage(@Url fileUrl: String): Call<ResponseBody>


    @Headers("Accept: application/json")
    @GET("https://us-central1-kivson.cloudfunctions.net/charada-aleatoria")
    fun getCharada(): Observable<CharadaResponse>

}