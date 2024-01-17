package com.example.recipecreator.data.repository

import com.example.recipecreator.data.local.dao.UserDao
import com.example.recipecreator.model.User
import kotlinx.coroutines.flow.Flow

class UserRepository(private val userDao: UserDao) {
    // Fetch a user by their ID
    fun getUserById(userId: String): Flow<User> = userDao.getUserById(userId)

    // Insert a new user into the database
    suspend fun insertUser(user: User) {
        userDao.insertUser(user)
    }

    // Update an existing user in the database
    suspend fun updateUser(user: User) {
        userDao.updateUser(user)
    }

    // Delete a user from the database
    suspend fun deleteUser(user: User) {
        userDao.deleteUser(user)
    }

    // Fetch all users from the database
    fun getAllUsers(): Flow<List<User>> = userDao.getAllUsers()
}
