package com.example.recipecreator.ui.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.recipecreator.model.Ingredient
import com.example.recipecreator.model.Recipe
import com.example.recipecreator.ui.uicomponents.AppTopBar
import com.example.recipecreator.ui.viewmodels.RecipeViewModel

@Composable
fun AddRecipeScreen(
    recipeViewModel: RecipeViewModel,
    navController: NavController,
) {
    Scaffold(
        topBar = {
            AppTopBar(
                title = "Add Recipe",
                iconName = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back Button",
                onBackClick = { navController.popBackStack() },
            )
        },
    ) { padding ->
        val scrollState = rememberScrollState()
        Column(
            modifier =
                Modifier
                    .verticalScroll(state = scrollState)
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(padding)
                    .padding(32.dp),
            Arrangement.Center,
            Alignment.CenterHorizontally,
        ) {
            val title = remember { mutableStateOf("") }
            val ingredients = remember { mutableStateListOf(Ingredient("", "")) }
            val instructions by remember { mutableStateOf("") }
            AddRecipeImage()
            RecipeNameInput(title)
            IngredientsList(ingredients)
            InstructionsList()
            Button(
                onClick = {
                    recipeViewModel.insertRecipe(
                        Recipe(title = title.value, ingredients = ingredients, instructions = instructions, favorite = false),
                    )
                },
                modifier =
                    Modifier
                        .width(320.dp),
            ) {
                Text(text = "Save Recipe")
            }
        }
    }
}

@Composable
fun AddRecipeImage() {
    Box(
        modifier =
            Modifier
                .padding(bottom = 16.dp)
                .fillMaxWidth()
                .height(180.dp)
                .border(
                    width = 1.dp,
                    color = Color.LightGray,
                    shape = RoundedCornerShape(size = 12.5.dp),
                ),
        Alignment.Center,
    ) {
        Text(text = "Add Picture")
    }
}

@Composable
fun RecipeNameInput(title: MutableState<String>) {
    Column(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
    ) {
        Text(
            text = "Recipe name",
            modifier =
                Modifier
                    .padding(0.dp),
            Color(0xFF74CD66),
        )

        TextField(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.5.dp))
                    .border(
                        width = 1.dp,
                        color = Color.LightGray,
                        shape = RoundedCornerShape(size = 12.5.dp),
                    ),
            value = title.value,
            onValueChange = { newTitle -> title.value = newTitle },
            label = { Text(text = "Recipe name") },
        )
    }
}

@Composable
fun IngredientsList(ingredients: MutableList<Ingredient>) {
    Column {
        Text(
            text = "Ingredients",
            modifier =
                Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth(),
            Color(0xFF74CD66),
        )
    }
    ingredients.forEachIndexed { index, ingredient ->
        val quantityState = remember { mutableStateOf(ingredient.quantity) }
        val nameState = remember { mutableStateOf(ingredient.name) }

        IngredientItem(
            quantity = quantityState.value,
            name = nameState.value,
            onQuantityChange = { newQuantity ->
                quantityState.value = newQuantity
                ingredients[index] = ingredients[index].copy(quantity = newQuantity)
            },
            onNameChange = { newName ->
                nameState.value = newName
                ingredients[index] = ingredients[index].copy(name = newName)
            },
        )
    }
    NewIngredientButton(ingredients = ingredients)
}

@Composable
fun IngredientItem(
    quantity: String,
    name: String,
    onNameChange: (String) -> Unit,
    onQuantityChange: (String) -> Unit,
) {
    Row(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
    ) {
        TextField(
            modifier =
                Modifier
                    .width(72.dp)
                    .clip(RoundedCornerShape(12.5.dp))
                    .border(
                        width = 1.dp,
                        color = Color.LightGray,
                        shape = RoundedCornerShape(size = 12.5.dp),
                    ),
            value = quantity,
            textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
            onValueChange = onQuantityChange,
        )

        TextField(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp)
                    .clip(RoundedCornerShape(12.5.dp))
                    .border(
                        width = 1.dp,
                        color = Color.LightGray,
                        shape = RoundedCornerShape(size = 12.5.dp),
                    ),
            value = name,
            onValueChange = onNameChange,
        )
    }
}

@Composable
fun NewIngredientButton(ingredients: MutableList<Ingredient>) {
    Button(
        modifier =
            Modifier
                .padding(bottom = 16.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.5.dp)),
        onClick = { ingredients.add(Ingredient("", "")) },
    ) {
        Text("Add New Ingredient")
    }
}

@Composable
fun InstructionsList() {
    Column(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
    ) {
        Text(
            text = "Instructions",
            modifier =
                Modifier
                    .padding(bottom = 8.dp),
            Color(0xFF74CD66),
        )
        Column(
            modifier =
                Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .padding(bottom = 0.dp)
                    .border(
                        width = 1.dp,
                        color = Color(0xFF74CD66),
                        shape = RoundedCornerShape(size = 12.5.dp),
                    ),
            Arrangement.Center,
            Alignment.CenterHorizontally,
        ) {
            // Add a Composable named InstructionSteps (located below this Composable)
        }
    }
}

// Composable for Steps + Textfield
@Composable
fun InstructionStep(
    stepNumber: Number?,
    instruction: String,
    onValueChange: (String) -> Unit,
) {
    // A Text with "steps" and a Textfield inside a column
    Column(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(16.dp),
    ) {
        Text(
            text = "Step $stepNumber",
            modifier =
                Modifier
                    .padding(),
            Color(0xFF74CD66),
        )
        TextField(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding()
                    .clip(RoundedCornerShape(12.5.dp))
                    .border(
                        width = 1.dp,
                        color = Color.LightGray,
                        shape = RoundedCornerShape(size = 12.5.dp),
                    ),
            value = instruction,
            onValueChange = onValueChange,
        )
    }
}
