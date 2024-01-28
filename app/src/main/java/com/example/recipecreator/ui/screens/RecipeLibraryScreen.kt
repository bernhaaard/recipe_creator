package com.example.recipecreator.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.recipecreator.ui.uicomponents.AppTopBar
import com.example.recipecreator.ui.uicomponents.RecipeCard
import com.example.recipecreator.ui.viewmodels.RecipeViewModel

@Composable
fun RecipeLibraryScreen(recipeViewModel: RecipeViewModel,navController: NavHostController) {
    Scaffold(
        topBar = {
            AppTopBar(
                title = "Library",
                iconName = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back Button"
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
            verticalArrangement = Arrangement.Center
        ) {
            RecipeCard(navController)
            RecipeCard(navController)
            RecipeCard(navController)
        }
    }
}
