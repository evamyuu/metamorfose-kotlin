/**
 * File: AuthScreen.kt
 * Description: Tela de autenticação do app Metamorfose. Responsável por exibir a interface de login e cadastro de usuários.
 *
 * Responsabilidades:
 * - Exibe a tela de autenticação, permitindo alternar entre as opções de login e cadastro.
 * - Inclui opções de login social (Google, Facebook) e controles para visibilidade de senha.
 *
 * Author: Evelin Cordeiro
 * Created on: 28-04-2025
 * Last modified: 08-05-2025
 * Version: 2.0.0
 * Squad: Metamorfose
 *
 */

package br.com.metamorfose.ui.screens.auth

import CustomTextField
import Separator
import TermsText
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.metamorfose.R
import br.com.metamorfose.ui.components.buttons.PrimaryButton
import br.com.metamorfose.ui.components.buttons.SocialLoginButton
import br.com.metamorfose.ui.components.buttons.ToggleButtonGroup
import br.com.metamorfose.ui.components.inputs.CheckboxWithText
import br.com.metamorfose.ui.components.inputs.PasswordTextField
import br.com.metamorfose.ui.components.ivy.IvyCharacter
import br.com.metamorfose.ui.components.layout.CardContainer
import br.com.metamorfose.ui.components.layout.GradientBackground
import br.com.metamorfose.ui.state.auth.AuthScreenMode
import br.com.metamorfose.ui.theme.BlackLight
import br.com.metamorfose.ui.theme.DefaultButtonShadow
import br.com.metamorfose.ui.theme.GreyLight
import br.com.metamorfose.ui.theme.PurpleDarken
import br.com.metamorfose.ui.theme.PurpleNormal
import br.com.metamorfose.ui.theme.Typography
import br.com.metamorfose.ui.theme.WhiteDark
import br.com.metamorfose.ui.theme.WhiteLight

/**
 * Tela principal de autenticação.
 *
 * @param viewModel ViewModel de autenticação contendo os estados de login e cadastro.
 * @param onNavigateToPlantSetup Callback acionado após login/registro bem-sucedido para navegar para a tela de setup da planta.
 */
@Composable
fun AuthScreen(
    viewModel: AuthViewModel = viewModel(),
    onNavigateToPlantSetup: () -> Unit = {},
    onBackClick: () -> Unit
) {
    val authState by viewModel.authState.collectAsState()
    val scrollState = rememberScrollState()

    GradientBackground {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Botão de voltar
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(WindowInsets.systemBars.asPaddingValues())
            ) {
                IconButton(
                    onClick = onBackClick,
                    modifier = Modifier.align(Alignment.CenterStart)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.ArrowBack,
                        contentDescription = "Voltar",
                        tint = BlackLight
                    )
                }
            }

            // Conteúdo principal com Ivy e Card
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.TopCenter
            ) {
                IvyCharacter(
                    eyesOpen = authState.eyesOpen,
                    size = 283f
                )

                CardContainer(
                    modifier = Modifier.padding(top = 240.dp)
                ) {
                    // Alternância entre "Entrar" e "Cadastrar-se"
                    ToggleButtonGroup(
                        options = listOf("Entrar", "Cadastrar-se"),
                        selectedIndex = if (authState.mode is AuthScreenMode.Login) 0 else 1,
                        onSelectionChanged = { index ->
                            if (index == 0) viewModel.switchToLogin()
                            else viewModel.switchToRegister()
                        },
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )

                    // Conteúdo dinâmico
                    when (authState.mode) {
                        is AuthScreenMode.Login -> LoginContent(
                            viewModel = viewModel,
                            onLoginClick = onNavigateToPlantSetup
                        )
                        is AuthScreenMode.Register -> RegisterContent(
                            viewModel = viewModel,
                            onRegisterClick = onNavigateToPlantSetup
                        )
                    }

                    // Texto com termos de uso
                    TermsText(
                        modifier = Modifier
                            .padding(bottom = 16.dp)
                            .navigationBarsPadding()
                    )
                }
            }
        }
    }
}

