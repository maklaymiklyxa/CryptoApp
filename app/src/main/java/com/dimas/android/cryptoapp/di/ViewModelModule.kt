package com.dimas.android.cryptoapp.di

import com.dimas.android.cryptoapp.ui.main.CryptoViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModelModule = module {
    viewModel {
        CryptoViewModel(get(), get())
    }
}