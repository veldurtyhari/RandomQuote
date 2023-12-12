package com.haresh.schools.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.haresh.schools.models.School

@Dao
interface QuoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addSchool(quotes: List<School>)

    @Query("SELECT * FROM school")
    suspend fun getSchool() : List<School>
}