/**
 * File: MainScreen.kt
 * Description: Tela principal do aplicativo Metamorfose, mostrando a mascote Ivy e opções de interação.
 *
 * Responsabilidades:
 * - Exibir a interface principal do aplicativo após o login/registro e setup da planta
 * - Mostrar o personagem Ivy e facilitar a interação do usuário
 * - Fornecer acesso às funcionalidades principais do app
 *
 * Author: Ester Silva
 * Created on: 28-04-2025
 * Last modified: 08-05-2025
 * Version: 2.0.0
 * Squad: Metamorfose
 */

package br.com.metamorfose.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.metamorfose.ui.components.CharacterSection
import br.com.metamorfose.ui.components.ConversationText
import br.com.metamorfose.ui.theme.MetamorfoseTheme

/**
 * Tela principal do aplicativo Metamorfose.
 *
 * @param peronaName Nome do personagem (mascote) a ser exibido
 * @param userName Nome do usuário para exibição personalizada
 * @param onExitApp Callback para sair do aplicativo quando o botão de sair é clicado
 * @param modifier Modificador opcional para customização da tela
 */
@Composable
fun MainScreen(
    peronaName: String,
    userName: String,
    onExitApp: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Surface(
        color = Color.White,
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(20.dp))

            // Seção do personagem Ivy
            CharacterSection(peronaName)

            // Texto de conversa com o usuário
            ConversationText(userName)

            // Barra de navegação inferior com função de sair
//            BottomNavigationBar(
//                onHomeClick = { /* Ação de ir para home */ },
//                onMicClick = { /* Ação de ativar microfone */ },
//                onExitClick = onExitApp
//            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MetamorfoseTheme {
        MainScreen(
            peronaName = "Ivy",
            userName = "Usuário"
        )
    }
}