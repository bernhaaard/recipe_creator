package com.example.recipecreator.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.recipecreator.ui.viewmodels.RecipeViewModel

@Composable
fun EditRecipeScreen(
    recipeViewModel: RecipeViewModel,
    navController: NavHostController,
) {
    // Home Screen Composable
    Column {
        Text(text = "Home Screen")
    }
}
