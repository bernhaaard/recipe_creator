package com.example.recipecreator.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme =
    darkColorScheme(
        primary = Color(0xFFA98274),
        onPrimary = Color(0xFF795548),
        primaryContainer = Color(0xFFD3B8AE),
        secondary = Color(0xFF8BC34A),
        onSecondary = Color(0xFF9CCC65),
        secondaryContainer = Color(0xFFDCEDC8),
        background = Color(0xFF37474F),
        onBackground = Color(0xFF263238),
        surface = Color(0xFFB0BEC5),
        onSurface = Color(0xFFCFD8DC),
        error = Color(0xFFF44336),
        onError = Color.White,
        outline = Color(0xFF607D8B),
        // Additional states
        // success = Color(0xFF4CAF50),
        // warning = Color(0xFFFFEB3B),
        // info = Color(0xFF2196F3),
        // disabled = Color(0xFFA98270),
    )

private val LightColorScheme =
    lightColorScheme(
        primary = Color(0xFFA98274),
        onPrimary = Color(0xFF795548),
        primaryContainer = Color(0xFFD3B8AE),
        secondary = Color(0xFF8BC34A),
        onSecondary = Color(0xFF9CCC65),
        secondaryContainer = Color(0xFFDCEDC8),
        background = Color(0xFFECEFF1),
        onBackground = Color(0xFF263238),
        surface = Color(0xFFB0BEC5),
        onSurface = Color(0xFFCFD8DC),
        error = Color(0xFFF44336),
        onError = Color.White,
        outline = Color(0xFF607D8B),
        // Additional states
        // success = Color(0xFF4CAF50),
        // warning = Color(0xFFFFEB3B),
        // info = Color(0xFF2196F3),
        // disabled = Color(0xFFA98270),
    )

@Composable
fun RecipeWizardTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit,
) {
    val colorScheme =
        when {
            dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
                val context = LocalContext.current
                if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
            }

            darkTheme -> DarkColorScheme
            else -> LightColorScheme
        }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content,
    )
}
