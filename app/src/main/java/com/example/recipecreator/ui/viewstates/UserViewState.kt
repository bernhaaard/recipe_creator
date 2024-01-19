package com.example.recipecreator.ui.viewstates

import com.example.recipecreator.model.User

data class UserViewState(
    val isLoading: Boolean = false,
    val userInfo: User? = null,
    val errorMessage: String? = null
)