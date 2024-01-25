package com.example.recipecreator.ui.screens

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text(text = "Add Recipe Screen")




        }
    }
}





// Composable Recipe card
@Composable
fun RecipeCard() {

    //Main box
    Box {

        Row(
            modifier = Modifier
                .shadow(
                    elevation = 4.dp,
                    spotColor = Color(0x40000000),
                    ambientColor = Color(0x40000000)
                )
                .border(
                    width = 2.dp,
                    color = Color(0xFF74CD66),
                    shape = RoundedCornerShape(size = 10.dp)
                )
                .width(319.dp)
                .height(110.dp)
                .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 10.dp))
                .padding(end = 13.dp),

            horizontalArrangement = Arrangement.spacedBy(17.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Row(
                modifier = Modifier.padding(5.dp), verticalAlignment = Alignment.CenterVertically
            ) {

                //Big Picture
                Image(
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp),
                    painter = painterResource(id = R.drawable.chicken_and_potatoes),
                    contentDescription = "image description",
                    contentScale = ContentScale.FillBounds
                )

                // Box next to the big picture
                Box(modifier = Modifier.padding(start = 5.dp)) {


                    // Column with three rows

                    Column(
                        modifier = Modifier
                            .padding(0.dp)
                            .fillMaxHeight(),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {

                        //Top row
                        Box(
                            modifier = Modifier
                                .padding(0.dp)
                                .fillMaxWidth(),
                            Alignment.TopEnd
                        ) {
                            Image(
                                modifier = Modifier
                                    .width(20.dp)
                                    .height(20.dp),
                                painter = painterResource(id = R.drawable.iconstar),
                                contentDescription = "image description",
                                contentScale = ContentScale.FillBounds
                            )
                        }

                        // Middle text row
                        Box(modifier = Modifier.padding(0.dp)) {
                            Text(text = "Text")
                        }

                        //Bottom row
                        Row(   modifier = Modifier
                            .padding(0.dp)
                            .fillMaxWidth(),
                            Arrangement.End) {
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

                            Text(text = "1:30")

                            Image(
                                modifier = Modifier
                                    .width(20.dp)
                                    .height(20.dp),
                                painter = painterResource(id = R.drawable.iconclock),
                                contentDescription = "image description",
                                contentScale = ContentScale.FillBounds)
                        }


                    }
                }
            }
        }
    }
}
