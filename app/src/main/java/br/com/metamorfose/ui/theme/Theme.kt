package br.com.metamorfose.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

// Light Colors
private val LightColors = lightColorScheme(
    primary = PurpleNormal,
    secondary = PurpleLight,
    tertiary = GreenLight,
    background = WhiteLight,
    surface = WhiteLight,
    onPrimary = WhiteLight,
    onSecondary = WhiteLight,
    onBackground = BlackNormal,
    onSurface = BlackNormal
)

// Dark Colors
private val DarkColors = darkColorScheme(
    primary = PurpleLight,
    secondary = PurpleNormal,
    tertiary = GreenLight,
    background = BlackDark,
    surface = GreyDark,
    onPrimary = BlackNormal,
    onSecondary = BlackNormal,
    onBackground = WhiteNormal,
    onSurface = WhiteNormal
)

@Composable
fun MetamorfoseTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColors else LightColors

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}