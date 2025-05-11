package br.com.metamorfose.ui.screens.onboarding // Pacote ajustado

/**
 * File: OnboardingScreen.kt
 * Description: Tela de boas-vindas e introdução ao app Metamorfose.
 *
 * Responsabilidades:
 * - Exibe a marca e uma mensagem de impacto sobre a proposta do aplicativo.
 * - Oferece opções para o usuário iniciar a jornada (novo usuário) ou fazer login (usuário existente).
 *
 * Author: Vinicyus Oliveira
 * Created on: 10-05-2025
 * Last modified: 10-05-2025
 * Version: 1.0.0
 * Squad: Metamorfose
 */

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
import androidx.compose.runtime.Composable
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
import br.com.metamorfose.ui.components.buttons.PrimaryButton // Componente personalizado já usado
// Se você tiver um SecondButton genérico, poderia ser usado aqui.
// import br.com.metamorfose.ui.components.buttons.SecondButton
import br.com.metamorfose.ui.theme.MetamorfoseTheme // Seu tema
import br.com.metamorfose.ui.theme.PurpleNormal

// Importe aqui as cores específicas se elas forem definidas no seu theme/Color.kt
// Ex: import br.com.metamorfose.ui.theme.CrescimentoColor
// Ex: import br.com.metamorfose.ui.theme.JornadaColor
// Ex: import br.com.metamorfose.ui.theme.TextBaseColorOnboarding

// Cores específicas para o texto do Onboarding (idealmente, mova para seu arquivo Color.kt)
val TextBaseColorOnboarding = Color(0xFF424242)
val CrescimentoColor = Color(0xFF6EF575)
val JornadaColor = Color(0xFFB18EF2)
// Para "metamorfose", 'meta' usa JornadaColor e 'morfose' usa CrescimentoColor

// Variáveis de espaçamento e dimensões conforme Figma Dev Mode (mantido como no seu original)
private object Variables {
    val RadiusXL: Dp = 12.dp
    val StrokeS: Dp = 1.dp
    val SpacingPaddingL: Dp = 16.dp
    val SpacingGapXS: Dp = 8.dp
    val ButtonHeight: Dp = 43.dp // Altura comum para os botões
}

@Composable
fun OnboardingScreen(
    // viewModel: OnboardingViewModel = viewModel(), // Descomente se adicionar um ViewModel
    onStartClick: () -> Unit,
    onLoginClick: () -> Unit
) {
    // Os exemplos (`AuthScreen`, `PlantSetupScreen`) usam um GradientBackground.
    // Se esta tela também deve ter, envolva com GradientBackground {}.
    // Por enquanto, mantive seu MetamorfoseTheme { Box { ... } }
    MetamorfoseTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp), // Padding geral da tela
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_logo), // Verifique se este é o ID correto
                    contentDescription = "Logo Metamorfose", // Descrição mais específica
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
                        .width(337.dp) // Mantido conforme seu código
                        .wrapContentHeight(),
                    style = MaterialTheme.typography.headlineMedium.copy( // Use estilos do tema base
                        fontSize = 36.sp,
                        lineHeight = 50.4.sp, // Considere definir no Type.kt se for um estilo recorrente
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
                    .padding(horizontal = 24.dp, vertical = 24.dp), // Padding para os botões
                verticalArrangement = Arrangement.spacedBy(Variables.SpacingGapXS)
            ) {
                PrimaryButton( // Seu componente PrimaryButton
                    text = "COMEÇAR AGORA",
                    onClick = onStartClick,
                    modifier = Modifier.fillMaxWidth().height(Variables.ButtonHeight) // Adicionando altura padrão
                )

                OutlinedButton( // Botão "JÁ TENHO UMA CONTA" ajustado
                    onClick = onLoginClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(Variables.ButtonHeight) // Altura padrão
                        .shadow( // Adicionando a sombra conforme solicitado
                            elevation = 2.dp, // Use uma elevação > 0 para a sombra ser visível
                            spotColor = Color(0xFFEDEDED),
                            ambientColor = Color(0xFFEDEDED),
                            shape = RoundedCornerShape(Variables.RadiusXL)
                        ),
                    shape = RoundedCornerShape(Variables.RadiusXL),
                    border = BorderStroke(Variables.StrokeS, Color(0xFFE5E5E5)),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = Color.White, // Cor de fundo do botão
                        contentColor = PurpleNormal // Cor do texto (ajuste se necessário, usando seu tema)
                    ),
                    contentPadding = PaddingValues( // Padding interno do botão
                        horizontal = Variables.SpacingPaddingL,
                        vertical = 12.dp // Ajuste conforme necessário para o alinhamento vertical do texto
                    )
                ) {
                    Text(
                        text = "JÁ TENHO UMA CONTA",
                        // Modifier.fillMaxWidth() aqui faria o texto tentar preencher, o que pode não ser o ideal
                        //textAlign = TextAlign.Center, // O alinhamento do botão já centraliza o conteúdo
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 0.36.sp
                            // A cor do texto é definida em `contentColor` do botão
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
    name = "OnboardingScreenPreview" // Nome do Preview ajustado
)
@Composable
fun OnboardingScreenPreview() {
    OnboardingScreen(onStartClick = {}, onLoginClick = {})
}