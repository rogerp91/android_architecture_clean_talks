package com.github.rogerp91.android.talks.data.repository.datasource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.github.rogerp91.android.talks.data.entity.local.CategoryDatabase

/**
 * Created by rpatino on oct/2019
 */
@Dao
interface CategoryDao {

    @Query("select * from CategoryDatabase")
    fun getCategories(): List<CategoryDatabase>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg categories: CategoryDatabase)
}