/**
 * Conteúdo da aba de Login.
 *
 * Exibe os campos de e-mail, senha, lembrete e botões sociais.
 *
 * @param viewModel ViewModel que mantém o estado da tela de login.
 * @param onLoginClick Callback acionado quando o usuário clica no botão de login.
 */
@Composable
private fun LoginContent(
    viewModel: AuthViewModel,
    onLoginClick: () -> Unit,
) {
    val loginState = viewModel.loginState

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Campo de e-mail ou nome de usuário
        CustomTextField(
            value = loginState.email,
            onValueChange = viewModel::updateLoginEmail,
            placeholder = "E-mail, telefone ou nome de usuário",
            leadingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.ic_email),
                    contentDescription = "E-mail",
                    modifier = Modifier.size(24.dp)
                )
            },
            isError = loginState.emailValidation != null,
            errorMessage = loginState.emailValidation,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        // Campo de senha com visibilidade alternável
        PasswordTextField(
            value = loginState.password,
            onValueChange = viewModel::updateLoginPassword,
            leadingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.ic_lock),
                    contentDescription = "Senha",
                    modifier = Modifier.size(24.dp)
                )
            },
            isError = loginState.passwordValidation != null,
            errorMessage = loginState.passwordValidation,
            onTogglePasswordVisibility = viewModel::togglePasswordVisibility,
            isPasswordVisible = loginState.isPasswordVisible,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        // Linha com checkbox "Lembrar-me" e link "Esqueceu a senha?"
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CheckboxWithText(
                checked = loginState.rememberMe,
                onCheckedChange = { viewModel.toggleRememberMe() },
                text = "Lembrar-me"
            )
            TextButton(
                onClick = viewModel::forgotPassword,
                Modifier.offset(x = (12).dp)
            ) {
                Text(
                    text = "Esqueceu a senha?",
                    style = Typography.titleSmall,
                    color = PurpleNormal
                )
            }
        }

        // Botão principal de login
        PrimaryButton(
            text = "ENTRAR",
            onClick = {
                viewModel.login()
                onLoginClick()
            },
            modifier = Modifier.padding(vertical = 16.dp)
        )

        // Divisor "OU"
        Separator(
            modifier = Modifier.padding(vertical = 16.dp),
            text = "OU",
            dividerColor = WhiteDark,
            textColor = GreyLight
        )

        // Botões de login social
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            SocialLoginButton(
                text = "Google",
                onClick = {
                    viewModel.loginWithGoogle()
                    onLoginClick()
                },
                icon = {
                    Image(
                        painter = painterResource(id = R.drawable.ic_google_logo),
                        contentDescription = "Google",
                        modifier = Modifier.size(21.dp)
                    )
                },
                backgroundColor = WhiteLight,
                strokeColor = Color(0xFFE5E5E5),
                textColor = Color(0xFF4285F4),
                shadowColor = DefaultButtonShadow,
                modifier = Modifier.weight(1f)
            )
            SocialLoginButton(
                text = "Facebook",
                onClick = {
                    viewModel.loginWithFacebook()
                    onLoginClick()
                },
                icon = {
                    Image(
                        painter = painterResource(id = R.drawable.ic_facebook_logo),
                        contentDescription = "Facebook",
                        modifier = Modifier.size(21.dp)
                    )
                },
                backgroundColor = WhiteLight,
                strokeColor = Color(0xFFE5E5E5),
                textColor = Color(0xFF1877F2),
                shadowColor = DefaultButtonShadow,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

/**
 * Conteúdo da aba de Cadastro.
 *
 * Campos reativos para nome, telefone, e-mail e senha, além de suporte a login social.
 *
 * @param viewModel ViewModel contendo o estado da tela de registro.
 * @param onRegisterClick Callback acionado quando o usuário clica no botão de registro.
 */
@Composable
private fun RegisterContent(
    viewModel: AuthViewModel,
    onRegisterClick: () -> Unit
) {
    val registerState = viewModel.registerState

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomTextField(
            value = registerState.username,
            onValueChange = viewModel::updateUsername,
            placeholder = "Username",
            leadingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.ic_user),
                    contentDescription = "Username",
                    modifier = Modifier.size(24.dp)
                )
            },
            isError = registerState.usernameValidation.errorMessage != null,
            errorMessage = registerState.usernameValidation.errorMessage,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        CustomTextField(
            value = registerState.phone,
            onValueChange = viewModel::updatePhone,
            placeholder = "Telefone",
            leadingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.ic_phone),
                    contentDescription = "Telefone",
                    modifier = Modifier.size(24.dp)
                )
            },
            isError = registerState.phoneValidation.errorMessage != null,
            errorMessage = registerState.phoneValidation.errorMessage,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        CustomTextField(
            value = registerState.email,
            onValueChange = viewModel::updateEmail,
            placeholder = "E-mail",
            leadingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.ic_email),
                    contentDescription = "E-mail",
                    modifier = Modifier.size(24.dp)
                )
            },
            isError = registerState.emailValidation.errorMessage != null,
            errorMessage = registerState.emailValidation.errorMessage,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        PasswordTextField(
            value = registerState.password,
            onValueChange = viewModel::updatePassword,
            leadingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.ic_lock),
                    contentDescription = "Senha",
                    modifier = Modifier.size(24.dp)
                )
            },
            isError = registerState.passwordValidation.errorMessage != null,
            errorMessage = registerState.passwordValidation.errorMessage,
            onTogglePasswordVisibility = viewModel::togglePasswordVisibility,
            isPasswordVisible = registerState.isPasswordVisible,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        PrimaryButton(
            text = "CRIAR CONTA",
            onClick = {
                viewModel.register()
                onRegisterClick()
            },
            modifier = Modifier.padding(vertical = 16.dp)
        )

        Separator(
            modifier = Modifier.padding(vertical = 16.dp),
            text = "OU",
            dividerColor = WhiteDark,
            textColor = GreyLight
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            SocialLoginButton(
                text = "Google",
                onClick = {
                    viewModel.loginWithGoogle()
                    onRegisterClick()
                },
                icon = {
                    Image(
                        painter = painterResource(id = R.drawable.ic_google_logo),
                        contentDescription = "Google",
                        modifier = Modifier.size(21.dp)
                    )
                },
                backgroundColor = WhiteLight,
                strokeColor = Color(0xFFE5E5E5),
                textColor = Color(0xFF4285F4),
                shadowColor = DefaultButtonShadow,
                modifier = Modifier.weight(1f)
            )

            SocialLoginButton(
                text = "Facebook",
                onClick = {
                    viewModel.loginWithFacebook()
                    onRegisterClick()
                },
                icon = {
                    Image(
                        painter = painterResource(id = R.drawable.ic_facebook_logo),
                        contentDescription = "Facebook",
                        modifier = Modifier.size(21.dp)
                    )
                },
                backgroundColor = WhiteLight,
                strokeColor = Color(0xFFE5E5E5),
                textColor = Color(0xFF1877F2),
                shadowColor = DefaultButtonShadow,
                modifier = Modifier.weight(1f)
            )
        }
    }
}


@Preview(showBackground = true, name = "Auth Screen - Login Mode")
@Composable
fun AuthScreenLoginPreview() {

        AuthScreen(
            onNavigateToPlantSetup = {},
            onBackClick = {}
        )

}

@Preview(showBackground = true, name = "Auth Screen - Register Mode")
@Composable
fun AuthScreenRegisterPreview() {

        val viewModel = AuthViewModel()
        // Muda para o modo de registro
        LaunchedEffect(Unit) {
            viewModel.switchToRegister()
        }

        AuthScreen(
            viewModel = viewModel,
            onNavigateToPlantSetup = {},
            onBackClick = {}
        )

}

@Preview(showBackground = true, name = "Login Content Only")
@Composable
fun LoginContentPreview() {

        CardContainer {
            LoginContent(
                viewModel = AuthViewModel(),
                onLoginClick = {}
            )

    }
}

@Preview(showBackground = true, name = "Register Content Only")
@Composable
fun RegisterContentPreview() {

        CardContainer {
            RegisterContent(
                viewModel = AuthViewModel(),
                onRegisterClick = {}
            )

    }
}

