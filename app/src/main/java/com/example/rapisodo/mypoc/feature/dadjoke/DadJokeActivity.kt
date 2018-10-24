package com.example.rapisodo.mypoc.feature.dadjoke

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.rapisodo.mypoc.R
import com.example.rapisodo.mypoc.base.BaseDatabindingActivity
import com.example.rapisodo.mypoc.databinding.ActivityJokeRelativeBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_joke_relative.*

open class DadJokeActivity : BaseDatabindingActivity<ActivityJokeRelativeBinding, DadJokeViewModel>() {

    private val compositeDisposable = CompositeDisposable()

    override fun getLayoutId(): Int? = R.layout.activity_joke_relative

    override fun initialize() {
        dataBinding.viewModel = viewModel
        viewModel.onClickShareListener = (object : DadJokeViewModel.OnClickShareListener {
            override fun onClickShare(joke: String?) {
                openShare(joke)
            }
        })

        compositeDisposable.add(viewModel.getRandomDadJoke().subscribe({}, { _ ->
            Toast.makeText(this, "batatao", Toast.LENGTH_SHORT)
        }))

//        startAdmob()
    }

    override fun getViewModelClass(): Class<DadJokeViewModel> = DadJokeViewModel::class.java

    fun openShare(joke: String?) {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, joke)
            type = "text/plain"
        }
        startActivity(sendIntent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startAdmob()
    }

    fun startAdmob() {
        MobileAds.initialize(this, "ca-app-pub-5364425353095108~3821841778");
        val adRequest = AdRequest.Builder().build()
        dataBinding.adView.loadAd(adRequest)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }
}