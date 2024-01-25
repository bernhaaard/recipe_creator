package com.example.recipecreator.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.recipecreator.ui.uicomponents.AppTopBar

@Composable
fun RecipeLibraryScreen() {
    Scaffold(
        topBar = {
            AppTopBar(title = "Library")
        },
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text(text = "Recipe Library Screen")
        }
    }
}
