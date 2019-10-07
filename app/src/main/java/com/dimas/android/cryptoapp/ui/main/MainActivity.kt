package com.dimas.android.cryptoapp.ui.main

import android.os.Bundle
import androidx.annotation.LayoutRes
import com.dimas.android.cryptoapp.R
import com.dimas.android.cryptoapp.databinding.MainActivityBinding
import com.dimas.android.cryptoapp.ui.BindingActivity
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : BindingActivity<MainActivityBinding>() {
    @LayoutRes
    override fun getLayoutResId() = R.layout.main_activity

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)

        binding.vm = getViewModel()
        binding.lifecycleOwner = this
    }


}
