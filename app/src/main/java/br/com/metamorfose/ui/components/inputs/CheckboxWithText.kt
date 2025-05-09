/**
 * File: CheckboxWithText.kt
 * Description: Componente reutilizável de checkbox com texto ao lado, ideal para formulários de consentimento.
 *
 * Responsabilidades:
 * - Exibe um checkbox com um texto explicativo ao lado.
 * - Permite ao usuário interagir com o checkbox e mudar seu estado (marcado/desmarcado).
 * - Usado para aceitar termos de uso, consentimentos ou preferências em formulários.
 *
 * Author: Evelin Cordeiro
 * Created on: 29-04-2025
 * Last modified: 30-04-2025
 * Version: 1.0.0
 * Squad: Metamorfose
 *
 */

package br.com.metamorfose.ui.components.inputs

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.metamorfose.ui.theme.*

/**
 * @param checked Estado atual do checkbox (true se marcado).
 * @param onCheckedChange Callback acionado quando o estado do checkbox muda.
 * @param text Texto exibido ao lado do checkbox.
 * @param modifier Modificador opcional para ajustar o layout externo do componente.
 *
 * Exemplo de uso:
 * ```
 * var isChecked by remember { mutableStateOf(false) }
 *
 * CheckboxWithText(
 *     checked = isChecked,
 *     onCheckedChange = { isChecked = it },
 *     text = "Aceito os termos de uso"
 * )
 * ```
 */
@Composable
fun CheckboxWithText(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    text: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.offset(x = (-12).dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = CheckboxDefaults.colors(
                checkedColor = PurpleNormal,
                uncheckedColor = GreyLight
            )
        )

        Text(
            text = text,
            style = Typography.titleSmall,
            color = GreyLight
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CheckboxWithTextPreview() {
    var checked by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(16.dp)) {
        CheckboxWithText(
            checked = checked,
            onCheckedChange = { checked = it },
            text = "Aceito os termos e condições"
        )
    }
}