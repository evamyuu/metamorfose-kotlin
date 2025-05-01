/**
 * File: PasswordTextField.kt
 * Description: Componente customizado para campos de senha, com um ícone para alternar a visibilidade da senha.
 * Este componente encapsula o campo de senha reutilizável `CustomTextField`, adicionando funcionalidade para mostrar/ocultar a senha.
 *
 * Responsabilidades:
 * - Exibir um campo de senha com ícone de visibilidade alternável.
 * - Utilizar `CustomTextField` para reaproveitar comportamentos comuns.
 * - Permitir alternar a visibilidade da senha com um ícone de "olho".
 * - Suporte a erro de validação e visualização do texto de senha (ocultar ou mostrar).
 *
 * Author: Evelin Cordeiro
 * Created on: 30-04-2025
 * Last modified: 30-04-2025
 * Version: 1.0.0
 * Squad: Metamorfose
 *
 */

package br.com.metamorfose.ui.components.inputs

import CustomTextField
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.metamorfose.R

/**
 * @param value Texto atual do campo.
 * @param onValueChange Função chamada quando o texto é alterado.
 * @param modifier Modificador opcional para customização externa.
 * @param placeholder Texto exibido como dica no campo (padrão: "Senha").
 * @param leadingIcon Ícone opcional exibido no início do campo.
 * @param imeAction Ação do teclado IME (padrão: ImeAction.Done).
 * @param isError Indica se o campo está em estado de erro.
 * @param errorMessage Mensagem de erro a ser exibida (se houver).
 * @param enabled Indica se o campo está habilitado para edição.
 * @param onTogglePasswordVisibility Função chamada ao clicar no botão de visibilidade.
 * @param isPasswordVisible Estado atual da visibilidade da senha (true se visível).
 *
 * Exemplo de uso:
 * ```
 * var password by remember { mutableStateOf("") }
 * var isPasswordVisible by remember { mutableStateOf(false) }
 *
 * PasswordTextField(
 *     value = password,
 *     onValueChange = { password = it },
 *     isPasswordVisible = isPasswordVisible,
 *     onTogglePasswordVisibility = { isPasswordVisible = !isPasswordVisible }
 * )
 * ```
 */
@Composable
fun PasswordTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "Senha",
    leadingIcon: @Composable (() -> Unit)? = null,
    imeAction: ImeAction = ImeAction.Done,
    isError: Boolean = false,
    errorMessage: String? = null,
    enabled: Boolean = true,
    onTogglePasswordVisibility: () -> Unit,
    isPasswordVisible: Boolean = false
) {
    CustomTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = placeholder,
        leadingIcon = leadingIcon,
        trailingIcon = {
            IconButton(onClick = onTogglePasswordVisibility) {
                Image(
                    painter = if (isPasswordVisible) {
                        painterResource(id = R.drawable.ic_visibility_on)
                    } else {
                        painterResource(id = R.drawable.ic_visibility_off)
                    },
                    contentDescription = if (isPasswordVisible) {
                        "Ocultar senha"
                    } else {
                        "Mostrar senha"
                    },
                    modifier = Modifier.size(24.dp)
                )
            }
        },
        keyboardType = KeyboardType.Password,
        imeAction = imeAction,
        isError = isError,
        errorMessage = errorMessage,
        enabled = enabled,
        visualTransformation = if (isPasswordVisible) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun PasswordTextFieldPreview() {
    var password by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(16.dp)) {
        PasswordTextField(
            value = password,
            onValueChange = { password = it },
            isPasswordVisible = isPasswordVisible,
            onTogglePasswordVisibility = { isPasswordVisible = !isPasswordVisible }
        )
    }
}