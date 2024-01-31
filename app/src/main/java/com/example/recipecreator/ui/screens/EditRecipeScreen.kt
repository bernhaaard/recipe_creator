package com.example.recipecreator.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.recipecreator.model.Ingredient
import com.example.recipecreator.model.Instruction
import com.example.recipecreator.model.Recipe
import com.example.recipecreator.ui.uicomponents.AppTopBar
import com.example.recipecreator.ui.uicomponents.Screen
import com.example.recipecreator.ui.viewmodels.RecipeViewModel

@Composable
fun EditRecipeScreen(
    recipeViewModel: RecipeViewModel,
    navController: NavHostController,
    recipe: Recipe,
) {
    Scaffold(
        topBar = {
            AppTopBar(
                title = "Edit Recipe",
                iconName = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back Button",
                onBackClick = { navController.popBackStack() },
            )
        },
    ) { padding ->
        val scrollState = rememberScrollState()
        val state = recipeViewModel.recipeViewState.collectAsState()
        Column(
            modifier =
            Modifier
                .verticalScroll(state = scrollState)
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(padding)
                .padding(22.dp),
            Arrangement.Center,
            Alignment.CenterHorizontally,
        ) {
            val id = recipe.id
            val title = remember { mutableStateOf("") }
            val ingredients = remember { mutableStateListOf(Ingredient("", "")) }
            val instructions = remember { mutableStateListOf(Instruction(1, "")) }

            title.value = recipe.title
            ingredients.clear()
            instructions.clear()
            recipe.ingredients.forEachIndexed { _, ingredient -> ingredients.add(ingredient) }
            recipe.instructions.forEachIndexed { _, instruction -> instructions.add(instruction) }

            RecipeNameInput(title)
            IngredientsList(ingredients)
            InstructionsList(instructions)
            Button(
                onClick = {
                    recipeViewModel.updateRecipe(
                        Recipe(id = id, title = title.value, ingredients = ingredients, instructions = instructions, favorite = false),
                    )
                    navController.navigate(Screen.Home.route)
                },
                modifier =
                Modifier
                    .width(320.dp),
            ) {
                Text(text = "Update Recipe")
            }
        }
    }
}