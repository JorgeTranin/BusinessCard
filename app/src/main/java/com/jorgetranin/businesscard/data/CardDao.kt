package com.jorgetranin.businesscard.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CardDao {

    @Query("SELECT * FROM Card")
    fun getAll(): LiveData<List<Card>>

    @Insert
    suspend fun insert(card: Card)

    @Delete
    fun delete(user: Card)

}