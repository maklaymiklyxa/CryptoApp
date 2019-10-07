package com.dimas.android.cryptoapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "CryptoData")
class CryptoData(
    @PrimaryKey(autoGenerate = false) @ColumnInfo(name = "crypto_id") @SerializedName("id") val id: Int,
    @ColumnInfo(name = "name") @SerializedName("name") val name: String,
    @ColumnInfo(name = "symbol") @SerializedName("symbol") val symbol: String,
    @ColumnInfo(name = "sluge") @SerializedName("slug") val slug: String,
    @SerializedName("is_active") val is_active: Int?,
    @SerializedName("first_historical_data") val first_historical_data: String?,
    @SerializedName("last_historical_data") val last_historical_data: String?,
    @SerializedName("platform") val platform: String?
)