package com.example.recipecreator.ui.uicomponents

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.recipecreator.R
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





// Composable Recipe card for the library and the AI chat
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