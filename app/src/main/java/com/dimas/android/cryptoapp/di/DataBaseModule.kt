package com.dimas.android.cryptoapp.di

import com.dimas.android.cryptoapp.data.db.CryptoDB
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module

val roomModule = module {
    single { CryptoDB.getInstance(androidApplication()) }
    single (createOnStart = false){ get<CryptoDB>().getCryptoDataDao() }
}