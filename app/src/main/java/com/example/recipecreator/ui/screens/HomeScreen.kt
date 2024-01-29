package com.example.recipecreator.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.recipecreator.ui.uicomponents.AppTopBar
import com.example.recipecreator.ui.uicomponents.BottomNavigationBar
import com.example.recipecreator.ui.uicomponents.Screen
import com.example.recipecreator.ui.viewmodels.RecipeViewModel

@Composable
fun HomeScreen(
    recipeViewModel: RecipeViewModel,
    navController: NavController,
) {
    Scaffold(
        topBar = {
            AppTopBar(title = "Home", iconName = Icons.Filled.Home, contentDescription = "Home")
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
        Column(modifier = Modifier.padding(innerPadding)) {
            Text(text = "Home Screen")
        }
    }
}
