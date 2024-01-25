package com.example.recipecreator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.recipecreator.data.local.AppDatabase
import com.example.recipecreator.data.repository.RecipeRepository
import com.example.recipecreator.ui.screens.NavGraphs
import com.example.recipecreator.ui.theme.RecipeWizardTheme
import com.example.recipecreator.ui.viewmodels.AddRecipeViewModel
import com.ramcosta.composedestinations.DestinationsNavHost

class MainActivity : ComponentActivity() {
    private val db by lazy {
        Room.databaseBuilder(this, AppDatabase::class.java, "database.db").build()
    }
    private val addRecipeViewModel by viewModels<AddRecipeViewModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return AddRecipeViewModel(RecipeRepository(db.recipeDao())) as T
                }
            }
        },
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecipeWizardTheme {
                DestinationsNavHost(navGraph = NavGraphs.root)
            }
        }
    }
}

// Logo Composable works
@Composable
fun LogoImage() {
    val image: Painter = painterResource(id = R.drawable.finallogo)
    Image(
        modifier =
            Modifier
                .padding(30.dp),
        painter = image,
        contentDescription = "",
    )
}
