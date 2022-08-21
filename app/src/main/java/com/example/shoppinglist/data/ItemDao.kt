package com.example.shoppinglist.data

import androidx.room.*

@Dao
interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertItem(item: Item)

    @Delete
    fun deleteItem(item: Item)

    @Update
    fun updateItem(item: Item)
}