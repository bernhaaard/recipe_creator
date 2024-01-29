package com.example.recipecreator.ui.uicomponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.recipecreator.R
import com.example.recipecreator.model.Recipe
import com.example.recipecreator.ui.screens.AddRecipeScreen
import com.example.recipecreator.ui.screens.EditRecipeScreen
import com.example.recipecreator.ui.screens.HomeScreen
import com.example.recipecreator.ui.screens.RecipeDetailScreen
import com.example.recipecreator.ui.screens.RecipeLibraryScreen
import com.example.recipecreator.ui.viewmodels.RecipeViewModel

sealed class Screen(val route: String) {
    object Home : Screen("home")

    object RecipeLibrary : Screen("recipeLibrary")

    object AddRecipe : Screen("addRecipe")

    object RecipeDetail : Screen("recipeDetail")

    object EditRecipe : Screen("editRecipe")
}

@Composable
fun MainView(recipeViewModel: RecipeViewModel) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        modifier = Modifier.padding(),
        startDestination = Screen.Home.route,
    ) {
        composable(Screen.Home.route) {
            recipeViewModel.selectScreen(Screen.Home)
            HomeScreen(recipeViewModel, navController)
        }
        composable(Screen.RecipeLibrary.route) {
            recipeViewModel.selectScreen(Screen.RecipeLibrary)
            RecipeLibraryScreen(recipeViewModel, navController)
        }
        composable(Screen.AddRecipe.route) {
            recipeViewModel.selectScreen(Screen.AddRecipe)
            AddRecipeScreen(recipeViewModel, navController)
        }
        composable(Screen.RecipeDetail.route) {
            val currentRecipe = recipeViewModel.recipeViewState.collectAsState().value.currentRecipe
            if (currentRecipe != null) {
                recipeViewModel.selectScreen(Screen.RecipeDetail)
                RecipeDetailScreen(recipeViewModel, navController, recipe = currentRecipe)
            } else {
                navController.navigate(Screen.RecipeLibrary.route)
            }
        }
        composable(Screen.EditRecipe.route) {
            recipeViewModel.selectScreen(Screen.EditRecipe)
            EditRecipeScreen(recipeViewModel, navController)
        }
    }
}

@Composable
fun BottomNavigationBar(
    navController: NavController,
    selectedScreen: Screen,
) {
    NavigationBar(
        modifier =
            Modifier
                .background(MaterialTheme.colorScheme.primary)
                .height(96.dp),
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Filled.Home,
                    contentDescription = "Home",
                )
            },
            label = { Text("Home") },
            selected = selectedScreen == Screen.Home,
            onClick = {
                navController.navigate(Screen.Home.route)
            },
        )
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Filled.Book,
                    contentDescription = "Library",
                )
            },
            label = { Text("Library") },
            selected = selectedScreen == Screen.RecipeLibrary,
            onClick = {
                navController.navigate(Screen.RecipeLibrary.route)
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
    iconName: ImageVector,
    contentDescription: String,
) {
    // TopBar Composable
    TopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            IconButton(onClick = { onBackClick() }) {
                Icon(imageVector = iconName, contentDescription = contentDescription)
            }
        },
        modifier =
            Modifier
                .padding(bottom = 8.dp)
                .shadow(
                    elevation = 8.dp,
                ),
    )
}

// Composable Recipe card for the library and the AI chat
@Composable
fun RecipeCard(
    navController: NavController,
    recipe: Recipe,
    onClick: (Recipe) -> Unit,
) {
    // Main box
    Box(
        modifier =
            Modifier.clickable { onClick(recipe) },
    ) {
        Row(
            modifier =
                Modifier
                    .shadow(
                        elevation = 4.dp,
                        spotColor = Color(0x40000000),
                        ambientColor = Color(0x40000000),
                    )
                    .border(
                        width = 2.dp,
                        color = Color(0xFF74CD66),
                        shape = RoundedCornerShape(size = 10.dp),
                    )
                    .fillMaxWidth()
                    .height(110.dp)
                    .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 10.dp))
                    .padding(end = 13.dp),
            horizontalArrangement = Arrangement.spacedBy(17.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Row(
                modifier = Modifier.padding(5.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                // Big Picture
                Image(
                    modifier =
                        Modifier
                            .width(100.dp)
                            .height(100.dp),
                    painter = painterResource(id = R.drawable.chicken_and_potatoes),
                    contentDescription = "image description",
                    contentScale = ContentScale.FillBounds,
                )

                // Box next to the big picture
                Box(modifier = Modifier.padding(start = 5.dp)) {
                    // Column with three rows

                    Column(
                        modifier =
                            Modifier
                                .padding(0.dp)
                                .fillMaxHeight(),
                        verticalArrangement = Arrangement.SpaceBetween,
                    ) {
                        // Top row
                        Box(
                            modifier =
                                Modifier
                                    .padding(0.dp)
                                    .fillMaxWidth(),
                            Alignment.TopEnd,
                        ) {
                            Image(
                                modifier =
                                    Modifier
                                        .width(20.dp)
                                        .height(20.dp),
                                painter = painterResource(id = R.drawable.iconstar),
                                contentDescription = "image description",
                                contentScale = ContentScale.FillBounds,
                            )
                        }

                        // Middle text row
                        Box(modifier = Modifier.padding(0.dp)) {
                            Text(text = recipe.title)
                        }

                        // Bottom row
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

                            Text(text = "1:30")

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
            }
        }
    }
}
