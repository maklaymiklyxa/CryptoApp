package com.dimas.android.cryptoapp.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CryptoData")
class CryptoData(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "crypto_id") val crypto_id: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "price_in_usd") val price: Double?
) {
    companion object {
//        fun getCryptoData(repository:): CryptoData {
//            return CryptoData(
//                crypto_id = repository.id,
//                name = repository.name;
//            )
//        }
    }

}