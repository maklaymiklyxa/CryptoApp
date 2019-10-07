package com.dimas.android.cryptoapp.data.entity

import com.google.gson.annotations.SerializedName

data class StatusResponse (
    @SerializedName("timestamp") val timestamp : String,
    @SerializedName("error_code") val error_code : Int,
    @SerializedName("error_message") val error_message : String,
    @SerializedName("elapsed") val elapsed : Int,
    @SerializedName("credit_count") val credit_count : Int
)