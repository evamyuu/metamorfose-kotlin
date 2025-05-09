package br.com.metamorfose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.metamorfose.R

@Composable
fun CharacterSection(peronaName: String) {
    Box(contentAlignment = Alignment.TopCenter) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Oi, eu sou $peronaName",
                color = Color.White,
                fontSize = 14.sp,
                modifier = Modifier
                    .background(Color(0xFF8AE99B), shape = RoundedCornerShape(12.dp))
                    .padding(horizontal = 12.dp, vertical = 6.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Image(
                painter = painterResource(id = R.drawable.perona),
                contentDescription = peronaName,
                //contentScale = ContentScale.Fit,
                modifier = Modifier.size(180.dp)
            )
        }
    }
}
