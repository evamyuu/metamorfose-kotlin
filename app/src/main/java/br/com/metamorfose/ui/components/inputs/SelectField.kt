/**
 * File: SelectField.kt
 * Description: Componente customizado e reutilizável de campo de select, ideal para formulários de entrada de dados.
 * Suporta ícones (início e fim), validação de erro, e estilo consistente com a identidade visual do Metamorfose.
 *
 * Responsabilidades:
 * - Exibir um campo de select com várias opções de customização.
 * - Suporte para ícones, placeholders, e transformação do texto.
 * - Exibir estado de erro com uma mensagem opcional.
 * - Configuração de comportamento do teclado e foco.
 *
 * Author: Gabriel Souza Teixeira
 * Created on: 08-05-2025
 * Last modified: 08-05-2025
 * Version: 1.0.0
 * Squad: Metamorfose
 *
 *  Changelog:
 *
 *  - [23-05-2025] Ajustado as cores do botão ic_arrow up e down adicionando tint = PurpleNormal de acordo com o Figma (por Vinicyus)
 *
 *
 */

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import androidx.compose.ui.res.painterResource
import br.com.metamorfose.R
import br.com.metamorfose.ui.theme.GreyExtraLight
import br.com.metamorfose.ui.theme.GreyMedium
import br.com.metamorfose.ui.theme.PurpleNormal
import br.com.metamorfose.ui.theme.Typography

/**
 * @param selectedOption Opção atualmente selecionada
 * @param options Lista de opções disponíveis para seleção
 * @param onOptionSelected Função chamada quando uma opção é selecionada
 * @param modifier Modificador opcional para ajustes externos (margem, alinhamento etc.)
 * @param enabled Define se o campo estará habilitado ou desabilitado (padrão: true)
 * @param label Texto de label exibido acima do campo (opcional)
 * @param placeholder Texto exibido enquanto nenhuma opção foi selecionada
 * @param leadingIcon Ícone exibido no início do campo (padrão: nulo)
 * @param isError Indica se o campo está em estado de erro
 * @param errorMessage Mensagem de erro exibida abaixo do campo (opcional, usada quando isError for true)
 * @param itemContent Composable personalizado para renderizar cada item na lista de opções (opcional)
 *
 * Exemplo de uso:
 * ```kotlin
 * val options = listOf("Opção 1", "Opção 2", "Opção 3")
 * var selectedOption by remember { mutableStateOf("") }
 *
 * SelectField(
 *     selectedOption = selectedOption,
 *     options = options,
 *     onOptionSelected = { selectedOption = it },
 *     placeholder = "Selecione uma opção",
 *     leadingIcon = {
 *         Image(
 *             painter = painterResource(id = R.drawable.ic_dropdown),
 *             contentDescription = "Ícone de seleção",
 *             modifier = Modifier.size(24.dp)
 *         )
 *     },
 *     isError = false
 * )
 * ```
 */
@Composable
fun SelectField(
    selectedOption: String,
    options: List<String>,
    onOptionSelected: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    label: String? = null,
    placeholder: String = "Selecione uma opção",
    leadingIcon: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    errorMessage: String? = null,
    itemContent: @Composable ((String) -> Unit)? = null
) {
    var expanded by remember { mutableStateOf(false) }
    var textFieldSize by remember { mutableStateOf(androidx.compose.ui.geometry.Size.Zero) }
    val density = LocalDensity.current

    Column(modifier = modifier) {
        Box {
            OutlinedTextField(
                value = selectedOption,
                onValueChange = { },
                readOnly = true,
                enabled = enabled,
                modifier = Modifier
                    .width(342.dp)
                    .height(48.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .border(
                        width = 2.dp,
                        color = if (isError) MaterialTheme.colorScheme.error else Color(0xFFE5E5E5),
                        shape = RoundedCornerShape(12.dp)
                    )
                    .onGloballyPositioned { coordinates ->
                        textFieldSize = coordinates.size.toSize()
                    }
                    .onFocusChanged {
                        if (it.isFocused && enabled) {
                            expanded = true
                        }
                    }
                    .clickable(enabled = enabled) { expanded = !expanded },
                placeholder = {
                    Text(
                        text = placeholder,
                        color = GreyMedium,
                        style = Typography.bodyLarge,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                },
                leadingIcon = leadingIcon,
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = if (expanded) R.drawable.ic_arrow_up else R.drawable.ic_arrow_down),
                        contentDescription = if (expanded) "Fechar seleção" else "Abrir seleção",
                        modifier = Modifier.clickable(enabled = enabled) { expanded = !expanded },
                        tint = PurpleNormal //
                    )
                },
                singleLine = true,
                isError = isError,
                shape = RoundedCornerShape(12.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = GreyExtraLight,
                    unfocusedContainerColor = GreyExtraLight,
                    disabledContainerColor = GreyExtraLight.copy(alpha = 0.7f),
                    errorContainerColor = GreyExtraLight.copy(alpha = 0.95f),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    errorIndicatorColor = Color.Transparent
                ),
                label = label?.let { { Text(text = it) } }
            )

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier
                    .width(with(density) { textFieldSize.width.toDp() })
            ) {
                options.forEach { option ->
                    DropdownMenuItem(
                        text = {
                            if (itemContent != null) {
                                itemContent(option)
                            } else {
                                Text(
                                    text = option,
                                    style = Typography.bodyLarge
                                )
                            }
                        },
                        onClick = {
                            onOptionSelected(option)
                            expanded = false
                        }
                    )
                }
            }
        }

        if (isError && errorMessage != null) {
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error,
                style = Typography.bodySmall,
                modifier = Modifier.padding(start = 16.dp, top = 4.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SelectFieldPreview() {
    val options = listOf("Opção 1", "Opção 2", "Opção 3", "Opção 4")
    var selectedOption by remember { mutableStateOf("") }

    SelectField(
        selectedOption = selectedOption,
        options = options,
        onOptionSelected = { selectedOption = it },
        placeholder = "Selecione uma opção",
        isError = false
    )
}