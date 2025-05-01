/**
 * File: CustomTextField.kt
 * Description: Componente customizado e reutilizável de campo de texto, ideal para formulários de entrada de dados.
 * Suporta ícones (início e fim), validação de erro, transformação visual (ocultar senha), e estilo consistente com a identidade visual do Metamorfose.
 *
 * Responsabilidades:
 * - Exibir um campo de texto com várias opções de customização.
 * - Suporte para ícones, placeholders, e transformação do texto.
 * - Exibir estado de erro com uma mensagem opcional.
 * - Configuração de comportamento do teclado e foco.
 *
 * Author: Evelin Cordeiro
 * Created on: 30-04-2025
 * Last modified: 30-04-2025
 * Version: 1.0.0
 * Squad: Metamorfose
 *
 */

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.metamorfose.ui.theme.GreyExtraLight
import br.com.metamorfose.ui.theme.GreyMedium
import br.com.metamorfose.ui.theme.Typography
import br.com.metamorfose.R

/**
 * @param value Valor atual do campo de texto.
 * @param onValueChange Função chamada sempre que o valor do campo for alterado.
 * @param modifier Modificador opcional para ajustes externos (margem, alinhamento etc.).
 * @param placeholder Texto exibido enquanto o campo está vazio.
 * @param leadingIcon Ícone exibido no início do campo (padrão: nulo).
 * @param trailingIcon Ícone exibido no fim do campo (padrão: nulo).
 * @param keyboardType Define o tipo de teclado exibido (ex: KeyboardType.Text, Email, Number).
 * @param imeAction Define a ação do botão do teclado (ex: Next, Done).
 * @param isError Indica se o campo está em estado de erro.
 * @param errorMessage Mensagem de erro exibida abaixo do campo (opcional, usada quando isError for true).
 * @param singleLine Define se o campo será de linha única (padrão: true).
 * @param maxLines Número máximo de linhas que o campo pode ter.
 * @param readOnly Define se o campo será apenas leitura (padrão: false).
 * @param enabled Define se o campo estará habilitado ou desabilitado (padrão: true).
 * @param visualTransformation Transforma a visualização do texto (ex: para ocultar senhas).
 *
 * Exemplo de uso:
 * ```kotlin
 * CustomTextField(
 *     value = email,
 *     onValueChange = { email = it },
 *     placeholder = "Digite seu e-mail",
 *     leadingIcon = {
 *         Image(
 *             painter = painterResource(id = R.drawable.ic_email),
 *             contentDescription = "Ícone de e-mail",
 *             modifier = Modifier.size(24.dp)
 *         )
 *     },
 *     keyboardType = KeyboardType.Email,
 *     imeAction = ImeAction.Next,
 *     isError = emailInvalido,
 *     errorMessage = "E-mail inválido"
 * )
 * ```
 */

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "",
    leadingIcon: @Composable (() -> Unit)? = {},
    trailingIcon: @Composable (() -> Unit)? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    isError: Boolean = false,
    errorMessage: String? = null,
    singleLine: Boolean = true,
    maxLines: Int = 1,
    readOnly: Boolean = false,
    enabled: Boolean = true,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    val focusManager = LocalFocusManager.current

    Column(modifier = modifier) {
        TextField(
            value = value,
            onValueChange = onValueChange,
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
            trailingIcon = trailingIcon,
            singleLine = singleLine,
            maxLines = maxLines,
            readOnly = readOnly,
            enabled = enabled,
            visualTransformation = visualTransformation,
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType,
                imeAction = imeAction
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down) },
                onDone = { focusManager.clearFocus() }
            ),
            isError = isError,
            shape = RoundedCornerShape(12.dp),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent,
                focusedContainerColor = GreyExtraLight,
                unfocusedContainerColor = GreyExtraLight,
                errorContainerColor = GreyExtraLight.copy(alpha = 0.95f)
            ),
            modifier = Modifier
                .width(342.dp)
                .height(48.dp)
                .clip(RoundedCornerShape(12.dp))
                .border(
                    width = 2.dp,
                    color = if (isError) MaterialTheme.colorScheme.error else Color(0xFFE5E5E5),
                    shape = RoundedCornerShape(12.dp)
                )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CustomTextFieldPreview() {
    val value = remember { mutableStateOf("") }

    CustomTextField(
        value = value.value,
        onValueChange = { value.value = it },
        placeholder = "Digite sua mensagem muito longa para ver o efeito...",
        leadingIcon = {
            Image(
                painter = painterResource(id = R.drawable.ic_facebook_logo),
                contentDescription = "E-mail",
                modifier = Modifier.size(24.dp)
            )
        },
        isError = false
    )
}