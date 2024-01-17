package com.example.recipecreator.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    // Assuming a unique string ID (like Firebase Auth ID)
    @PrimaryKey val userId: String,
    val name: String,
    val email: String,
)
