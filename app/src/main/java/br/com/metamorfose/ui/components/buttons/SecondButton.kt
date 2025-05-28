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
 * Last modified: 23-05-2025
 * Version: 1.1.0
 * Squad: Metamorfose
 *
 * Changelog:
 *
 * - [23-05-2025] Cores padrões alteradas de acordo com o Figma,
 *                Modificado para aceitar diferentes tamanhos de textos (por Eve)
 */

package br.com.metamorfose.ui.components.buttons

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import br.com.metamorfose.ui.theme.WhiteLight
import br.com.metamorfose.ui.theme.DefaultButtonShadow
import br.com.metamorfose.ui.theme.MetamorfoseTheme
import br.com.metamorfose.ui.theme.PurpleNormal

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
    modifier: Modifier = Modifier,
    fontSize: TextUnit = 16.sp
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    CustomButton(
        text,
        onClick,
        strokeColor = DefaultButtonShadow,
        textColor = PurpleNormal,
        shadowColor = DefaultButtonShadow,
        backgroundColor = WhiteLight,
        fontSize = fontSize
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