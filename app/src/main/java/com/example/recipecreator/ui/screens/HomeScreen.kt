package com.example.recipecreator.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Chat
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.recipecreator.R
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
            AppTopBar(title = "Chat", iconName = Icons.AutoMirrored.Filled.Chat, contentDescription = "Chat")
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
                    .padding(8.dp)
                    .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text = stringResource(R.string.Chat_info_message))
        }
    }
}
