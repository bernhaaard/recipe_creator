package com.example.recipecreator.ui.viewstates

import com.example.recipecreator.model.Recipe
import com.example.recipecreator.ui.uicomponents.Screen

data class RecipeViewState(
    val recipes: List<Recipe> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val isEditing: Boolean = false,
    val isSubmitting: Boolean = false,
    val imageUrl: String? = null,
    val selectedScreen: Screen = Screen.Home,
)
