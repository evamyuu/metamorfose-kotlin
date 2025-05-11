/**
 * File: VoiceChatScreen.kt
 * Description: Tela completa de chat de voz para o app Metamorfose, integrando todos os componentes necessários
 *
 * Description: Tela principal de interação do usuário com o personagem de planta no app Metamorfose e componente de navegação inferior do app Metamorfose, incluindo botões de ação para a tela de chat.
 *
 * Responsabilidades:
 * * Exibe o personagem de planta com sua aparência personalizada
 * * Mostra a saudação personalizada com o nome do usuário
 * * Implementa a barra de navegação inferior com botões de ação
 * * Coordena a interação entre o usuário e o personagem
 * * Exibe a barra de navegação inferior com botões de casa, microfone e perfil
 * * Gerencia os estados visuais dos botões (selecionado/não selecionado)
 * * Processa eventos de clique nos botões de navegação
 * * Aplica o estilo visual consistente com o tema do app
 *
 * Author: Ester Silva
 * Created on: 10-05-2025
 * Last modified: 10-05-2025
 * Version: 2.0.0
 * Squad: Metamorfose
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
import androidx.compose.ui.graphics.Color
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

/**
 * Tela principal do chat de voz com a planta, integrando todos os elementos
 * conforme o design fornecido na imagem de referência
 *
 * @param characterName Nome do usuário para exibir no texto de saudação
 * @param plantName Nome da planta para exibir no balão de fala
 * @param onMicrophoneClick Callback para o clique no botão de microfone
 * @param onHomeClick Callback para o clique no botão de home
 * @param onProfileClick Callback para o clique no botão de perfil
 * @param onExitClick Callback para o clique no botão de sair
 */
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
            .background(Color.White)
    ) {

        // Conteúdo principal
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Área superior com o personagem e decorações
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                // Círculos decorativos
                Image(
                    painter = painterResource(id = R.drawable.ic_plant_setup),
                    contentDescription = "Background circles",
                    modifier = Modifier
                        .size(200.dp)
                        .align(Alignment.Center),
                    contentScale = ContentScale.Fit
                )

                // Balão de fala
                Surface(
                    shape = RoundedCornerShape(16.dp),
                    color = GreenNormal,
                    modifier = Modifier
                        .padding(bottom = 180.dp)
                        .align(Alignment.Center)
                ) {
                    Text(
                        text = "Oi, eu sou $plantName",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.White,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                    )
                }

                // Personagem da planta
                Image(
                    painter = painterResource(id = R.drawable.ic_background),
                    contentDescription = "Plant character",
                    modifier = Modifier
                        .size(360.dp)
                        .align(Alignment.Center),
                    contentScale = ContentScale.Fit
                )
            }

            // Texto de saudação ao usuário
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = GreenNormal,
                            fontWeight = FontWeight.ExtraBold
                        )
                    ) {
                        append(characterName)
                    }
                    withStyle(
                        style = SpanStyle(
                            color = GreyMedium
                        )
                    ) {
                        append(", vamos conversar?")
                    }
                },
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 200.dp)
                    .padding(horizontal = 24.dp)
            )

            // Barra de navegação inferior
            BottomNavigationBar(
                onMicrophoneClick = onMicrophoneClick,
                onHomeClick = onHomeClick,
                onProfileClick = onProfileClick,
                onExitClick = onExitClick
            )
        }
    }
}


/**
 * Barra de navegação inferior com botões e indicador
 */
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
            color = Color.White,
            shadowElevation = 4.dp,
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                // Botões de navegação
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(2f),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Botão Home
                    Icon(
                        painter = painterResource(id = R.drawable.ic_home),
                        contentDescription = "Home",
                        tint = PurpleLight,
                        modifier = Modifier
                            .size(24.dp)
                            .clickable(onClick = onHomeClick)
                    )

                    // Botão de microfone (destacado)
                    Box(
                        modifier = Modifier
                            .size(56.dp)
                            .clip(CircleShape)
                            .background(GreenNormal)
                            .clickable(onClick = onMicrophoneClick),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_microphone),
                            contentDescription = "Microphone",
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                    }

                    // Botão de perfil
                    Icon(
                        painter = painterResource(id = R.drawable.ic_profile),
                        contentDescription = "Profile",
                        tint = PurpleLight,
                        modifier = Modifier
                            .size(24.dp)
                            .clickable(onClick = onProfileClick)
                    )
                }

                // Indicador da aba atual
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(3.dp),
                    contentAlignment = Alignment.Center
                ) {
                    // Linha preta do indicador
                    Box(
                        modifier = Modifier
                            .width(80.dp)
                            .height(3.dp)
                            .background(Color.Black)
                    )
                }
            }
        }

        // Botão de saída no canto inferior direito
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
                style = MaterialTheme.typography.bodyMedium,
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