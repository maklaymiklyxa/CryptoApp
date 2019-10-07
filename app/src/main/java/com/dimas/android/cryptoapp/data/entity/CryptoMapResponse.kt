package com.dimas.android.cryptoapp.data.entity

import com.google.gson.annotations.SerializedName

data class CryptoMapResponse(
    @SerializedName("data") val data : List<CryptoData>,
    @SerializedName("status") val status : StatusResponse
)