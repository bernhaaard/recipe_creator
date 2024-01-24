package com.example.recipecreator.ui.screens

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.recipecreator.ui.screens.destinations.RecipeDetailScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@RootNavGraph(start = true)
@Destination
@Composable
fun HomeScreen(navigator: DestinationsNavigator) {
    // Home Screen Composable
    Text(text = "Home Screen")
    Button(onClick = {
        navigator.navigate(RecipeDetailScreenDestination())
    }) {
        Text(text = "Recipes")
    }
}
