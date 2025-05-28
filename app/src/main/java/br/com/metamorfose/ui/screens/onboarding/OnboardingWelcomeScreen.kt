/**
 * File: OnboardingWelcomeScreen.kt
 * Description: Tela de boas-vindas após o onboarding inicial, apresentando o mascote Ivy.
 * Author: Vinicyus Oliveira
 * Created on: 10-05-2025
 * Last modified: 23-05-2025
 * Version: 1.2.0
 * Squad: Metamorfose
 *
 * Changelog:
 *
 * - [23-05-2025] Ajustado ContentScale para Crop (por Eve)
 *
 */

package br.com.metamorfose.ui.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import br.com.metamorfose.R
import br.com.metamorfose.ui.components.buttons.PrimaryButton
import br.com.metamorfose.ui.theme.*

// Variáveis de layout
private object OnboardingWelcomeVariables {
    val TextBubbleCornerRadius: Dp = 7.9711.dp
    val ButtonHorizontalMargin: Dp = 16.dp
    val ButtonBottomMargin: Dp = 39.dp
    val ButtonHeight: Dp = 43.dp
    val ButtonWidth: Dp = 358.dp
}


@Composable
fun OnboardingWelcomeScreen(
    onNavigateNext: () -> Unit,
    onNavigateBack: () -> Unit = {}
) {
    MetamorfoseTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = WhiteLight) // Usando cor do tema
        ) {
            // Botão de voltar
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(WindowInsets.systemBars.asPaddingValues())
                    .zIndex(4f) // Colocando acima de todos os outros elementos
            ) {
                IconButton(
                    onClick = onNavigateBack,
                    modifier = Modifier.align(Alignment.CenterStart)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.ArrowBack,
                        contentDescription = "Voltar",
                        tint = BlackLight
                    )
                }
            }

            // --- Elemento: wave_01.xml (fundo com onda) ---
            Image(
                painter = painterResource(id = R.drawable.bg_wave_4),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(max = 600.dp)
                    .align(Alignment.TopCenter)
                    .zIndex(0f)
            )

            // Coluna para organizar elementos de forma responsiva
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
                    .zIndex(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.weight(0.25f)) // Espaço superior flexível

                // --- Balão de fala contendo o texto ---
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.85f)
                        .padding(bottom = 16.dp)
                ) {
                    // Fundo do balão com sombra
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .zIndex(2f)
                            .drawBehind {
                                val shadowColor = GreenLight
                                val xOff = 2.5.dp.toPx()
                                val yOff = 2.5.dp.toPx()
                                val spread = 2.5.dp.toPx()
                                val cornerRadiusPx = OnboardingWelcomeVariables.TextBubbleCornerRadius.toPx()

                                val shadowRectLeft = xOff - spread
                                val shadowRectTop = yOff - spread
                                val shadowRectWidth = this.size.width + (2 * spread)
                                val shadowRectHeight = this.size.height + (2 * spread)

                                drawRoundRect(
                                    color = shadowColor,
                                    topLeft = Offset(shadowRectLeft, shadowRectTop),
                                    size = Size(shadowRectWidth, shadowRectHeight),
                                    cornerRadius = CornerRadius(cornerRadiusPx)
                                )
                            }
                            .background(
                                color = WhiteLight,
                                shape = RoundedCornerShape(size = OnboardingWelcomeVariables.TextBubbleCornerRadius)
                            )
                            .padding(16.dp)
                    ) {
                        // Texto dentro do balão
                        Text(
                            text = buildAnnotatedString {
                                pushStyle(MaterialTheme.typography.titleLarge.copy(fontSize = 21.92.sp, color = GreyMedium).toSpanStyle())
                                append("Parabéns por começar!\n")
                                pop()
                                pushStyle(MaterialTheme.typography.titleSmall.copy(color = GreyMedium).toSpanStyle())
                                append("Eu sou o ")
                                withStyle(style = SpanStyle(color = PurpleNormal)) { append("Ivy") }
                                append(", seu guia nessa jornada de\n")
                                withStyle(style = SpanStyle(color = GreenDark)) { append("superação") }
                                append(" dos seus vícios. Vamos \n")
                                append("juntos nessa ")
                                withStyle(style = SpanStyle(color = PurpleNormal)) { append("transformação") }
                                append("?")
                                pop()
                            },
                            textAlign = TextAlign.Center,
                            fontFamily = DinNext,
                            lineHeight = 1.4.em,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }

                    // Triângulo do balão (ponta)
                    Image(
                        painter = painterResource(id = R.drawable.ic_polygon),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .size(width = 22.47.dp, height = 18.72.dp)
                            .align(Alignment.BottomCenter)
                            .offset(y = 18.dp)
                            .zIndex(2.1f)
                    )
                }

                // --- Mascote Ivy ---
                Image(
                    painter = painterResource(id = R.drawable.ivy_happy),
                    contentDescription = "Mascote Ivy Feliz",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .weight(0.4f)
                        .zIndex(1f)
                )

                Spacer(modifier = Modifier.weight(0.15f)) // Espaço flexível

                // --- Botão "VAMOS LÁ" ---
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 32.dp),
                    contentAlignment = Alignment.Center
                ) {
                    PrimaryButton(
                        text = "VAMOS LÁ",
                        onClick = onNavigateNext,
                        modifier = Modifier.width(OnboardingWelcomeVariables.ButtonWidth)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 390, heightDp = 844)
@Composable
fun OnboardingWelcomeScreenPreview() {
    OnboardingWelcomeScreen(
        onNavigateNext = {},
        onNavigateBack = {}
    )
}