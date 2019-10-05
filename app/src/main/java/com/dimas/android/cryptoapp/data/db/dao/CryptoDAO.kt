package com.dimas.android.cryptoapp.data.db.dao

import androidx.paging.DataSource
import androidx.room.*
import com.dimas.android.cryptoapp.data.db.entity.CryptoData

@Dao
interface CryptoDAO {
    @Query("SELECT * FROM CryptoData ORDER BY crypto_id")
    fun findAll(): DataSource.Factory<Int, CryptoData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(bookmark: CryptoData)

    @Delete
    fun delete(bookmark: CryptoData)

}