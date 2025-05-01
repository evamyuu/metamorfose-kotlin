/**
 * File: SecondButton.kt
 * Description: Componente de botão secundário genérico para diferentes casos, somente com texto.
 *
 * Responsabilidades:
 * - Cria botões de ações secundárias.
 * - Adiciona feedback visual ao pressionar o botão, com a sombra desaparecendo.
 *
 * Author: Gabriel Souza Teixeira
 * Created on: 08-05-2025
 * Last modified: 08-05-2025
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
import br.com.metamorfose.ui.theme.DefaultButtonShadow
import br.com.metamorfose.ui.theme.GreyMedium
import br.com.metamorfose.ui.theme.MetamorfoseTheme
import br.com.metamorfose.ui.theme.Typography

/**
 * @param text Texto a ser exibido no botão.
 * @param onClick Função de callback chamada quando o botão é clicado, permitindo realizar ações.
 * @param modifier Modificador opcional para personalizar a aparência e o comportamento do botão, como aplicação de margens ou animações.
 *
 * Exemplo de uso:
 * ```kotlin
 * SecondButton(
 *     text = "Texto",
 *     onClick = { /* Ação aqui */ }
 * )
 * ```
 */
@Composable
fun SecondButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    CustomButton(
        text,
        onClick,
        strokeColor = DefaultButtonShadow,
        textColor = GreyMedium,
        shadowColor = GreyLightest,
        backgroundColor = WhiteLight
    )
}

/**
 * Preview do SecondButton exibindo um exemplo de botão com texto.
 */
@Preview(showBackground = true)
@Composable
fun SecondButtonPreview() {
    MetamorfoseTheme {
        SecondButton(
            text = "BOTÃO SECUNDÁRIO",
            onClick = {}
        )
    }
}