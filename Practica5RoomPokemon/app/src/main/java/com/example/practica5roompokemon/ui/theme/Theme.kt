package com.example.practica5roompokemon.ui.theme
import androidx.compose.ui.graphics.Color

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val LightColors = lightColorScheme(
    primary = PokedexRed,
    onPrimary = PokedexWhite,
    primaryContainer = PokedexRedLight,
    onPrimaryContainer = PokedexRedDark,

    secondary = Color(0xFF5C5C5C),
    onSecondary = PokedexWhite,
    secondaryContainer = Color(0xFFEAEAEA),
    onSecondaryContainer = PokedexTextDark,

    background = PokedexBackground,
    onBackground = PokedexTextDark,

    surface = PokedexSurface,
    onSurface = PokedexTextDark,
    surfaceVariant = Color(0xFFF0F0F0),
    onSurfaceVariant = GraySoft,

    outline = GrayBorder
)

private val DarkColors = darkColorScheme(
    primary = Color(0xFFFF6B6B),
    onPrimary = Color(0xFF3B0909),
    primaryContainer = Color(0xFF7F1010),
    onPrimaryContainer = Color(0xFFFFDAD6),

    secondary = Color(0xFFBFBFBF),
    onSecondary = Color(0xFF2C2C2C),
    secondaryContainer = Color(0xFF3B3B3B),
    onSecondaryContainer = Color(0xFFF1F1F1),

    background = PokedexDarkBackground,
    onBackground = PokedexTextLight,

    surface = PokedexDarkSurface,
    onSurface = PokedexTextLight,
    surfaceVariant = PokedexDarkCard,
    onSurfaceVariant = Color(0xFFCAC4D0),

    outline = Color(0xFF4E4E4E)
)

@Composable
fun Practica5RoomPokemonTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColors else LightColors

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            window.navigationBarColor = colorScheme.surface.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
            WindowCompat.getInsetsController(window, view).isAppearanceLightNavigationBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}