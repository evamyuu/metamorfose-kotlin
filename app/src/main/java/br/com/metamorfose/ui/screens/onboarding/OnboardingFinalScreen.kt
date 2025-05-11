/**
 * File: OnboardingFinalScreen.kt
 * Description: Tela final do onboarding que convida o usuário a iniciar sua jornada de transformação.
 *
 * Responsabilidades:
 * - Exibe a ilustração do personagem Ivy com olhos brilhando
 * - Mostra uma mensagem motivacional dentro de um balão de fala
 * - Contém um botão primário para iniciar o app
 * - Permite voltar à etapa anterior com ícone de navegação
 *
 * Author: Evelin Cordeiro
 * Created on: 10-05-2025
 * Version: 1.0.0
 * Squad: Metamorfose
 */

package br.com.metamorfose.ui.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import br.com.metamorfose.R
import br.com.metamorfose.ui.components.buttons.PrimaryButton
import br.com.metamorfose.ui.theme.BlackLight
import br.com.metamorfose.ui.theme.GreyMedium
import br.com.metamorfose.ui.theme.MetamorfoseTheme
import br.com.metamorfose.ui.theme.Typography
import br.com.metamorfose.ui.theme.WhiteLight

/**
 * Composable que representa a tela final do onboarding do aplicativo Metamorfose.
 * Esta tela convida o usuário a iniciar sua jornada de transformação com o personagem Ivy.
 * Exibe um balão de fala motivacional e oferece um botão para continuar a experiência.
 *
 * @param onClickSim Função chamada quando o usuário clica no botão "SIM!" para iniciar a jornada.
 * @param onBackClick Função chamada quando o usuário clica no ícone de voltar.
 * @param modifier Modificador opcional para personalização da UI.
 */
@Composable
fun OnboardingFinalScreen(
    onClickSim: () -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(WhiteLight)
            .padding(WindowInsets.systemBars.asPaddingValues())
    ) {
        // Fundo
        Image(
            painter = painterResource(id = R.drawable.bg_wave_2),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )

        // Botão de navegação para voltar
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WindowInsets.systemBars.asPaddingValues())
                .zIndex(1f)
        ) {
            IconButton(
                onClick = onBackClick,
                modifier = Modifier.align(Alignment.CenterStart)
            ) {
                Icon(
                    imageVector = Icons.Outlined.ArrowBack,
                    contentDescription = "Voltar",
                    tint = BlackLight
                )
            }
        }

        // Conteúdo centralizado (Ivy + balão de fala + texto motivacional)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Container para Ivy e balão de fala
            Box(
                modifier = Modifier.wrapContentSize(),
                contentAlignment = Alignment.Center
            ) {
                // Exibe o personagem Ivy
                Image(
                    painter = painterResource(id = R.drawable.ivy_stars_eyes),
                    contentDescription = "Ivy",
                    modifier = Modifier.size(342.dp)
                )

                // Exibe o balão de fala
                Image(
                    painter = painterResource(id = R.drawable.balloon_dialog_ready),
                    contentDescription = "Balão de fala",
                    modifier = Modifier
                        .size(288.dp, 94.dp)
                        .offset(y = (-170).dp)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Texto motivacional
            Text(
                text = "Clique em SIM! para iniciar sua jornada",
                style = Typography.headlineSmall,
                color = GreyMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 32.dp)
            )
        }

        // Botão "SIM!"
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(WindowInsets.navigationBars.asPaddingValues()),
            contentAlignment = Alignment.BottomCenter
        ) {
            PrimaryButton(
                text = "SIM!",
                onClick = onClickSim,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}

/**
 * Preview da tela OnboardingFinalScreen.
 */
@Preview(showBackground = true)
@Composable
fun OnboardingFinalScreenPreview() {
    MetamorfoseTheme {
        OnboardingFinalScreen(
            onClickSim = {},
            onBackClick = {}
        )
    }
}
