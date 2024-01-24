package com.example.recipecreator.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.recipecreator.R

@Composable
fun OnboardingScreen() {
    // Onboarding Screen Composable
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
    ) {
        Text(
            text = "Ask your Recipe Assistant!",
        )

        Box(
            modifier =
                Modifier
                    .fillMaxWidth(),
            Alignment.TopCenter,
        ) {
            val image: Painter = painterResource(id = R.drawable.cookie)
            Image(
                modifier =
                    Modifier
                        .background(Color.White)
                        .padding(30.dp),
                painter = image,
                contentDescription = "",
            )
        }

        Text(
            text = "This is Cookie, write him some ingredients you have at home or ask him about any recipe and he gives you recommendations!",
            modifier =
                Modifier
                    .width(260.dp),
        )

        Button(
            onClick = { /*TODO*/ },
            modifier =
                Modifier
                    .width(320.dp),
        ) {
            Text(text = "Continue")
        }
    }
}
