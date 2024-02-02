package com.example.recipecreator.ui.screens

import GreyBackground
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.recipecreator.R
import com.example.recipecreator.model.Instruction
import com.example.recipecreator.model.Recipe
import com.example.recipecreator.ui.uicomponents.AppTopBar
import com.example.recipecreator.ui.uicomponents.Screen
import com.example.recipecreator.ui.viewmodels.RecipeViewModel

@Composable
fun RecipeDetailScreen(
    recipeViewModel: RecipeViewModel,
    navController: NavController,
    recipe: Recipe,
) {
    // Recipe Detail Screen Composable
    Scaffold(
        topBar = {
            AppTopBar(
                title = "Details",
                iconName = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back Button",
                onBackClick = { navController.popBackStack() },
            )
        },
        content = { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)) {
                DetailScreen(recipeViewModel, navController, recipe)
            }
        },
    )
}

// This is just the template for the Ad recipe function, everything is hardcoded right now,

@Composable
fun DetailScreen(
    recipeViewModel: RecipeViewModel,
    navController: NavController,
    recipe: Recipe,
) {
    Box(
        modifier =
            Modifier
                .background(GreyBackground)
                .fillMaxWidth()
                .fillMaxHeight(),
    ) {
        val scrollState = rememberScrollState()
        Column(
            modifier =
                Modifier
                    .verticalScroll(state = scrollState)
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(start = 22.dp, end = 22.dp),
        ) {
            Column(
                modifier = Modifier.padding(0.dp),
                Arrangement.Center,
                Alignment.CenterHorizontally,
            ) {
//
                DisplayPictureAndRecipeName(recipe.title)

// Ingredients Header and textfields
                Column(
                    modifier =
                        Modifier
                            .padding(bottom = 12.dp),
                ) {
                    // Ingredients Text and icons start here
                    Row {
                        Text(
                            text = "Ingredients",
                            modifier =
                                Modifier
                                    .padding(bottom = 8.dp),
                            Color(0xFF74CD66),
                        )
                        Box(modifier = Modifier.padding(0.dp)) {
                            // Row for the "4Users" and "Time"
                            Row(
                                modifier =
                                    Modifier
                                        .padding(0.dp)
                                        .fillMaxWidth(),
                                Arrangement.End,
                            ) {
                                Text(text = "4")
                                Image(
                                    modifier =
                                        Modifier
                                            .clip(RoundedCornerShape(12.5.dp))
                                            .width(20.dp)
                                            .height(20.dp),
                                    painter = painterResource(id = R.drawable.iconuser),
                                    contentDescription = "image description",
                                    contentScale = ContentScale.FillBounds,
                                )
                                Spacer(modifier = Modifier.width(20.dp))

                                Text(text = "Time")
                                Image(
                                    modifier =
                                        Modifier
                                            .width(20.dp)
                                            .height(20.dp),
                                    painter = painterResource(id = R.drawable.iconclock),
                                    contentDescription = "image description",
                                    contentScale = ContentScale.FillBounds,
                                )
                            }
                        }
                    }

// Composables to add ingredients - located underneath this composable
                    recipe.ingredients.forEachIndexed { index, ingredient ->
                        DisplayIngredient(ingredient.quantity, ingredient.name)
                    }
                    // Instruction header and Textfields

                    Text(
                        text = "Instructions",
                        modifier =
                            Modifier
                                .clip(RoundedCornerShape(12.5.dp))
                                .fillMaxWidth()
                                .padding(bottom = 8.dp, top = 20.dp),
                        Color(0xFF74CD66),
                    )

                    // Box with Instruction steps
                    Column(
                        modifier =
                            Modifier
                                .wrapContentHeight()
                                .fillMaxWidth()
                                .padding(bottom = 0.dp)
                                .clip(shape = RoundedCornerShape(12.5.dp))
                                .background(Color.White)
                                .border(
                                    width = 1.dp,
                                    color = Color(0xFF74CD66),
                                    shape = RoundedCornerShape(size = 12.5.dp),
                                ),
                        Arrangement.Center,
                        Alignment.CenterHorizontally,
                    ) {
// Add a Composable named InstructionSteps (located below this Composable)
                        recipe.instructions.forEachIndexed { index, instruction ->
                            DisplayInstruction(instruction)
                        }
                    }

                    Spacer(modifier = Modifier.padding(20.dp))

                    // Button to save the Recipe
                    Button(
                        onClick = { navController.navigate(Screen.EditRecipe.route) },
                        modifier =
                            Modifier
                                .fillMaxWidth(),
                    ) {
                        Text(text = "Edit Recipe")
                    }

                    DeleteButton(recipeViewModel, navController, recipe)
                }
            }
        }
    }
}

