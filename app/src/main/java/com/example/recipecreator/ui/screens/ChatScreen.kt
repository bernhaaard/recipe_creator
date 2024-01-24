package com.example.recipecreator.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.recipecreator.R

@Composable
fun ChatScreen() {
    // Chat Screen Composable
}

@Composable
fun AIAssistantChatBoxWithIcon() {
    // Cookie image with Cookie Text
    Box {
        Row(
            modifier =
                Modifier
                    .zIndex(4f),
        ) {
            val image: Painter = painterResource(id = R.drawable.cookie)
            Image(
                modifier =
                    Modifier
                        .padding(top = 10.dp, start = 15.dp)
                        .width(45.dp)
                        .height(45.dp)
                        .background(Color.White)
                        .border(
                            width = 1.5.dp,
                            color = Color.Green,
                            shape = RoundedCornerShape((12.5.dp)),
                        ),
                painter = image,
                contentDescription = "",
            )
            Text(
                modifier = Modifier.padding(start = 5.dp, top = 8.dp),
                text = "Cookie",
                color = Color.Green,
            )
        }

        // Box with Text
        Box(
            modifier =
                Modifier
                    .padding(30.dp),
        ) {
            Box(
                modifier =
                    Modifier
                        .wrapContentHeight()
                        .width(285.dp)
                        .shadow(
                            elevation = 10.dp,
                            spotColor = Color.Black,
                            ambientColor = Color.Black,
                            clip = true,
                        )
                        .border(
                            width = 1.5.dp,
                            color = Color.Green,
                            shape = RoundedCornerShape((12.5.dp)),
                        )
                        .background(color = Color.White, shape = RoundedCornerShape(15.dp))
                        .padding(start = 40.dp, top = 10.dp, end = 20.dp, bottom = 10.dp)
                        .zIndex(2f),
            ) {
                Text(
                    modifier =
                        Modifier
                            .width(240.dp),
                    text = ("Hello, how can i help you?"),
                )
            }
        }
    }
}

@Composable
fun AIAssistantChatBox() {
    Box(
        modifier =
            Modifier
                .padding(30.dp),
    ) {
        Box(
            modifier =
                Modifier
                    .wrapContentHeight()
                    .width(285.dp)
                    .shadow(elevation = 10.dp, spotColor = Color.Black, ambientColor = Color.Black)
                    .border(
                        width = 1.5.dp,
                        color = Color.Green,
                        shape = RoundedCornerShape((12.5.dp)),
                    )
                    .background(color = Color.White, shape = RoundedCornerShape(12.5.dp))
                    .padding(start = 40.dp, top = 10.dp, end = 20.dp, bottom = 10.dp)
                    .zIndex(2f),
        ) {
            Text(
                modifier =
                    Modifier
                        .width(240.dp),
                text = ("Hello, how can i help you?"),
            )
        }
    }
}

@Composable
fun UserChatBoxWithIcon() {
    // Cookie image with Cookie Text
    Box {
        Row(
            modifier =
                Modifier
                    .zIndex(4f)
                    .padding(start = 270.dp),
        ) {
            Text(
                modifier = Modifier.padding(start = 10.dp, top = 8.dp),
                text = "Cathy",
                color = Color.Green,
            )
            val image: Painter = painterResource(id = R.drawable.cat)
            Image(
                modifier =
                    Modifier
                        .padding(top = 10.dp, start = 8.dp)
                        .width(45.dp)
                        .height(45.dp)
                        .background(Color.White)
                        .border(
                            width = 1.5.dp,
                            color = Color.Green,
                            shape = RoundedCornerShape((12.5.dp)),
                        ),
                painter = image,
                contentDescription = "",
            )
        }

        // Box with Text
        Box(
            modifier =
                Modifier
                    .padding(start = 80.dp, top = 30.dp, bottom = 30.dp, end = 30.dp),
        ) {
            Box(
                modifier =
                    Modifier
                        .wrapContentHeight()
                        .width(295.dp)
                        .shadow(
                            elevation = 10.dp,
                            spotColor = Color.Black,
                            ambientColor = Color.Black,
                            clip = true,
                        )
                        .border(
                            width = 1.5.dp,
                            color = Color.Green,
                            shape = RoundedCornerShape((12.5.dp)),
                        )
                        .background(color = Color.White, shape = RoundedCornerShape(15.dp))
                        .padding(start = 40.dp, top = 10.dp, bottom = 10.dp)
                        .zIndex(2f),
            ) {
                Text(
                    modifier =
                        Modifier
                            .width(205.dp)
                            .padding(end = 0.dp),
                    text = ("iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"),
                )
            }
        }
    }
}

@Composable
fun UserChatBox() {
    // Box with Text
    Box(
        modifier =
            Modifier
                .padding(start = 80.dp, top = 30.dp, bottom = 30.dp, end = 30.dp),
    ) {
        Box(
            modifier =
                Modifier
                    .wrapContentHeight()
                    .width(295.dp)
                    .shadow(
                        elevation = 10.dp,
                        spotColor = Color.Black,
                        ambientColor = Color.Black,
                        clip = true,
                    )
                    .border(
                        width = 1.5.dp,
                        color = Color.Green,
                        shape = RoundedCornerShape((12.5.dp)),
                    )
                    .background(color = Color.White, shape = RoundedCornerShape(15.dp))
                    .padding(start = 40.dp, top = 10.dp, bottom = 10.dp)
                    .zIndex(2f),
        ) {
            Text(
                modifier =
                    Modifier
                        .width(205.dp)
                        .padding(end = 0.dp),
                text = ("Well my cat stepped on my keyboard?"),
            )
        }
    }
}
