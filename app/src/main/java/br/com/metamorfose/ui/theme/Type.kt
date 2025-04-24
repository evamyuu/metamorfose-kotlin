package br.com.metamorfose.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import br.com.metamorfose.R

val DinNext = FontFamily(
    Font(R.font.din_next_regular),
    Font(R.font.din_next_bold)
)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = DinNext,
        fontSize = 16.sp
    ),
    titleLarge = TextStyle(
        fontFamily = DinNext,
        fontSize = 22.sp
    ),
    labelLarge = TextStyle(
        fontFamily = DinNext,
        fontSize = 14.sp
    )
)
