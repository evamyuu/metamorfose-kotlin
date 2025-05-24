/*
* File: VoiceChatScreen.kt
* Description: Tela de interface para chat por voz com personagem virtual.
*
* Responsabilidades:
* * Renderiza a interface visual do chat por voz
* * Exibe informações do personagem e planta virtual
* * Gerencia interações de navegação e controles de áudio
* * Implementa barra de navegação inferior com microfone
*
* Author: Ester Silva
* Created on: 10-05-2025
* Last modified: 24-05-2025
* Version: 2.0.0
* Squad: Metamorfose
*
* Changelog:
* - [24-05-2025] Reinserção do comentário de cabeçalho (por Ester Silva).
*
*/

package br.com.metamorfose.ui.screens.chat

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.metamorfose.R
import br.com.metamorfose.ui.theme.*

@Composable
fun VoiceChatScreen(
    characterName: String = "Sanji",
    plantName: String = "Perona",
    onMicrophoneClick: () -> Unit = {},
    onHomeClick: () -> Unit = {},
    onProfileClick: () -> Unit = {},
    onExitClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(WhiteLight)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.plant_setup),
                    contentDescription = "Decorative background",
                    modifier = Modifier
                        .size(200.dp)
                        .align(Alignment.Center),
                    contentScale = ContentScale.Fit
                )

                Image(
                    painter = painterResource(id = R.drawable.bg_circle),
                    contentDescription = "Plant character",
                    modifier = Modifier
                        .size(360.dp)
                        .align(Alignment.Center),
                    contentScale = ContentScale.Fit
                )

                Surface(
                    shape = RoundedCornerShape(16.dp),
                    color = GreenLight,
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .offset(y = 85.dp)
                ) {
                    Text(
                        text = "Oi, eu sou $plantName",
                        style = Typography.titleLarge,
                        color = WhiteLight,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                    )
                }
            }

            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = GreenLight, fontWeight = FontWeight.ExtraBold)) {
                        append(characterName)
                    }
                    withStyle(style = SpanStyle(color = GreyMedium)) {
                        append(", vamos conversar?")
                    }
                },
                style = MaterialTheme.typography.headlineLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 200.dp)
                    .padding(horizontal = 24.dp)
            )

            BottomNavigationBar(
                onMicrophoneClick = onMicrophoneClick,
                onHomeClick = onHomeClick,
                onProfileClick = onProfileClick,
                onExitClick = onExitClick
            )
        }
    }
}

@Composable
private fun BottomNavigationBar(
    onMicrophoneClick: () -> Unit,
    onHomeClick: () -> Unit,
    onProfileClick: () -> Unit,
    onExitClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
    ) {
        Surface(
            color = WhiteLight,
            shadowElevation = 4.dp,
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(2f),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_home),
                        contentDescription = "Home",
                        tint = PurpleLight,
                        modifier = Modifier
                            .size(24.dp)
                            .clickable(onClick = onHomeClick)
                    )

                    Box(
                        modifier = Modifier
                            .size(56.dp)
                            .clip(CircleShape)
                            .background(PurpleNormal)
                            .clickable(onClick = onMicrophoneClick),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_microphone),
                            contentDescription = "Microphone",
                            tint = WhiteLight,
                            modifier = Modifier.size(24.dp)
                        )
                    }

                    Icon(
                        painter = painterResource(id = R.drawable.ic_user),
                        contentDescription = "Profile",
                        tint = PurpleLight,
                        modifier = Modifier
                            .size(24.dp)
                            .clickable(onClick = onProfileClick)
                    )
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(3.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Box(
                        modifier = Modifier
                            .width(80.dp)
                            .height(3.dp)
                            .background(BlackNormal) // Define essa cor no theme se ainda não tiver
                    )
                }
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 16.dp, bottom = 28.dp)
                .clickable(onClick = onExitClick)
        ) {
            Text(
                text = "Sair",
                style = Typography.titleSmall,
                color = PurpleLight
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_exit),
                contentDescription = "Exit",
                tint = PurpleLight,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VoiceChatScreenPreview() {
    MetamorfoseTheme {
        VoiceChatScreen()
    }
}
