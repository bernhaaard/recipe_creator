package com.example.recipecreator.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.recipecreator.ui.uicomponents.AppTopBar
import com.example.recipecreator.ui.uicomponents.BottomNavigationBar
import com.example.recipecreator.ui.uicomponents.RecipeCard
import com.example.recipecreator.ui.viewmodels.RecipeViewModel

@Composable
fun RecipeLibraryScreen(
    recipeViewModel: RecipeViewModel,
    navController: NavHostController,
) {
    Scaffold(
        topBar = {
            AppTopBar(
                title = "Library",
                iconName = Icons.Filled.Book,
                contentDescription = "Book Icon",
            )
        },
        bottomBar = {
            BottomNavigationBar(
                navController = navController,
                selectedScreen = recipeViewModel.recipeViewState.collectAsState().value.selectedScreen,
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
            verticalArrangement = Arrangement.Center,
        ) {
            RecipeCard(navController)
            RecipeCard(navController)
            RecipeCard(navController)
        }
    }
}
