package com.example.recipecreator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.recipecreator.ui.screens.NavGraphs
import com.example.recipecreator.ui.theme.RecipeWizardTheme
import com.ramcosta.composedestinations.DestinationsNavHost

@Suppress("ktlint:standard:function-naming")
class MainActivity : ComponentActivity() {
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
