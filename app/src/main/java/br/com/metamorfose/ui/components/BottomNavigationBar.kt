package br.com.metamorfose.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomAppBar
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Icon
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.IconButton
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Mic
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BottomNavigationBar() {
    BottomAppBar(
        backgroundColor = Color.White,
        elevation = 10.dp,
        contentPadding = PaddingValues(horizontal = 24.dp)
    ) {
        IconButton(onClick = { /* TODO */ }, modifier = Modifier.weight(1f)) {
            Icon(Icons.Default.Home, contentDescription = "Home", tint = Color.Gray)
        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .weight(1f)
                .size(56.dp)
                .background(color = Color(0xFF55D88C), shape = CircleShape)
        ) {
            Icon(Icons.Default.Mic, contentDescription = "Mic", tint = Color.White)
        }

        IconButton(onClick = { /* TODO */ }, modifier = Modifier.weight(1f)) {
            Text("Sair", color = Color(0xFF9A9A9A))
        }
    }
}
