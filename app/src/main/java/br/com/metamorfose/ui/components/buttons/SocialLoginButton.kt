/**
 * File: SocialLoginButton.kt
 * Description: Componente de botão de login social genérico para diferentes plataformas, com ícone e texto.
 *
 * Responsabilidades:
 * - Cria botões de login para plataformas sociais como Google, Facebook, etc.
 * - Oferece personalização de cor de fundo, borda, ícones, texto e sombra.
 * - Adiciona feedback visual ao pressionar o botão, com a sombra desaparecendo.
 *
 * Author: Evelin Cordeiro
 * Created on: 29-04-2025
 * Last modified: 30-04-2025
 * Version: 1.0.0
 * Squad: Metamorfose
 *
 */

package br.com.metamorfose.ui.components.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.com.metamorfose.ui.theme.GreyLightest
import br.com.metamorfose.ui.theme.WhiteLight
import br.com.metamorfose.R
import br.com.metamorfose.ui.theme.MetamorfoseTheme
import br.com.metamorfose.ui.theme.Typography

/**
 * @param text Texto a ser exibido no botão, que representa a plataforma de login (ex: "Google", "Facebook").
 * @param onClick Função de callback chamada quando o botão é clicado, permitindo realizar ações como autenticação social.
 * @param icon Composable que define o ícone exibido ao lado do texto. Pode ser um ícone da plataforma (como Google, Facebook, etc.).
 * @param backgroundColor Cor de fundo do botão, para garantir que ele combine com o tema do aplicativo.
 * @param strokeColor Cor da borda do botão, que adiciona um contorno ao botão.
 * @param textColor Cor do texto do botão, garantindo que o texto seja legível.
 * @param shadowColor Cor da sombra do botão, dando um efeito de elevação.
 * @param height Altura do botão. O valor padrão é 48.dp, mas pode ser ajustado conforme necessário.
 * @param width Largura do botão. O valor padrão é 155.dp, mas pode ser ajustado para se adequar ao layout.
 * @param cornerRadius Raio de arredondamento das bordas do botão. O valor padrão é 16.dp.
 * @param modifier Modificador opcional para personalizar a aparência e o comportamento do botão, como aplicação de margens ou animações.
 *
 * Exemplo de uso:
 * ```kotlin
 * SocialLoginButton(
 *     text = "Google",
 *     onClick = { /* Ação de login com Google */ },
 *     icon = {
 *         Image(
 *             painter = painterResource(id = R.drawable.ic_google_logo),
 *             contentDescription = "Google",
 *             modifier = Modifier
 *                 .width(20.dp)
 *                 .height(20.dp)
 *         )
 *     },
 *     backgroundColor = WhiteLight,
 *     strokeColor = Color(0xFFE5E5E5),
 *     textColor = Color(0xFF4285F4),
 *     shadowColor = GreyLightest
 * )
 * ```
 */
@Composable
fun SocialLoginButton(
    text: String,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    backgroundColor: Color,
    strokeColor: Color,
    textColor: Color,
    shadowColor: Color,
    height: Dp = 48.dp,
    width: Dp = 155.dp,
    cornerRadius: Dp = 16.dp,
    modifier: Modifier = Modifier
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    Box(
        modifier = modifier
            .height(height)
            .width(width)
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
                BorderStroke(2.dp, strokeColor),
                shape = RoundedCornerShape(cornerRadius)
            )
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            icon()
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = text.uppercase(),
                color = textColor,
                style = Typography.labelLarge.copy()
            )
        }
    }
}

/**
 * Preview do SocialLoginButton exibindo um exemplo de botão de login com ícone e texto.
 */
@Preview(showBackground = true)
@Composable
fun SocialLoginButtonPreview() {
    MetamorfoseTheme {
        SocialLoginButton(
            text = "Facebook",
            onClick = {},
            icon = {
                Image(
                    painter = painterResource(id = R.drawable.ic_facebook_logo),
                    contentDescription = "Facebook",
                    modifier = Modifier
                        .width(20.dp)
                        .height(21.dp)
                )
            },
            backgroundColor = WhiteLight,
            strokeColor = Color(0xFFE5E5E5),
            textColor = Color(0xFF4285F4),
            shadowColor = GreyLightest
        )
    }
}