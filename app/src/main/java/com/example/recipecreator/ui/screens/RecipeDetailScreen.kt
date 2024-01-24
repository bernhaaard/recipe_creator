package com.example.recipecreator.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun RecipeDetailScreen(navigator: DestinationsNavigator) {
    // Recipe Detail Screen Composable
    Text(text = "Recipe Detail Screen")
}
