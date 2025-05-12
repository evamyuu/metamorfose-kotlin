/**
 * File: BottomNavigation.kt
 * Description: Componente de navegação inferior do app Metamorfose, incluindo botões de ação para a tela de chat.
 *
 * Responsabilidades:
 * * Exibe a barra de navegação inferior com botões de casa, microfone e perfil
 * * Gerencia os estados visuais dos botões (selecionado/não selecionado)
 * * Processa eventos de clique nos botões de navegação
 * * Aplica o estilo visual consistente com o tema do app
 *
 * Author: Ester Silva
 * Created on: 10-05-2025
 * Last modified: 10-05-2025
 * Version: 1.0.0
 * Squad: Metamorfose
 *
 */

package br.com.metamorfose.ui.components.bottomnavigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.metamorfose.R
import br.com.metamorfose.ui.theme.*

/**
 * Enum que define os tipos de ações disponíveis na navegação inferior
 */
enum class NavigationAction {
    HOME, MICROPHONE, PROFILE, EXIT
}

/**
 * Componente de navegação inferior com botões de ação
 *
 * @param isRecording Indica se o microfone está ativo/gravando
 * @param onActionClick Callback para quando uma ação é clicada
 * @param modifier Modificador para personalização do layout
 */
@Composable
fun BottomNavigationComponent(
    isRecording: Boolean,
    onActionClick: (NavigationAction) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(Color.White),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Botão Home
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .clickable { onActionClick(NavigationAction.HOME) }
                .padding(8.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_home),
                contentDescription = "Home",
                tint = PurpleLight,
                modifier = Modifier.size(24.dp)
            )
        }

        // Botão de Microfone (centralizado e maior)
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
                .background(if (isRecording) PurpleNormal else GreenNormal)
                .clickable { onActionClick(NavigationAction.MICROPHONE) }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_microphone),
                contentDescription = "Microfone",
                tint = Color.White,
                modifier = Modifier.size(28.dp)
            )
        }

        // Botão de Perfil
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .clickable { onActionClick(NavigationAction.PROFILE) }
                .padding(8.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_user),
                contentDescription = "Perfil",
                tint = PurpleLight,
                modifier = Modifier.size(24.dp)
            )
        }

        // Botão de Sair (posicionado na extrema direita)
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .clickable { onActionClick(NavigationAction.EXIT) }
                .padding(8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_exit),
                    contentDescription = "Sair",
                    tint = PurpleLight,
                    modifier = Modifier.size(20.dp)
                )
                Text(
                    text = "Sair",
                    color = PurpleLight,
                    style = MaterialTheme.typography.labelMedium,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationComponentPreview() {
    MetamorfoseTheme {
        BottomNavigationComponent(
            isRecording = false,
            onActionClick = {}
        )
    }
}