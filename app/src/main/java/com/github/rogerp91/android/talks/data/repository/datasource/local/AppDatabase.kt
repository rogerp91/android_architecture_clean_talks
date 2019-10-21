package com.github.rogerp91.android.talks.data.repository.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.github.rogerp91.android.talks.data.entity.local.CategoryDatabase

/**
 * Created by rpatino on oct/2019
 */
@Database(entities = [CategoryDatabase::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        const val DB_NAME = "lightning_data.db"
    }

    abstract fun categoryDAO(): CategoryDao
}