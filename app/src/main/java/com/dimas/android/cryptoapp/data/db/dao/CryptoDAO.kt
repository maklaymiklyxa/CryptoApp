package com.dimas.android.cryptoapp.data.db.dao

import androidx.room.*
import com.dimas.android.cryptoapp.data.entity.CryptoData
import io.reactivex.Single

@Dao
interface CryptoDAO {
    @Query("SELECT * FROM CryptoData ORDER BY crypto_id")
    fun getAllCryptoData(): Single<List<CryptoData>>

    @Query("SELECT * FROM CryptoData WHERE crypto_id LIKE :id")
    fun getCryptoData(id:Int): CryptoData

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllList(cryptoList: List<CryptoData>)

    @Delete
    fun delete(crypto: CryptoData)

    @Query("DELETE FROM CryptoData")
    fun deleteAllCryptoData()
}