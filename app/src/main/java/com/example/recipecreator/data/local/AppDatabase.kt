package com.example.recipecreator.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.recipecreator.data.local.dao.RecipeDao
import com.example.recipecreator.data.local.dao.UserDao
import com.example.recipecreator.model.Recipe
import com.example.recipecreator.model.User

@Database(entities = [Recipe::class, User::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun recipeDao(): RecipeDao

    abstract fun userDao(): UserDao

    companion object {
        @Suppress("ktlint:standard:property-naming")
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            // If the INSTANCE is not null, then return it,
            // if it is, then create the database.
            return INSTANCE ?: synchronized(this) {
                val instance =
                    Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "app_database",
                    ).build()
                INSTANCE = instance
                // Return instance
                instance
            }
        }
    }
}
