package com.dimas.android.cryptoapp.di

import com.dimas.android.cryptoapp.data.rest.api.CryptoAPI
import org.koin.dsl.module.module
import retrofit2.Retrofit

val apiModule = module {
    single(createOnStart = false) { get<Retrofit>().create(CryptoAPI::class.java)  }
}