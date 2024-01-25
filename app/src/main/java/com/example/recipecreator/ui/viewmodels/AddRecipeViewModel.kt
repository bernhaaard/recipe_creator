package com.example.recipecreator.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipecreator.data.repository.RecipeRepository
import com.example.recipecreator.model.Recipe
import com.example.recipecreator.ui.viewstates.AddRecipeViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AddRecipeViewModel(private val recipeRepository: RecipeRepository) : ViewModel() {
    // StateFlow to hold the current state of recipe operations
    private val _addRecipeViewState = MutableStateFlow(AddRecipeViewState())
    val addRecipeViewState = _addRecipeViewState.asStateFlow()

    // Insert a new recipe
    fun insertRecipe(recipe: Recipe) {
        viewModelScope.launch {
            _addRecipeViewState.value = _addRecipeViewState.value.copy(isSubmitting = true)
            recipeRepository.insertRecipe(recipe)
            _addRecipeViewState.value = _addRecipeViewState.value.copy(isSubmitting = false)
        }
    }
}
