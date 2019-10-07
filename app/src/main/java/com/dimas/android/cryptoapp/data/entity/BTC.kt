package com.dimas.android.cryptoapp.data.entity

import com.google.gson.annotations.SerializedName

data class BTC (

    @SerializedName("price") val price : Int,
    @SerializedName("volume_24h") val volume_24h : Int,
    @SerializedName("percent_change_1h") val percent_change_1h : Int,
    @SerializedName("percent_change_24h") val percent_change_24h : Int,
    @SerializedName("percent_change_7d") val percent_change_7d : Int,
    @SerializedName("market_cap") val market_cap : Int,
    @SerializedName("last_updated") val last_updated : String
)