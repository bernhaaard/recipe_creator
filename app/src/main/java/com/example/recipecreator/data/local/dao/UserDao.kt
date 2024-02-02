package com.example.recipecreator.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.recipecreator.model.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    // Insert a new user into the database
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    // Update an existing user in the database
    @Update
    suspend fun updateUser(user: User)

    // Delete a user from the database
    @Delete
    suspend fun deleteUser(user: User)

    // Query for a single user by their ID
    @Query("SELECT * FROM users WHERE userId = :userId")
    fun getUserById(userId: String): Flow<User>

    // Query for all users in the database
    @Query("SELECT * FROM users")
    fun getAllUsers(): Flow<List<User>>
}
