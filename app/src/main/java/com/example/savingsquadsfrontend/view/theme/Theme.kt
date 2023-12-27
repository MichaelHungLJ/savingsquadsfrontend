package com.example.savingsquadsfrontend.view.theme

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
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = Pink50, // Use for action components
    onPrimary = White100,
    primaryContainer = White100, // Use for alternate text components
    onPrimaryContainer = Pink50,
    background = White100, // Overall app background
    onBackground = White50,
    surface = White100, // For my card components
    onSurface = White0, // For text in card components
    inverseOnSurface = White50, // For subtext in card components
    error = Pink80, // Example error color, adjust as needed
    onError = White100 // Text color on error color
)

private val LightColorScheme = lightColorScheme(
    primary = Pink50, // Use for action components
    onPrimary = White100,
    primaryContainer = White100, // Use for alternate text components
    onPrimaryContainer = Pink50,
    background = White100, // Overall app background
    onBackground = White50,
    surface = White100, // For my card components
    onSurface = White0, // For text in card components
    inverseOnSurface = White50, // For subtext in card components
    error = Pink80, // Example error color, adjust as needed
    onError = White100 // Text color on error color
)

@Composable
fun SavingsquadsfrontendTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
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
        content = content
    )
}
