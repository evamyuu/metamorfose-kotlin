/**
 * File: CustomButton.kt
 * Description: Componente de botão do app Metamorfose. Usado para botões personalizados.
 *
 * Responsabilidades:
 * - Exibe um botão customizado com suporte para sombra, borda, e interação de clique.
 * - Permite personalização de cor de fundo, borda, texto e sombra.
 * - Suporta animações de clique e transições visuais.
 *
 * Author: Gabriel Souza Teixeira
 * Created on: 08-05-2025
 * Last modified: 30-04-2025
 * Version: 1.0.0
 * Squad: Metamorfose
 *
 */

package br.com.metamorfose.ui.components.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.metamorfose.ui.theme.MetamorfoseTheme
import br.com.metamorfose.ui.theme.PurpleDarken
import br.com.metamorfose.ui.theme.PurpleNormal
import br.com.metamorfose.ui.theme.Typography
import br.com.metamorfose.ui.theme.WhiteLight
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import br.com.metamorfose.ui.theme.GreenDarken
import br.com.metamorfose.ui.theme.GreenNormal

/**
 * Componente de botão genérico (usado para base de outros botões),
 * Ele possui personalização de cor, altura, borda, sombra e estilo de texto. A interação do usuário é definida pelo parâmetro `onClick`.
 *
 * @param text O texto exibido no botão.
 * @param onClick A ação que será executada quando o botão for pressionado.
 * @param backgroundColor Cor de fundo do botão.
 * @param strokeColor Cor da borda do botão.
 * @param textColor Cor do texto exibido no botão.
 * @param shadowColor Cor da sombra do botão, usada para um efeito de profundidade.
 * @param height A altura do botão (padrão 43.dp).
 * @param width A largura do botão (padrão 334.dp, mas geralmente será ajustado automaticamente com fillMaxWidth).
 * @param cornerRadius O raio dos cantos arredondados do botão (padrão 12.dp).
 * @param fontSize O tamanho da fonte do texto do botão (padrão 16.sp).
 * @param modifier Modificador opcional para ajustes como margens e padding.
 *
 * Exemplo de uso:
 * ```kotlin
 * CustomButton(
 *     text = "Entrar",
 *     onClick = { /* Ação ao clicar no botão */ },
 *     backgroundColor = Color,
 *     strokeColor = Color,
 *     textColor = Color,
 *     shadowColor = Color
 * )
 * ```
 */
@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit,
    backgroundColor: Color,
    strokeColor: Color,
    textColor: Color,
    shadowColor: Color,
    height: Dp = 43.dp,
    width: Dp = 334.dp,
    cornerRadius: Dp = 12.dp,
    fontSize: TextUnit = 16.sp,
    modifier: Modifier = Modifier
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    Box(
        modifier = modifier
            .drawBehind {
                if (!isPressed) {
                    val shadowOffsetY = 4.dp.toPx()
                    drawIntoCanvas { canvas ->
                        withTransform({
                            translate(top = shadowOffsetY)
                        }) {
                            drawRoundRect(
                                color = shadowColor,
                                cornerRadius = CornerRadius(12.dp.toPx(), 12.dp.toPx()),
                                size = size
                            )
                        }
                    }
                }
            }
            .fillMaxWidth()
            .height(height)
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(cornerRadius)
            )
            .border(
                BorderStroke(1.dp, strokeColor),
                shape = RoundedCornerShape(cornerRadius)
            )
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = textColor,
            style = Typography.titleSmall.copy(fontWeight = FontWeight.Bold),
            fontSize = fontSize
        )
    }
}

/**
 * Exemplo de como o CustomButton pode ser visualizado em uma tela.
 */
@Preview(showBackground = true)
@Composable
fun CustomButtonPreview() {
    MetamorfoseTheme {
        CustomButton(
            text = "BOTÃO CUSTOMIZADO",
            onClick = {}, // Defina a ação ao clicar
            backgroundColor = GreenNormal,
            textColor = WhiteLight,
            strokeColor = GreenNormal,
            shadowColor = GreenDarken
        )
    }
}