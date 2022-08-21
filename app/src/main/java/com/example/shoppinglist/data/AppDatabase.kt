package com.example.shoppinglist.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Item::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract val itemDao: ItemDao

    companion object {
        @Volatile
        private var INSTANCE: ItemDao? = null

        fun getDaoInstance(context: Context): ItemDao {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = buildDatabase(context).itemDao
                    INSTANCE = instance
                }
                return instance
            }
        }

        private fun buildDatabase(context: Context): AppDatabase =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "news-database")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
    }
}