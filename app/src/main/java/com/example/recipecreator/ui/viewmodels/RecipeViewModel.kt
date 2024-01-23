package com.example.recipecreator.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipecreator.data.repository.RecipeRepository
import com.example.recipecreator.model.Recipe
import com.example.recipecreator.ui.viewstates.RecipeViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RecipeViewModel(private val recipeRepository: RecipeRepository) : ViewModel() {
    // StateFlow to hold the current state of recipe operations
    private val _recipeViewState = MutableStateFlow(RecipeViewState())
    val recipeViewState = _recipeViewState.asStateFlow()

    // Fetch all recipes
    fun fetchAllRecipes() {
        viewModelScope.launch {
            _recipeViewState.value = _recipeViewState.value.copy(isLoading = true)
            recipeRepository.getAllRecipes().collect { recipes ->
                _recipeViewState.value =
                    RecipeViewState(
                        isLoading = false,
                        recipes = recipes,
                    )
            }
        }
    }

    // Insert a new recipe
    fun insertRecipe(recipe: Recipe) {
        viewModelScope.launch {
            _recipeViewState.value = _recipeViewState.value.copy(isSubmitting = true)
            recipeRepository.insertRecipe(recipe)
            _recipeViewState.value = _recipeViewState.value.copy(isSubmitting = false)
        }
    }

    // Update an existing recipe
    fun updateRecipe(recipe: Recipe) {
        viewModelScope.launch {
            _recipeViewState.value = _recipeViewState.value.copy(isSubmitting = true)
            recipeRepository.updateRecipe(recipe)
            _recipeViewState.value = _recipeViewState.value.copy(isSubmitting = false)
        }
    }

    // Delete a recipe
    fun deleteRecipe(recipe: Recipe) {
        viewModelScope.launch {
            recipeRepository.deleteRecipe(recipe)
            // Update state as needed after deletion
        }
    }
    // Additional logic and methods as required
}
