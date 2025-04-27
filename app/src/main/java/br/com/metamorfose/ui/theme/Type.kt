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

    bodyMedium = TextStyle(
        fontFamily = DinNext,
        fontSize = 10.5.sp,  // Equivalent to 14px
        fontWeight = FontWeight.Normal
    ),
    bodyLarge = TextStyle(
        fontFamily = DinNext,
        fontSize = 12.sp,  // Equivalent to 16px
        fontWeight = FontWeight.Normal
    ),
    titleMedium = TextStyle(
        fontFamily = DinNext,
        fontSize = 15.sp,  // Equivalent to 20px
        fontWeight = FontWeight.Normal
    ),
    displayLarge = TextStyle(
        fontFamily = DinNext,
        fontSize = 27.sp,  // Equivalent to 36px
        fontWeight = FontWeight.Normal
    ),
    displaySmall = TextStyle(
        fontFamily = DinNext,
        fontSize = 12.sp, // Equivalent to 16px (Bold)
        fontWeight = FontWeight.Bold
    ),
    headlineLarge = TextStyle(
        fontFamily = DinNext,
        fontSize = 27.sp, // Equivalent to 36px (Bold)
        fontWeight = FontWeight.Bold
    )
)