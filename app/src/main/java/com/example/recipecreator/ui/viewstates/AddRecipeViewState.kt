package com.example.recipecreator.ui.viewstates

import com.example.recipecreator.model.Recipe

data class AddRecipeViewState(
    val recipe: Recipe? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val isEditing: Boolean = false,
    val isSubmitting: Boolean = false,
    val imageUrl: String? = null,
)
