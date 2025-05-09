package br.com.metamorfose.ui.components

import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight

@Composable
fun ConversationText(name: String) {
    Text(
        buildAnnotatedString {
            append(" ")
            withStyle(style = SpanStyle(color = Color(0xFF55D88C), fontWeight = FontWeight.Bold)) {
                append(name)
            }
            append(", vamos conversar?")
        },
        fontSize = 20.sp,
        modifier = Modifier.padding(16.dp),
        textAlign = TextAlign.Center
    )
}
