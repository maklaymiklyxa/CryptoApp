package com.dimas.android.cryptoapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.dimas.android.cryptoapp.data.db.CryptoDB.Companion.DB_VERSION
import com.dimas.android.cryptoapp.data.db.dao.CryptoDAO
import com.dimas.android.cryptoapp.data.db.entity.CryptoData

@Database(
    entities = [CryptoData::class],
    version = DB_VERSION,
    exportSchema = false
)
abstract class CryptoDB : RoomDatabase() {
    abstract fun getCryptoDataDao(): CryptoDAO

    companion object {
        const val DB_VERSION = 1
        private const val DB_NAME = "crypto.db"

        @Volatile
        private var INSTANCE: CryptoDB? = null

        fun getInstance(context: Context): CryptoDB =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: build(context).also { INSTANCE = it }
            }

        private fun build(context: Context) =
            Room.databaseBuilder(context, CryptoDB::class.java, DB_NAME)
                .addMigrations(MIGRATION_1_TO_2)
                .build()

        private val MIGRATION_1_TO_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {

            }

        }
    }
}