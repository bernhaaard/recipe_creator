package com.example.recipecreator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DividerDefaults.color
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.recipecreator.ui.screens.HomeScreen
import com.example.recipecreator.ui.theme.Purple80
import com.example.recipecreator.ui.theme.RecipeWizardTheme

@Suppress("ktlint:standard:function-naming")
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecipeWizardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Purple80,
                ) {
                    HomeScreen()
                }
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
