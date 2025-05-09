/**
 * File: AuthViewModel.kt
 * Description: ViewModel responsável pela gestão da autenticação do app Metamorfose. Este ViewModel controla os estados relacionados ao login e registro de usuário, incluindo validações de entradas e a interação com a interface de usuário.
 *
 * Responsabilidades:
 * - Gerencia os estados de tela de Login e Registro, permitindo a troca entre os dois modos (Login e Registro).
 * - Controla a visibilidade da senha, alternando entre visível e oculta.
 * - Realiza a validação de e-mail, senha, nome de usuário e telefone durante os processos de login e registro.
 * - Interage com plataformas externas como Google e Facebook para login.
 * - Gerencia o processo de autenticação, incluindo a exibição de mensagens de erro e feedback de carregamento.
 *
 * Author: Evelin Cordeiro
 * Created on: 28-04-2025
 * Last modified: 30-04-2025
 * Version: 1.0.0
 * Squad: Metamorfose
 *
 * Example of Usage:
 * - Este ViewModel é usado na tela de autenticação (Login/Registro) para controlar a lógica de login e registro.
 * - Permite alternar entre os modos de login e registro, validar entradas de usuário e interagir com o sistema de autenticação do app.
 */

package br.com.metamorfose.ui.screens.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.metamorfose.ui.state.auth.AuthScreenMode
import br.com.metamorfose.ui.state.auth.AuthState
import br.com.metamorfose.ui.state.auth.LoginState
import br.com.metamorfose.ui.state.auth.RegisterState
import br.com.metamorfose.ui.state.auth.ValidationState
import br.com.metamorfose.utils.validators.InputValidators.validateEmail
import br.com.metamorfose.utils.validators.InputValidators.validatePassword
import br.com.metamorfose.utils.validators.InputValidators.validatePhone
import br.com.metamorfose.utils.validators.InputValidators.validateUsername
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * ViewModel responsável pela autenticação do usuário no app Metamorfose.
 * Este ViewModel gerencia os estados de Login e Registro, realiza validações de entradas de usuário e controla a interação com a interface de autenticação.
 */
class AuthViewModel : ViewModel() {

    // MutableStateFlow para gerenciar o estado atual da autenticação
    private val _authState = MutableStateFlow(AuthState())

    // Estado público de autenticação, acessível por outros componentes da UI
    val authState: StateFlow<AuthState> = _authState.asStateFlow()

    // Obtém o modo atual da tela de autenticação (Login ou Registro)
    val mode: AuthScreenMode
        get() = _authState.value.mode

    // Obtém o estado atual do login
    val loginState: LoginState
        get() = _authState.value.loginState

    // Obtém o estado atual do registro
    val registerState: RegisterState
        get() = _authState.value.registerState

    // Obtém o status da visibilidade da senha
    val eyesOpen: Boolean
        get() = _authState.value.eyesOpen

    /**
     * Função que alterna a tela para o modo Login.
     * Altera o estado do ViewModel para indicar que a tela deve exibir o formulário de login.
     */
    fun switchToLogin() {
        _authState.update { it.copy(mode = AuthScreenMode.Login) }
    }

    /**
     * Função que alterna a tela para o modo Registro.
     * Altera o estado do ViewModel para indicar que a tela deve exibir o formulário de registro.
     */
    fun switchToRegister() {
        _authState.update { it.copy(mode = AuthScreenMode.Register) }
    }

    /**
     * Função para alternar a visibilidade da senha entre oculta e visível.
     * A visibilidade é controlada por um ícone de "olho" e altera o estado de `eyesOpen`.
     */
    fun togglePasswordVisibility() {
        when (mode) {
            is AuthScreenMode.Login -> {
                val newPasswordVisibility = !loginState.isPasswordVisible
                _authState.update {
                    it.copy(
                        loginState = it.loginState.copy(
                            isPasswordVisible = newPasswordVisibility
                        ),
                        eyesOpen = !newPasswordVisibility
                    )
                }
            }
            is AuthScreenMode.Register -> {
                val newPasswordVisibility = !registerState.isPasswordVisible
                _authState.update {
                    it.copy(
                        registerState = it.registerState.copy(
                            isPasswordVisible = newPasswordVisibility
                        ),
                        eyesOpen = !newPasswordVisibility
                    )
                }
            }
        }
    }

    /**
     * Função para atualizar o e-mail no estado de login e validar o formato.
     * A validação é realizada através do método `validateEmail`, que verifica a conformidade do e-mail.
     * A validação é refletida no estado de erro do campo.
     *
     * @param email O e-mail inserido pelo usuário.
     */
    fun updateLoginEmail(email: String) {
        val validation = validateEmail(email)
        _authState.update {
            it.copy(
                loginState = it.loginState.copy(
                    email = email,
                    emailValidation = validation
                )
            )
        }
    }

    /**
     * Função para atualizar a senha no estado de login e validar o formato.
     * A senha é validada através do método `validatePassword`.
     *
     * @param password A senha inserida pelo usuário.
     */
    fun updateLoginPassword(password: String) {
        val validation = validatePassword(password)
        _authState.update {
            it.copy(
                loginState = it.loginState.copy(
                    password = password,
                    passwordValidation = validation
                )
            )
        }
    }

    /**
     * Função para alternar o estado de "Lembrar-me" no login.
     * Controla a exibição da opção de lembrar o usuário após o login.
     */
    fun toggleRememberMe() {
        _authState.update {
            it.copy(
                loginState = it.loginState.copy(
                    rememberMe = !it.loginState.rememberMe
                )
            )
        }
    }

