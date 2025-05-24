/**
 * File: PrimaryButton.kt
 * Description: Componente de botão primário do app Metamorfose. Usado para ações principais como "Entrar", "Cadastrar", "Confirmar", etc.
 *
 * Responsabilidades:
 * - Exibe um botão primário customizado e interação de clique.
 * - Suporta animações de clique e transições visuais.
 *
 * Author: Evelin Cordeiro
 * Created on: 28-04-2025
 * Last modified: 23-05-2025
 * Version: 2.1.0
 * Squad: Metamorfose
 *
 * Changelog:
 *
 * - [23-05-2025] Modificado para aceitar diferentes tamanhos de textos (por Eve)
 *
 */

package br.com.metamorfose.ui.components.buttons

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.metamorfose.ui.theme.MetamorfoseTheme
import br.com.metamorfose.ui.theme.PurpleDarken
import br.com.metamorfose.ui.theme.PurpleNormal
import br.com.metamorfose.ui.theme.WhiteLight
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

/**
 * Componente de botão primário (usado para ações principais na interface do usuário),
 * como "Entrar", "Cadastrar", "Confirmar", etc. A interação do usuário é definida pelo parâmetro `onClick`.
 *
 * @param text O texto exibido no botão.
 * @param onClick A ação que será executada quando o botão for pressionado.
 * @param modifier Modificador opcional para ajustes como margens e padding.
 *
 * Exemplo de uso:
 * ```kotlin
 * PrimaryButton(
 *     text = "Entrar",
 *     onClick = { /* Ação ao clicar no botão */ }
 * )
 * ```
 */
@Composable
fun PrimaryButton(
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
        textColor = WhiteLight,
        strokeColor = PurpleNormal,
        shadowColor = PurpleDarken,
        backgroundColor = PurpleNormal,
        fontSize = fontSize
    )
}

/**
 * Exemplo de como o PrimaryButton pode ser visualizado em uma tela.
 */
@Preview(showBackground = true)
@Composable
fun PrimaryButtonPreview() {
    MetamorfoseTheme {
        PrimaryButton(
            text = "BOTÃO PRIMÁRIO",
            onClick = {} // Defina a ação ao clicar
        )
    }
}