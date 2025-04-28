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

/**
 * Componente de botão primário (usado para ações principais na interface do usuário),
 * como "Entrar", "Cadastrar", "Confirmar", etc. Ele possui personalização de cor, altura, borda, sombra e estilo
 * de texto. A interação do usuário é definida pelo parâmetro `onClick`.
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
 * PrimaryButton(
 *     text = "Entrar",
 *     onClick = { /* Ação ao clicar no botão */ },
 *     backgroundColor = PurpleNormal,
 *     strokeColor = PurpleDarken,
 *     textColor = WhiteLight,
 *     shadowColor = PurpleDarken
 * )
 * ```
 */
@Composable
fun PrimaryButton(
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
    Box(
        modifier = modifier
            .drawBehind {
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
            .fillMaxWidth()
            .height(43.dp)
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(12.dp)
            )
            .border(
                BorderStroke(1.dp, strokeColor),
                shape = RoundedCornerShape(12.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = textColor,
            style = Typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
        )
    }
}

/**
 * Exemplo de como o PrimaryButton pode ser visualizado em uma tela.
 */
@Preview(showBackground = true)
@Composable
fun IgnorarEtapaButtonPreview() {
    MetamorfoseTheme {
        PrimaryButton(
            text = "IGNORAR ESSA ETAPA POR ENQUANTO",
            onClick = {}, // Defina a ação ao clicar
            backgroundColor = PurpleNormal,
            textColor = WhiteLight,
            strokeColor = PurpleNormal,
            shadowColor = PurpleDarken
        )
    }
}
