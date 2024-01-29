package com.example.recipecreator.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Book
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.recipecreator.ui.uicomponents.AppTopBar
import com.example.recipecreator.ui.uicomponents.BottomNavigationBar
import com.example.recipecreator.ui.uicomponents.RecipeCard
import com.example.recipecreator.ui.uicomponents.Screen
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
            val state = recipeViewModel.recipeViewState.collectAsState()
            BottomNavigationBar(
                navController = navController,
                selectedScreen = state.value.selectedScreen,
            )
        },
        floatingActionButton = {
            LargeFloatingActionButton(
                onClick = { navController.navigate(Screen.AddRecipe.route) },
            ) {
                Icon(Icons.Filled.Add, "Floating action button")
            }
        },
    ) { innerPadding ->
        Column(
            modifier =
                Modifier
                    .padding(innerPadding)
                    .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            LaunchedEffect(key1 = Unit) {
                recipeViewModel.fetchAllRecipes()
            }
            val state = recipeViewModel.recipeViewState.collectAsState()
            state.value.recipes.forEachIndexed { index, recipe ->
                RecipeCard(navController, recipe)
            }
        }
    }
}
