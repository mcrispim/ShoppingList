package com.example.shoppinglist.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Item(
    val name: String,
    var quantity: Int
) {
    @PrimaryKey(autoGenerate = true) val id = 0
}