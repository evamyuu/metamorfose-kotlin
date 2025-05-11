/**
 * File: OnboardingWelcome.kt
 * Description: Tela de boas-vindas após o onboarding inicial, apresentando o mascote Ivy.
 * Author: Vinicyus Oliveira
 * Created on: 10-05-2025
 * Last modified: 10-05-2025
 * Version: 1.0.0
 * Squad: Metamorfose
 */

package br.com.metamorfose.ui.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.unit.em // Import para a unidade 'em'
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
    onNavigateNext: () -> Unit
) {
    MetamorfoseTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = WhiteLight) // Usando cor do tema
        ) {
            // --- Elemento: wave_01.xml ---
            // Posição: X: 0, Y: 0
            Image(
                painter = painterResource(id = R.drawable.bg_wave_4), // Certifique-se que R.drawable.wave_01 existe
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 0.dp, y = 0.dp)
                    .width(390.dp)
                    .height(516.dp)
                    .zIndex(0f)
            )

            // --- Elemento: ivy_happy.png ---
            // Posição: X: 32, Y: 355
            Image(
                painter = painterResource(id = R.drawable.ivy_happy), // Certifique-se que R.drawable.ivy_happy existe
                contentDescription = "Mascote Ivy Feliz",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 32.dp, y = 355.dp)
                    .width(326.dp)
                    .height(270.dp)
                    .zIndex(1f)
            )

            // --- Elemento: Frame do Texto (Fundo do Balão de Fala) ---
            // Posição: X: 50, Y: 212
            Box(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 50.dp, y = 212.dp)
                    .zIndex(2f) // Atrás do texto, mas na frente do Ivy
                    .width(290.dp)
                    .height(125.dp)
                    .drawBehind {
                        val shadowColor = GreenLight // Usando GreenLight do tema
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
                        color = WhiteLight, // Usando cor do tema
                        shape = RoundedCornerShape(size = OnboardingWelcomeVariables.TextBubbleCornerRadius)
                    )
            )

            // --- Elemento: Texto do Balão de Fala ---
            // Posição: X: 52.5, Y: 217.5
            Text(
                text = buildAnnotatedString {
                    pushStyle(MaterialTheme.typography.titleLarge.copy(fontSize = 21.92.sp, color = GreyMedium).toSpanStyle())
                    append("Parabéns por começar!\n")
                    pop()
                    pushStyle(MaterialTheme.typography.titleSmall.copy(color = GreyMedium).toSpanStyle())
                    append("Eu sou o ")
                    withStyle(style = SpanStyle(color = PurpleNormal)) { append("Ivy") }
                    append(", seu guia nessa jornada de\n")
                    withStyle(style = SpanStyle(color = GreenDark)) { append("superação") } // Usando GreenDark do tema
                    append(" dos seus vícios. Vamos \n")
                    append("juntos nessa ")
                    withStyle(style = SpanStyle(color = PurpleNormal)) { append("transformação") }
                    append("?")
                    pop()
                },
                textAlign = TextAlign.Center,
                fontFamily = DinNext, // Usando DinNext do tema
                lineHeight = 1.4.em, // Usando 140% do tamanho da fonte
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 52.5.dp, y = 217.5.dp)
                    .width(285.dp)
                    .wrapContentHeight()
                    .zIndex(2.2f)
            )

            // --- Elemento: ic_polygon.xml (Triângulo do balão) ---
            // Posição: X: 205.46, Y: 355
            Image(
                painter = painterResource(id = R.drawable.ic_polygon), // Certifique-se que R.drawable.ic_polygon existe
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 205.46.dp, y = 355.dp)
                    .width(22.47.dp)
                    .height(18.72.dp)
                    .zIndex(2.1f)
            )

            // --- Elemento: Botão "VAMOS LÁ" ---
            // Posição do wrapper Box: X: 16, Y: 762
            Box(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 16.dp, y = 762.dp)
                    .width(OnboardingWelcomeVariables.ButtonWidth)
                    .height(OnboardingWelcomeVariables.ButtonHeight)
                    .zIndex(3f)
            ) {
                PrimaryButton(
                    text = "VAMOS LÁ",
                    onClick = onNavigateNext,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 390, heightDp = 844)
@Composable
fun OnboardingWelcomeScreenPreview() {
    OnboardingWelcomeScreen(onNavigateNext = {})
}