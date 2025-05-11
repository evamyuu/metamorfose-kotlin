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
 * Last modified: 10-05-2025
 * Version: 1.0.0
 * Squad: Metamorfose
 */

package br.com.metamorfose.ui.screens.onboarding // Pacote ajustado

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
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
import br.com.metamorfose.ui.theme.MetamorfoseTheme
import androidx.compose.runtime.Composable as Composable1

// Importe as cores do seu tema se elas já estiverem definidas em Color.kt
// Por exemplo: import br.com.metamorfose.ui.theme.CrescimentoColor, etc.

// Cores específicas para o texto do OnboardingScreen (se não estiverem no tema Color.kt)
private val TextBaseColorOnboarding = Color(0xFF424242)
private val CrescimentoColor = Color(0xFF6EF575) // Verde para "crescimento" e "morfose"
private val JornadaColor = Color(0xFFB18EF2)     // Roxo para "jornada" e "meta"

// Variáveis de espaçamento e dimensões conforme Figma Dev Mode
private object OnboardingScreenVariables { // Renomeado para evitar conflito com outras telas
    val RadiusXL: Dp = 12.dp
    val StrokeS: Dp = 1.dp
    val SpacingPaddingL: Dp = 16.dp
    val SpacingGapXS: Dp = 8.dp
    val ButtonHeight: Dp = 43.dp
}

@Composable1
fun OnboardingScreen(
    onStartClick: () -> Unit,
    onLoginClick: () -> Unit
) {
    MetamorfoseTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_logo), // Verifique se este é o ID correto do seu logo
                    contentDescription = "Logo Metamorfose",
                    modifier = Modifier
                        .width(267.dp)
                        .height(196.dp)
                )
                Spacer(modifier = Modifier.height(32.dp))
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
                        withStyle(style = SpanStyle(color = JornadaColor)) { // "meta"
                            append("meta")
                        }
                        withStyle(style = SpanStyle(color = CrescimentoColor)) { // "morfose"
                            append("morfose")
                        }
                    },
                    modifier = Modifier
                        .width(337.dp)
                        .wrapContentHeight(),
                    style = MaterialTheme.typography.headlineMedium.copy( // Use estilos do tema base
                        fontSize = 36.sp,
                        lineHeight = 50.4.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.36.sp
                        // A cor base é definida no buildAnnotatedString
                    ),
                    textAlign = TextAlign.Center
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(horizontal = 24.dp, vertical = 32.dp), // Ajustado padding vertical
                verticalArrangement = Arrangement.spacedBy(OnboardingScreenVariables.SpacingGapXS)
            ) {
                PrimaryButton(
                    text = "COMEÇAR AGORA",
                    onClick = onStartClick,
                    modifier = Modifier.fillMaxWidth().height(OnboardingScreenVariables.ButtonHeight)
                )

                OutlinedButton(
                    onClick = onLoginClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(OnboardingScreenVariables.ButtonHeight)
                        .shadow( // Sombra sutil conforme especificação do Figma
                            elevation = 1.dp, // Pequena elevação para a sombra ter efeito
                            spotColor = Color(0xFFEDEDED), // Cor da sombra spot
                            ambientColor = Color(0xFFEDEDED), // Cor da sombra ambiente
                            shape = RoundedCornerShape(size = OnboardingScreenVariables.RadiusXL)
                        ),
                    shape = RoundedCornerShape(OnboardingScreenVariables.RadiusXL),
                    border = BorderStroke(OnboardingScreenVariables.StrokeS, Color(0xFFE5E5E5)), // Borda do Figma
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = Color.White, // Fundo branco do Figma
                        contentColor = MaterialTheme.colorScheme.primary // Cor do texto (pode ser PurpleNormal ou outra do seu tema)
                    ),
                    contentPadding = PaddingValues( // Padding interno do Figma
                        horizontal = OnboardingScreenVariables.SpacingPaddingL,
                        vertical = 12.dp // O padding vertical total seria 12+texto+12 = ~43dp de altura total
                    )
                ) {
                    Text(
                        text = "JÁ TENHO UMA CONTA",
                        // textAlign = TextAlign.Center, // O botão já centraliza seu conteúdo
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold, // Texto do botão em negrito
                            letterSpacing = 0.36.sp
                            // A cor do texto é definida em contentColor do botão
                        )
                    )
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 390,
    heightDp = 844,
    name = "OnboardingScreenPreview"
)
@Composable1
fun OnboardingScreenPreview() {
    OnboardingScreen(onStartClick = {}, onLoginClick = {})
}