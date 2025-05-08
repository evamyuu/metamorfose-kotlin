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
 * Last modified: 08-05-2025
 * Version: 2.0.0
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
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue

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
    modifier: Modifier = Modifier
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    CustomButton(
        text,
        onClick,
        textColor = WhiteLight,
        strokeColor = PurpleNormal,
        shadowColor = PurpleDarken,
        backgroundColor = PurpleNormal
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