@Composable
fun DisplayPictureAndRecipeName(recipeName: String) {
// "Recipe" header with the recipeName Textfield
    Column(
        modifier =
            Modifier
                .padding(top = 20.dp, bottom = 25.dp)
                .fillMaxWidth(),
    ) {
        Text(
            text = "Recipe name",
            modifier =
                Modifier
                    .padding(bottom = 10.dp),
            Color(0xFF74CD66),
        )

        // RecipeNameField
        Box(
            modifier =
                Modifier
                    .padding(0.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.5.dp))
                    .background(Color.White)
                    .border(
                        width = 1.dp,
                        color = Color.LightGray,
                        shape = RoundedCornerShape(size = 12.5.dp),
                    ),
        ) {
            Text(
                modifier = Modifier.padding(15.dp),
                text = recipeName,
            )
        }
    }
}

// Composable to show Ingredients
@Composable
fun DisplayIngredient(
    quantity: String,
    ingredient: String,
) {
    Row(
        modifier =
            Modifier
                .fillMaxWidth(),
    ) {
        // InstructionAmountTextField
        Box(
            modifier =
                Modifier
                    .padding(end = 0.dp)
                    .width(70.dp)
                    .clip(RoundedCornerShape(12.5.dp))
                    .background(Color.White)
                    .border(
                        width = 1.dp,
                        color = Color.LightGray,
                        shape = RoundedCornerShape(size = 12.5.dp),
                    ),
        ) {
            Text(
                modifier = Modifier.padding(15.dp),
                text = quantity,
            )
        }

        // InstructionStepTextField
        Box(
            modifier =
                Modifier
                    .padding(start = 6.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.White)
                    .border(
                        width = 1.dp,
                        color = Color.LightGray,
                        shape = RoundedCornerShape(size = 12.5.dp),
                    ),
        ) {
            Text(
                modifier = Modifier.padding(15.dp),
                text = ingredient,
            )
        }
    }
}

// Composable for Steps + Textfield
@Composable
fun DisplayInstruction(instruction: Instruction) {
    // A Text with "steps" and a Textfield inside a column
    Column(
        modifier =
            Modifier
                .clip(RoundedCornerShape(12.5.dp))
                .padding(start = 15.dp, top = 5.dp, bottom = 10.dp, end = 15.dp)
                .fillMaxWidth(),
    ) {
        // add function to Display steps continuously
        Text(
            text = "Step ${instruction.stepNumber}",
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, bottom = 8.dp, top = 8.dp),
            Color(0xFF74CD66),
        )

        // InstructionStepTextField
        Box(
            modifier =
                Modifier
                    .padding(bottom = 10.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.5.dp))
                    .border(
                        width = 1.dp,
                        color = Color.LightGray,
                        shape = RoundedCornerShape(size = 12.5.dp),
                    ),
        ) {
            Text(
                modifier =
                    Modifier
                        .padding(15.dp),
                text = instruction.instruction,
            )
        }
    }
}

@Composable
fun DeleteButton(
    recipeViewModel: RecipeViewModel,
    navController: NavController,
    recipe: Recipe,
) {
    Button(
        modifier =
            Modifier
                .fillMaxWidth(),
        colors =
            ButtonDefaults.buttonColors(
                // Example purple color
                containerColor = Color(0xFFD00A0A),
                // Text/icon color inside the button
                contentColor = Color.White,
            ),
        onClick = {
            recipeViewModel.deleteRecipe(recipe)
            navController.popBackStack()
        },
    ) {
        Text(text = "Delete Recipe")
    }
}
