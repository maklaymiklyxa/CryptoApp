package com.dimas.android.cryptoapp.data.rest.api

import com.dimas.android.cryptoapp.data.entity.CryptoMapResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface CryptoAPI {

    @GET("v1/cryptocurrency/map")
    fun getCryptoInfo(@QueryMap params: MutableMap<String, String>): Single<CryptoMapResponse>
}