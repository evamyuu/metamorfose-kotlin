/**
 * File: Theme.kt
 * Description: Definição do tema do app Metamorfose, incluindo as cores para os modos claro e escuro, e a aplicação do tema em toda a interface do usuário.
 *
 * Responsabilidades:
 * - Define o esquema de cores para o tema claro e escuro.
 * - Aplica o tema ao conteúdo do app, alterando a cor da barra de status e ajustando o esquema de cores conforme o modo (claro ou escuro).
 * - Utiliza a API do Jetpack Compose para adaptar a UI ao tema configurado.
 *
 * Author: Evelin Cordeiro
 * Created on: 28-04-2025
 * Last modified: 30-04-2025
 * Version: 1.0.0
 * Squad: Metamorfose
 *
 */

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