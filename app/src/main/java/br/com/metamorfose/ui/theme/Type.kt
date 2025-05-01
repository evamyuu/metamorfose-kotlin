package br.com.metamorfose.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import br.com.metamorfose.R

val DinNext = FontFamily(
    Font(R.font.din_next_regular, FontWeight.Normal),
    Font(R.font.din_next_bold, FontWeight.Bold)
)

val Typography = Typography(

    displayLarge = TextStyle(
        fontFamily = DinNext,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp
    ),
    displayMedium = TextStyle(
        fontFamily = DinNext,
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp
    ),
    displaySmall = TextStyle(
        fontFamily = DinNext,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp
    ),

    headlineLarge = TextStyle(
        fontFamily = DinNext,
        fontWeight = FontWeight.Bold,
        fontSize = 36.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = DinNext,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = DinNext,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    ),

    titleLarge = TextStyle(
        fontFamily = DinNext,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    titleMedium = TextStyle(
        fontFamily = DinNext,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp
    ),
    titleSmall = TextStyle(
        fontFamily = DinNext,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    ),

    bodyLarge = TextStyle(
        fontFamily = DinNext,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = DinNext,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    bodySmall = TextStyle(
        fontFamily = DinNext,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),

    labelLarge = TextStyle(
        fontFamily = DinNext,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),
    labelMedium = TextStyle(
        fontFamily = DinNext,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp
    ),
    labelSmall = TextStyle(
        fontFamily = DinNext,
        fontWeight = FontWeight.Bold,
        fontSize = 10.sp
    )
)