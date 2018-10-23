package com.example.rapisodo.mypoc.base

import android.arch.lifecycle.ViewModel
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle

abstract class BaseDatabindingActivity<DB : ViewDataBinding, VM : ViewModel> : BaseActivity<VM>() {

    protected lateinit var dataBinding: DB
    override val shouldSetContentView: Boolean get() = false
    override val shouldCallInitialize: Boolean get() = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (getLayoutId() != null) {
            dataBinding = DataBindingUtil.setContentView(this, getLayoutId()!!)
            dataBinding.setLifecycleOwner(this)
        }

        initialize()
    }
}
