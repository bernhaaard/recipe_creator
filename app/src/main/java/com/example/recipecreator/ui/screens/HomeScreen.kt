package com.example.recipecreator.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.recipecreator.ui.uicomponents.AppTopBar
import com.example.recipecreator.ui.viewmodels.RecipeViewModel

@Composable
fun HomeScreen(recipeViewModel: RecipeViewModel) {
    Scaffold(
        topBar = {
            AppTopBar(title = "Home", iconName = Icons.Filled.Home, contentDescription = "Home")
        },
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text(text = "Home Screen")
        }
    }
}
