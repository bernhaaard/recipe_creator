package com.example.recipecreator.ui.uicomponents

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import com.example.recipecreator.ui.screens.destinations.AddRecipeScreenDestination
import com.example.recipecreator.ui.screens.destinations.HomeScreenDestination
import com.example.recipecreator.ui.screens.destinations.RecipeLibraryScreenDestination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun NavigationBar(navigator: DestinationsNavigator) {
    NavigationBar {
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
            label = { Text("Home") },
            selected = true,
            onClick = {
                navigator.navigate(HomeScreenDestination())
            },
        )
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Favorite, contentDescription = "Library") },
            label = { Text("Library") },
            selected = false,
            onClick = {
                navigator.navigate(RecipeLibraryScreenDestination())
            },
        )
        NavigationBarItem(
            icon = { Icon(Icons.Filled.AccountCircle, contentDescription = "Add Recipe") },
            label = { Text("Add Recipe") },
            selected = false,
            onClick = {
                navigator.navigate(AddRecipeScreenDestination())
            },
        )
    }
}

// create a consistent TopBar and BottomBar for all screens in the app, we will define composable functions that can be reused across different screens
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    title: String,
    onBackClick: () -> Unit = {},
) {
    // TopBar Composable
    TopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            IconButton(onClick = { onBackClick() }) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back Button")
            }
        },
    )
}
