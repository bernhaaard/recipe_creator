package com.example.recipecreator.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipes")
data class Recipe(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val ingredients: List<String>,
    val instructions: String,
    val favorite: Boolean = false,
)