    /**
     * Função responsável por iniciar o processo de login.
     * Valida o e-mail e a senha antes de iniciar o login. Se os dados forem válidos, o processo de autenticação é disparado.
     * Exibe mensagens de erro caso haja falhas na validação.
     */
    fun login() {
        val emailValidation = validateEmail(loginState.email)
        val passwordValidation = validatePassword(loginState.password)

        _authState.update {
            it.copy(
                loginState = it.loginState.copy(
                    emailValidation = emailValidation,
                    passwordValidation = passwordValidation
                )
            )
        }

        if (emailValidation != null || passwordValidation != null) {
            return
        }

        viewModelScope.launch {
            _authState.update {
                it.copy(loginState = it.loginState.copy(isLoading = true))
            }

            try {
                // Simula uma requisição de login
                kotlinx.coroutines.delay(1000)

                _authState.update {
                    it.copy(loginState = it.loginState.copy(
                        isLoading = false,
                        errorMessage = null
                    ))
                }

            } catch (e: Exception) {
                _authState.update {
                    it.copy(loginState = it.loginState.copy(
                        isLoading = false,
                        errorMessage = "Falha ao fazer login: ${e.message}"
                    ))
                }
            }
        }
    }

    /**
     * Função para realizar o login com a conta do Google.
     * Esta função estará vinculada a um fluxo de autenticação do Google.
     */
    fun loginWithGoogle() {
        viewModelScope.launch {
        }
    }

    /**
     * Função para realizar o login com a conta do Facebook.
     * Esta função estará vinculada a um fluxo de autenticação do Facebook.
     */
    fun loginWithFacebook() {
        viewModelScope.launch {
        }
    }

    /**
     * Função para iniciar o processo de recuperação de senha.
     * Normalmente envolve o envio de um link para o e-mail fornecido para redefinir a senha.
     */
    fun forgotPassword() {
        viewModelScope.launch {
        }
    }

    /**
     * Função para atualizar o nome de usuário no estado de registro e validar o formato.
     * A validação é realizada através do método `validateUsername`.
     *
     * @param username O nome de usuário inserido pelo usuário.
     */
    fun updateUsername(username: String) {
        val validation = ValidationState(
            isValid = validateUsername(username) == null,
            errorMessage = validateUsername(username)
        )

        _authState.update {
            it.copy(
                registerState = it.registerState.copy(
                    username = username,
                    usernameValidation = validation
                )
            )
        }
    }

    /**
     * Função para atualizar o telefone no estado de registro e validar o formato.
     * A validação é realizada através do método `validatePhone`.
     *
     * @param phone O número de telefone inserido pelo usuário.
     */
    fun updatePhone(phone: String) {
        val validation = ValidationState(
            isValid = validatePhone(phone) == null,
            errorMessage = validatePhone(phone)
        )

        _authState.update {
            it.copy(
                registerState = it.registerState.copy(
                    phone = phone,
                    phoneValidation = validation
                )
            )
        }
    }

    /**
     * Função para atualizar o e-mail no estado de registro e validar o formato.
     * A validação é realizada através do método `validateEmail`.
     *
     * @param email O e-mail inserido pelo usuário.
     */
    fun updateEmail(email: String) {
        val validation = ValidationState(
            isValid = validateEmail(email) == null,
            errorMessage = validateEmail(email)
        )

        _authState.update {
            it.copy(
                registerState = it.registerState.copy(
                    email = email,
                    emailValidation = validation
                )
            )
        }
    }

    /**
     * Função para atualizar a senha no estado de registro e validar o formato.
     * A validação é realizada através do método `validatePassword`.
     *
     * @param password A senha inserida pelo usuário.
     */
    fun updatePassword(password: String) {
        val validation = ValidationState(
            isValid = validatePassword(password) == null,
            errorMessage = validatePassword(password)
        )

        _authState.update {
            it.copy(
                registerState = it.registerState.copy(
                    password = password,
                    passwordValidation = validation
                )
            )
        }
    }

    /**
     * Função responsável por iniciar o processo de registro.
     * Realiza a validação de nome de usuário, telefone, e-mail e senha antes de tentar registrar o usuário.
     * Se as validações forem bem-sucedidas, o processo de registro é disparado.
     */
    fun register() {
        val usernameValidation = ValidationState(
            isValid = validateUsername(registerState.username) == null,
            errorMessage = validateUsername(registerState.username)
        )

        val phoneValidation = ValidationState(
            isValid = validatePhone(registerState.phone) == null,
            errorMessage = validatePhone(registerState.phone)
        )

        val emailValidation = ValidationState(
            isValid = validateEmail(registerState.email) == null,
            errorMessage = validateEmail(registerState.email)
        )

        val passwordValidation = ValidationState(
            isValid = validatePassword(registerState.password) == null,
            errorMessage = validatePassword(registerState.password)
        )

        _authState.update {
            it.copy(
                registerState = it.registerState.copy(
                    usernameValidation = usernameValidation,
                    phoneValidation = phoneValidation,
                    emailValidation = emailValidation,
                    passwordValidation = passwordValidation
                )
            )
        }

        if (!usernameValidation.isValid ||
            !phoneValidation.isValid ||
            !emailValidation.isValid ||
            !passwordValidation.isValid) {
            return
        }

        viewModelScope.launch {
            _authState.update {
                it.copy(registerState = it.registerState.copy(isLoading = true))
            }

            try {
                // Simula uma requisição de registro
                kotlinx.coroutines.delay(1500)

                _authState.update {
                    it.copy(registerState = it.registerState.copy(
                        isLoading = false,
                        errorMessage = null
                    ))
                }

            } catch (e: Exception) {
                _authState.update {
                    it.copy(registerState = it.registerState.copy(
                        isLoading = false,
                        errorMessage = "Falha ao registrar: ${e.message}"
                    ))
                }
            }
        }
    }
}
