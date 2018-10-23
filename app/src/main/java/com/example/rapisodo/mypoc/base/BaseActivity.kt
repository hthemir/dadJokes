package com.example.rapisodo.mypoc.base

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

abstract class BaseActivity<VM : ViewModel> : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var viewModeFactory: ViewModelProvider.Factory

    @Inject
    lateinit var supportFragmentInjector: DispatchingAndroidInjector<Fragment>

    protected lateinit var viewModel: VM
    protected open val shouldSetContentView: Boolean get() = true
    protected open val shouldCallInitialize: Boolean get() = true

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return supportFragmentInjector
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        try {
            AndroidInjection.inject(this)
        } catch (ex: Exception) {
            print(ex.message)
        }

        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(this, this.viewModeFactory).get(getViewModelClass())

        if (shouldSetContentView && getLayoutId() != null) {
            setContentView(getLayoutId()!!)
        }

        if (shouldCallInitialize) {
            initialize()
        }
    }

    protected abstract fun getLayoutId(): Int?

    protected abstract fun initialize()

    protected abstract fun getViewModelClass(): Class<VM>
}