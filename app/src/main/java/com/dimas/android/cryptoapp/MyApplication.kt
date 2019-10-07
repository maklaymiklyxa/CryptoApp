package com.dimas.android.cryptoapp

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.net.ConnectivityManagerCompat
import com.dimas.android.cryptoapp.di.apiModule
import com.dimas.android.cryptoapp.di.networkModule
import com.dimas.android.cryptoapp.di.roomModule
import com.dimas.android.cryptoapp.di.viewModelModule
import org.koin.android.ext.android.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(
            this, listOf(
                networkModule,
                apiModule,
                roomModule,
                viewModelModule
            )
        )
    }
}