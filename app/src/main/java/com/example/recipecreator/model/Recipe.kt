package com.example.recipecreator.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.recipecreator.data.local.Converters

@Entity(tableName = "recipes")
data class Recipe(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    @TypeConverters(Converters::class)
    val ingredients: List<Ingredient>,
    val instructions: String,
    val favorite: Boolean = false,
)
