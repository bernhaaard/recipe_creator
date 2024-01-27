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
import com.example.recipecreator.ui.viewmodels.RecipeViewModel
// This is just the template for the Ad recipe function, everything is hardcoded right now,

@Composable
fun AddRecipeScreen(viewModel: RecipeViewModel) {







    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .verticalScroll(state = scrollState)
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(20.dp),

        ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp),
            Arrangement.Center,
            Alignment.CenterHorizontally
        ) {


            // The big picture at top
            Box(
                modifier = Modifier
                    .padding(0.dp)
                    .width(320.dp)
                    .height(180.dp)
                    .border(
                        width = 1.dp,
                        color = Color.LightGray,
                        shape = RoundedCornerShape(size = 12.5.dp)
                    ),
                Alignment.Center,
            ) { Text(text = "Add Picture") }


// "Recipe" header with the recipeName Textfield
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .width(320.dp)
            ) {
                Text(
                    text = "Recipe name",
                    modifier = Modifier
                        .padding(0.dp),
                    Color(0xFF74CD66)
                )
                var text = "no Value implemented for this yet"
                TextField(
                    modifier = Modifier
                        .width(320.dp)
                        .clip(RoundedCornerShape(12.5.dp))
                        .border(
                            width = 1.dp,
                            color = Color.LightGray,
                            shape = RoundedCornerShape(size = 12.5.dp)
                        ),
                    value = "RecipeName",
                    onValueChange = { text = it },
                )
            }
// Ingredients Header and textfields
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .width(320.dp)
            ) {
                // Ingredients Text and icons start here
                Row {
                    Text(
                        text = "Ingredients",
                        modifier = Modifier
                            .padding(bottom = 8.dp),
                        Color(0xFF74CD66)
                    )
                    Box(modifier = Modifier.padding(0.dp))
                    {

                        // Row for the "4Users" and "Time"
                        Row(
                            modifier = Modifier
                                .padding(0.dp)
                                .fillMaxWidth(),
                            Arrangement.End
                        ) {
                            Text(text = "4")
                            Image(
                                modifier = Modifier
                                    .width(20.dp)
                                    .height(20.dp),
                                painter = painterResource(id = R.drawable.iconuser),
                                contentDescription = "image description",
                                contentScale = ContentScale.FillBounds
                            )
                            Spacer(modifier = Modifier.width(20.dp))



                            Text(text = "Time")
                            Image(
                                modifier = Modifier
                                    .width(20.dp)
                                    .height(20.dp),
                                painter = painterResource(id = R.drawable.iconclock),
                                contentDescription = "image description",
                                contentScale = ContentScale.FillBounds
                            )
                        }
                    }
                }

// Composables to add ingredients - located underneath this composable
                AddIngredients()
                AddIngredients()
                AddIngredients()

// Add Another ingredient TextField
                var text4 = "Add another ingredient"
                TextField(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .width(320.dp)
                        .clip(RoundedCornerShape(12.5.dp))
                        .border(
                            width = 1.dp,
                            color = Color(0xFF74CD66),
                            shape = RoundedCornerShape(size = 12.5.dp)
                        ),
                    value = text4,
                    textStyle = TextStyle(Color(0xFF74CD66)),
                    onValueChange = { text4 = it },
                )


                // Instruction header and Textfields

                Text(
                    text = "Instructions",
                    modifier = Modifier
                        .padding(bottom = 8.dp, top = 20.dp),
                    Color(0xFF74CD66)
                )

                // Box with Instruction steps
                Column(
                    modifier = Modifier
                        .wrapContentHeight()
                        .width(320.dp)
                        .padding(bottom = 0.dp)
                        .background(Color.White)
                        .border(
                            width = 1.dp,
                            color = Color(0xFF74CD66),
                            shape = RoundedCornerShape(size = 12.5.dp)
                        ),
                    Arrangement.Center,
                    Alignment.CenterHorizontally
                )
                {
// Add a Composable named InstructionSteps (located below this Composable)
                    InstructionSteps()
                    InstructionSteps()


                }


                // Add Another ingredient TextField for Instruction
                var text6 = "Add another ingredient"
                TextField(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .width(320.dp)
                        .clip(RoundedCornerShape(12.5.dp))
                        .border(
                            width = 1.dp,
                            color = Color(0xFF74CD66),
                            shape = RoundedCornerShape(size = 12.5.dp)
                        ),
                    value = text6,
                    textStyle = TextStyle(Color(0xFF74CD66)),
                    onValueChange = { text6 = it },
                )

                Spacer(modifier = Modifier.padding(20.dp))

                // Button to save the Recipe
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .width(320.dp)
                ) {
                    Text(text = "Save Recipe")
                }


            }
        }
    }
}



// Composable to add another Ingredient
@Composable
fun AddIngredients() {

    // Text field with value "0" and Textfield with value "Write our ingredients here..." inside a row
    Row(
        modifier = Modifier.width(320.dp),
    ) {
        var text2 = "0"
        TextField(
            modifier = Modifier
                .padding(end = 5.dp)
                .width(66.dp)
                .clip(RoundedCornerShape(12.5.dp))
                .border(
                    width = 1.dp,
                    color = Color.LightGray,
                    shape = RoundedCornerShape(size = 12.5.dp)
                ),
            value = text2,
            textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
            onValueChange = { text2 = it },
        )
        var text3 = "Write your ingredient here..."

        TextField(
            modifier = Modifier
                .width(250.dp)
                .padding(start = 6.dp)
                .clip(RoundedCornerShape(12.5.dp))
                .border(
                    width = 1.dp,
                    color = Color.LightGray,
                    shape = RoundedCornerShape(size = 12.5.dp)
                ),
            value = text3,
            onValueChange = { text3 = it },
        )
    }
}





// Composable for Steps + Textfield
@Composable
fun InstructionSteps() {

    // A Text with "steps" and a Textfield inside a column
    Column(
        modifier = Modifier
            .width(270.dp)
    ) {
        Text(
            text = "Step 1",
            modifier = Modifier
                .padding(bottom = 8.dp, top = 20.dp),
            Color(0xFF74CD66)
        )

        var text6 = "Start writing here!"
        TextField(
            modifier = Modifier
                .width(270.dp)
                .padding(bottom = 10.dp)
                .clip(RoundedCornerShape(12.5.dp))
                .border(
                    width = 1.dp,
                    color = Color.LightGray,
                    shape = RoundedCornerShape(size = 12.5.dp)
                ),
            value = text6,
            onValueChange = { text6 = it },
        )
    }}
