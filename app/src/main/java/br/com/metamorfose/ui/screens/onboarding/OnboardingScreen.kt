/**
 * File: OnboardingScreen.kt
 * Description: Tela inicial de onboarding do app Metamorfose. Apresenta a proposta de valor e opções de entrada.
 *
 * Responsabilidades:
 * - Exibe o logo e a mensagem principal do app.
 * - Oferece botões para "COMEÇAR AGORA" (novos usuários) e "JÁ TENHO UMA CONTA" (usuários existentes).
 *
 * Author: Vinicyus Oliveira
 * Created on: 10-05-2025
 * Last modified: 11-05-2025
 * Version: 1.1.0
 * Squad: Metamorfose
 */

package br.com.metamorfose.ui.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.metamorfose.R
import br.com.metamorfose.ui.components.buttons.PrimaryButton
import br.com.metamorfose.ui.components.buttons.SecondButton
import br.com.metamorfose.ui.theme.MetamorfoseTheme

// Cores específicas para o texto do OnboardingScreen
private val TextBaseColorOnboarding = Color(0xFF424242)
private val CrescimentoColor = Color(0xFF6EF575) // Verde para "crescimento" e "morfose"
private val JornadaColor = Color(0xFFB18EF2)     // Roxo para "jornada" e "meta"

// Variáveis de espaçamento e dimensões
private object OnboardingScreenVariables {
    val ButtonHeight: Dp = 43.dp
    val MaxButtonWidth: Dp = 358.dp // Largura máxima para os botões
    val HorizontalPadding: Dp = 24.dp // Padding horizontal padrão
    val SpacingGapXS: Dp = 16.dp // Espaçamento entre botões
    val LogoTopSpacing: Dp = 250.dp // Espaço acima do logo
}

@Composable
fun OnboardingScreen(
    onStartClick: () -> Unit,
    onLoginClick: () -> Unit
) {
    MetamorfoseTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            // Coluna principal com logo e texto
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = OnboardingScreenVariables.HorizontalPadding),
                verticalArrangement = Arrangement.Top, // Alterado para Top
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Espaço para empurrar o logo para baixo
                Spacer(modifier = Modifier.height(OnboardingScreenVariables.LogoTopSpacing))

                // Logo
                Image(
                    painter = painterResource(R.drawable.logo),
                    contentDescription = "Logo Metamorfose",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .wrapContentSize()
                        .weight(0.3f) // Reduzido o peso para 30% do espaço disponível
                )

                // Texto principal com estilização
                Text(
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(color = TextBaseColorOnboarding)) {
                            append("Seu ")
                        }
                        withStyle(style = SpanStyle(color = CrescimentoColor)) {
                            append("crescimento")
                        }
                        withStyle(style = SpanStyle(color = TextBaseColorOnboarding)) {
                            append(",\nsua ")
                        }
                        withStyle(style = SpanStyle(color = JornadaColor)) {
                            append("jornada")
                        }
                        withStyle(style = SpanStyle(color = TextBaseColorOnboarding)) {
                            append(",\nsua ")
                        }
                        withStyle(style = SpanStyle(color = JornadaColor)) {
                            append("meta")
                        }
                        withStyle(style = SpanStyle(color = CrescimentoColor)) {
                            append("morfose")
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .weight(0.4f), // 40% do espaço disponível
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontSize = 36.sp,
                        lineHeight = 50.4.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.36.sp
                    ),
                    textAlign = TextAlign.Center
                )

                // Espaço flexível antes dos botões
                Spacer(modifier = Modifier.weight(0.3f)) // 30% do espaço disponível
            }

            // Coluna de botões na parte inferior
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(
                        horizontal = OnboardingScreenVariables.HorizontalPadding,
                        vertical = 32.dp
                    ),
                verticalArrangement = Arrangement.spacedBy(OnboardingScreenVariables.SpacingGapXS),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Botão "COMEÇAR AGORA"
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .widthIn(max = OnboardingScreenVariables.MaxButtonWidth),
                    contentAlignment = Alignment.Center
                ) {
                    PrimaryButton(
                        text = "COMEÇAR AGORA",
                        onClick = onStartClick,
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                // Botão "JÁ TENHO UMA CONTA"
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .widthIn(max = OnboardingScreenVariables.MaxButtonWidth),
                    contentAlignment = Alignment.Center
                ) {
                    SecondButton(
                        text = "JÁ TENHO UMA CONTA",
                        onClick = onLoginClick,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 390, heightDp = 844)
@Composable
fun OnboardingScreenPreview() {
    OnboardingScreen(onStartClick = {}, onLoginClick = {})
}

