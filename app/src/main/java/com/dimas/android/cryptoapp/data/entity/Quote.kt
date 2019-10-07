package com.dimas.android.cryptoapp.data.entity

import com.google.gson.annotations.SerializedName

data class Quote (

    @SerializedName("USD") val USD : USD,
    @SerializedName("BTC") val BTC : BTC
)