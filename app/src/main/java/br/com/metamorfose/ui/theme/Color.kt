package br.com.metamorfose.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

// Purple
val PurpleDarken = Color(0xFF4E347F)
val PurpleDark = Color(0xFF7D53CC)
val PurpleNormal = Color(0xFF9D68FF)
val PurpleLight = Color(0xFFB18EF2)

// Green
val GreenDarken = Color(0xFF2C622E)
val GreenDark = Color(0xFF429346)
val GreenNormal = Color(0xFF58C45D)
val GreenLight = Color(0xFF6EF575)

// White
val WhiteDark = Color(0xFFEDEDED)
val WhiteLight = Color(0xFFFFFFFF)
val WhiteNormal = Color(0xFFF7F7F7)

// Grey
val GreyDark = Color(0xFF3C3C3C)
val GreyMedium = Color(0xFF767676)
val GreyLight = Color(0xFFAFAFAF)
val GreyLightest = Color(0xFFC7C7C7)
val GreyLightest2 = Color(0xFFEDEDED)
val GreyExtraLight = Color(0xFFF7F7F7)

// Black
val BlackDark = Color(0xFF171717)
val BlackNormal = Color(0xFF212121)
val BlackLight = Color(0xFF424242)
val BlackLighten = Color(0xFF9B9B9B)

// Linear Gradients

val LightPurpleGradient = Brush.linearGradient(
    colors = listOf(
        Color(0xFFFAEAFF),  // 0%
        Color(0xFFB18EF2)   // 100%
    )
)

val GreenGradient = Brush.linearGradient(
    colors = listOf(
        Color(0xFF57C785),  // 0%
        Color(0xFF6EF575)   // 100%
    )
)

val DarkPurpleGradient = Brush.linearGradient(
    colors = listOf(
        Color(0xFF4E347F),  // 0%
        Color(0xFF9D68FF)   // 100%
    )
)

val LightPurple33Gradient = Brush.linearGradient(
    colors = listOf(
        Color(0xFFAF8CF2),  // 0%
        Color(0xFFD8C7FA)   // 33%
    )
)