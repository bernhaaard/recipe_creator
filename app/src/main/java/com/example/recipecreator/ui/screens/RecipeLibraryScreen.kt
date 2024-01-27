package com.example.recipecreator.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.recipecreator.ui.uicomponents.AppTopBar
import com.example.recipecreator.ui.uicomponents.RecipeCard

@Composable
fun RecipeLibraryScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            AppTopBar(title = "Library")
        },
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(40.dp)
            ) {
                Column(
                    modifier = Modifier.padding(0.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    RecipeCard(navController)
                    RecipeCard(navController)
                    RecipeCard(navController)


                }}

        }
    }
}

