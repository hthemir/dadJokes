package com.example.rapisodo.mypoc.feature.dadjoke

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableBoolean
import com.example.rapisodo.mypoc.data.model.presentation.DadJokePresentation
import com.example.rapisodo.mypoc.data.source.DadJokeRepository
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DadJokeViewModel @Inject constructor(
    private val dadJokeRepository: DadJokeRepository,
    private val converter: DadJokePresentationConverter
) : ViewModel() {

    val presentation = MutableLiveData<DadJokePresentation>()
    var onClickShareListener: OnClickShareListener? = null
    var loading = ObservableBoolean(false)

    fun getRandomDadJoke(): Completable {
        return getJoke()
    }

    private fun getJoke(): Completable {
        loading.set(true)
        return dadJokeRepository.getRandomDadJoke().map {
            presentation.postValue(converter.convert(it))
            loading.set(false)
        }.ignoreElement()
    }

    private val compositeDisposable = CompositeDisposable()

    fun clickGetRandomJoke() {
        loading.set(true)
        compositeDisposable.add(
            getJoke()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                }, { _ ->

                })
        )
    }

    private fun getCharada(): Completable {
        return dadJokeRepository.getCharada().map {
            presentation.postValue(converter.convertCharada(it))
            loading.set(false)
        }.ignoreElements()
    }

    fun clickGetCharada() {
        loading.set(true)
        compositeDisposable.add(
            getCharada()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                }, { _ ->

                })
        )
    }

    fun clickShare() {
        onClickShareListener?.onClickShare(presentation.value?.joke)
    }

    override fun onCleared() {
        super.onCleared()
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }

    interface OnClickShareListener {
        fun onClickShare(joke: String?)
    }
}