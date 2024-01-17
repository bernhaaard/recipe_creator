package com.example.recipecreator.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.recipecreator.data.local.dao.RecipeDao
import com.example.recipecreator.data.local.dao.UserDao
import com.example.recipecreator.model.Recipe
import com.example.recipecreator.model.User

@Database(entities = [Recipe::class, User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun recipeDao(): RecipeDao

    abstract fun userDao(): UserDao

    // Singleton pattern for creating the instance would be added here
}
