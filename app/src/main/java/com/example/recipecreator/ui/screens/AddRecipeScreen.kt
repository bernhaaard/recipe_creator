package com.example.recipecreator.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.recipecreator.R
import com.example.recipecreator.ui.uicomponents.AppTopBar
import com.example.recipecreator.ui.uicomponents.NavigationBar
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun AddRecipeScreen(navigator: DestinationsNavigator) {
    Scaffold(
        topBar = {
            AppTopBar(title = "Add Recipe")
        },
        bottomBar = {
            NavigationBar(navigator = navigator)
        },
        content = { padding ->
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
                AddRecipeImage()
                RecipeNameInput()
                IngredientsList()
                InstructionsList()
                Button(
                    onClick = { /*TODO*/ },
                    modifier =
                        Modifier
                            .width(320.dp),
                ) {
                    Text(text = "Save Recipe")
                }
            }
        },
    )
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
fun RecipeNameInput() {
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
        var recipeName = "placeholder (please change)"
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
            value = recipeName,
            onValueChange = { recipeName = it },
        )
    }
}

@Composable
fun NewIngredientItem() {
    var ingredient = "Add another ingredient"
    TextField(
        modifier =
            Modifier
                .padding(bottom = 16.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.5.dp))
                .border(
                    width = 1.dp,
                    color = Color(0xFF74CD66),
                    shape = RoundedCornerShape(size = 12.5.dp),
                ),
        value = ingredient,
        textStyle = TextStyle(Color(0xFF74CD66)),
        onValueChange = { ingredient = it },
    )
}

@Composable
fun IngredientItem() {
    Row(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
    ) {
        var quantity = "0"
        TextField(
            modifier =
                Modifier
                    .width(64.dp)
                    .clip(RoundedCornerShape(12.5.dp))
                    .border(
                        width = 1.dp,
                        color = Color.LightGray,
                        shape = RoundedCornerShape(size = 12.5.dp),
                    ),
            value = quantity,
            textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
            onValueChange = { quantity = it },
        )
        var ingredient = "Write your ingredient here..."

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
            value = ingredient,
            onValueChange = { ingredient = it },
        )
    }
}

@Composable
fun IngredientsList() {
    Column(
        modifier =
            Modifier
                .padding(bottom = 16.dp),
    ) {
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
                                .width(20.dp)
                                .height(20.dp),
                        painter = painterResource(id = R.drawable.iconuser),
                        contentDescription = "image description",
                        contentScale = ContentScale.FillBounds,
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    Text(text = "Time")
                    Spacer(modifier = Modifier.width(8.dp))
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
        IngredientItem()
        IngredientItem()
        IngredientItem()
        NewIngredientItem()
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
            InstructionStep()
            InstructionStep()
        }
    }
}

@Composable
fun AddRecipeView() {
    Column(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(0.dp),
        Arrangement.Center,
        Alignment.CenterHorizontally,
    ) {
        Column(
            modifier =
                Modifier
                    .padding(16.dp)
                    .width(320.dp),
        ) {
            // Instruction header and Text-fields

            // Box with Instruction steps
            Column(
                modifier =
                    Modifier
                        .wrapContentHeight()
                        .width(320.dp)
                        .padding(bottom = 0.dp)
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
                InstructionStep()
                InstructionStep()
            }

            // Add Another ingredient TextField for Instruction
            var text6 = "Add another ingredient"
            TextField(
                modifier =
                    Modifier
                        .padding(top = 10.dp)
                        .width(320.dp)
                        .clip(RoundedCornerShape(12.5.dp))
                        .border(
                            width = 1.dp,
                            color = Color(0xFF74CD66),
                            shape = RoundedCornerShape(size = 12.5.dp),
                        ),
                value = text6,
                textStyle = TextStyle(Color(0xFF74CD66)),
                onValueChange = { text6 = it },
            )

            Spacer(modifier = Modifier.padding(20.dp))

            // Button to save the Recipe
        }
    }
}

// Composable for Steps + Textfield
@Composable
fun InstructionStep() {
    // A Text with "steps" and a Textfield inside a column
    Column(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(16.dp),
    ) {
        Text(
            text = "Step 1",
            modifier =
                Modifier
                    .padding(),
            Color(0xFF74CD66),
        )

        var instruction = "Start writing here!"
        TextField(
            modifier =
                Modifier
                    .width(270.dp)
                    .padding()
                    .clip(RoundedCornerShape(12.5.dp))
                    .border(
                        width = 1.dp,
                        color = Color.LightGray,
                        shape = RoundedCornerShape(size = 12.5.dp),
                    ),
            value = instruction,
            onValueChange = { instruction = it },
        )
    }
}
