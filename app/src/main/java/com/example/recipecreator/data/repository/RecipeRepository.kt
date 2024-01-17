package com.example.recipecreator.data.repository

import com.example.recipecreator.data.local.dao.RecipeDao
import com.example.recipecreator.model.Recipe
import kotlinx.coroutines.flow.Flow

class RecipeRepository(private val recipeDao: RecipeDao) {
    // Get all recipes from the database
    fun getAllRecipes(): Flow<List<Recipe>> = recipeDao.getAllRecipes()

    // Get a single recipe by its ID
    suspend fun getRecipeById(recipeId: Long): Recipe? = recipeDao.getRecipeById(recipeId)

    // Insert a new recipe into the database
    suspend fun insertRecipe(recipe: Recipe) {
        recipeDao.insertRecipe(recipe)
    }

    // Update an existing recipe in the database
    suspend fun updateRecipe(recipe: Recipe) {
        recipeDao.updateRecipe(recipe)
    }

    // Delete a recipe from the database
    suspend fun deleteRecipe(recipe: Recipe) {
        recipeDao.deleteRecipe(recipe)
    }
}
