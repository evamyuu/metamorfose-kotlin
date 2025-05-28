/**
 * File: CustomButton.kt
 * Description: Componente de botão do app Metamorfose. Usado para botões personalizados.
 *
 * Responsabilidades:
 * - Exibe um botão customizado com suporte para sombra, borda, e interação de clique.
 * - Permite personalização de cor de fundo, borda, texto e sombra.
 * - Suporta animações de clique e transições visuais.
 * - Dimensões completamente flexíveis (altura e largura definidas pelo usuário)
 *
 * Author: Evelin Brandão Cordeiro
 * Created on: 23-05-2025
 * Last modified: 23-05-2025
 * Version: 1.3.0
 * Squad: Metamorfose
 *
 * Changelog:
 *
 * - [23-05-2025] Dimensões tornadas completamente flexíveis - usuário pode definir qualquer valor ou usar padrões dinâmicos (por Eve)
 */

package br.com.metamorfose.ui.components.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
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
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import br.com.metamorfose.ui.theme.GreenDarken
import br.com.metamorfose.ui.theme.GreenNormal

/**
 * Componente de botão genérico com dimensões completamente flexíveis.
 * O usuário pode definir altura e largura específicas ou usar comportamentos dinâmicos.
 *
 * @param text O texto exibido no botão.
 * @param onClick A ação que será executada quando o botão for pressionado.
 * @param backgroundColor Cor de fundo do botão.
 * @param strokeColor Cor da borda do botão.
 * @param textColor Cor do texto exibido no botão.
 * @param shadowColor Cor da sombra do botão, usada para um efeito de profundidade.
 * @param height A altura do botão. Se null, ajusta automaticamente ao conteúdo.
 * @param width A largura do botão. Se null, ocupa toda a largura disponível.
 * @param cornerRadius O raio dos cantos arredondados do botão (padrão 12.dp).
 * @param fontSize O tamanho da fonte do texto do botão (padrão 16.sp).
 * @param modifier Modificador opcional para ajustes como margens e padding.
 *
 * Exemplos de uso:
 *
 * // Botão com largura total e altura automática
 * CustomButton(
 *     text = "Botão Dinâmico",
 *     onClick = { },
 *     backgroundColor = GreenNormal,
 *     strokeColor = GreenNormal,
 *     textColor = WhiteLight,
 *     shadowColor = GreenDarken
 * )
 *
 * // Botão com dimensões específicas
 * CustomButton(
 *     text = "Botão Fixo",
 *     onClick = { },
 *     backgroundColor = GreenNormal,
 *     strokeColor = GreenNormal,
 *     textColor = WhiteLight,
 *     shadowColor = GreenDarken,
 *     height = 50.dp,
 *     width = 200.dp
 * )
 *
 * // Botão que se ajusta ao conteúdo
 * CustomButton(
 *     text = "Auto",
 *     onClick = { },
 *     backgroundColor = GreenNormal,
 *     strokeColor = GreenNormal,
 *     textColor = WhiteLight,
 *     shadowColor = GreenDarken,
 *     height = null,
 *     width = null
 * )
 */
@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit,
    backgroundColor: Color,
    strokeColor: Color,
    textColor: Color,
    shadowColor: Color,
    height: Dp? = 43.dp,
    width: Dp? = null,
    cornerRadius: Dp = 12.dp,
    fontSize: TextUnit = 16.sp,
    modifier: Modifier = Modifier
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    val sizeModifier = when {
        height != null && width != null -> Modifier.height(height).width(width)
        height != null && width == null -> Modifier.height(height).fillMaxWidth()
        height == null && width != null -> Modifier.wrapContentHeight().width(width)
        else -> Modifier.wrapContentHeight().wrapContentWidth()
    }

    Box(
        modifier = modifier
            .then(sizeModifier)
            .drawBehind {
                if (!isPressed) {
                    val shadowOffsetY = 4.dp.toPx()
                    drawIntoCanvas { canvas ->
                        withTransform({
                            translate(top = shadowOffsetY)
                        }) {
                            drawRoundRect(
                                color = shadowColor,
                                cornerRadius = CornerRadius(cornerRadius.toPx(), cornerRadius.toPx()),
                                size = size
                            )
                        }
                    }
                }
            }
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
            )
            .padding(horizontal = 16.dp, vertical = 8.dp),
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
 * Preview mostrando diferentes configurações do botão
 */
@Preview(showBackground = true)
@Composable
fun CustomButtonPreview() {
    MetamorfoseTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Botão padrão (altura fixa, largura total)
            CustomButton(
                text = "BOTÃO PADRÃO",
                onClick = {},
                backgroundColor = GreenNormal,
                textColor = WhiteLight,
                strokeColor = GreenNormal,
                shadowColor = GreenDarken
            )

            // Botão com dimensões específicas
            CustomButton(
                text = "BOTÃO PERSONALIZADO",
                onClick = {},
                backgroundColor = PurpleNormal,
                textColor = WhiteLight,
                strokeColor = PurpleNormal,
                shadowColor = PurpleDarken,
                height = 60.dp,
                width = 250.dp
            )

            // Botão que se ajusta ao conteúdo
            CustomButton(
                text = "AUTO",
                onClick = {},
                backgroundColor = GreenNormal,
                textColor = WhiteLight,
                strokeColor = GreenNormal,
                shadowColor = GreenDarken,
                height = null,
                width = null
            )
        }
    }
}