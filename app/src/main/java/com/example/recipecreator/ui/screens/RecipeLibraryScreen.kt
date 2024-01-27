package com.example.recipecreator.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.recipecreator.ui.uicomponents.AppTopBar
import com.example.recipecreator.ui.viewmodels.RecipeViewModel

@Composable
fun RecipeLibraryScreen(recipeViewModel: RecipeViewModel) {
    Scaffold(
        topBar = {
            AppTopBar(title = "Library", iconName = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back Button")
        },
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text(text = "Recipe Library Screen")
        }
    }
}
