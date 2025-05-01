/**
 * File: AuthState.kt
 * Description: Gerencia o estado da tela de autenticação (Login/Registro) no app Metamorfose.
 *              Contém as classes e estados para validação de campos e controle de erros durante o processo de autenticação.
 *
 * Responsabilidades:
 * - Gerenciar o estado de login e registro, incluindo informações de email, senha, e validação dos campos.
 * - Controlar o estado de visibilidade da senha e o progresso de carregamento (isLoading).
 * - Fornecer suporte para alternar entre os modos de autenticação (Login e Registro).
 *
 * Author: Evelin Cordeiro
 * Created on: 28-04-2025
 * Last modified: 30-04-2025
 * Version: 1.0.0
 * Squad: Metamorfose
 *
 */

package br.com.metamorfose.ui.state.auth

/**
 * Representa os modos disponíveis para a tela de autenticação.
 *
 * Pode ser:
 * - [Login]: Para usuários existentes acessarem sua conta.
 * - [Register]: Para novos usuários criarem uma conta.
 */
sealed class AuthScreenMode {
    object Login : AuthScreenMode()
    object Register : AuthScreenMode()
}

/**
 * Representa o estado da validação de um campo de entrada.
 *
 * @param isValid Indica se o campo está válido ou não.
 * @param errorMessage Mensagem de erro a ser exibida quando inválido (opcional).
 */
data class ValidationState(
    val isValid: Boolean = true,
    val errorMessage: String? = null
)

/**
 * Contém o estado atual da tela de login.
 *
 * @param email Email informado pelo usuário.
 * @param emailValidation Mensagem de erro do campo de email (caso inválido).
 * @param password Senha informada pelo usuário.
 * @param passwordValidation Mensagem de erro do campo de senha (caso inválido).
 * @param rememberMe Indica se o usuário deseja manter-se conectado.
 * @param isPasswordVisible Define se a senha está visível no campo.
 * @param isLoading Indica se a operação de login está em andamento.
 * @param errorMessage Mensagem de erro geral do login (ex: falha de autenticação).
 */
data class LoginState(
    val email: String = "",
    val emailValidation: String? = null,
    val password: String = "",
    val passwordValidation: String? = null,
    val rememberMe: Boolean = false,
    val isPasswordVisible: Boolean = false,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)

/**
 * Contém o estado atual da tela de registro.
 *
 * @param username Nome de usuário.
 * @param usernameValidation Validação do campo nome de usuário.
 * @param phone Número de telefone.
 * @param phoneValidation Validação do campo telefone.
 * @param email Email do usuário.
 * @param emailValidation Validação do campo email.
 * @param password Senha do usuário.
 * @param passwordValidation Validação do campo senha.
 * @param isPasswordVisible Define se a senha está visível no campo.
 * @param isLoading Indica se a operação de registro está em andamento.
 * @param errorMessage Mensagem de erro geral do registro.
 */
data class RegisterState(
    val username: String = "",
    val usernameValidation: ValidationState = ValidationState(),
    val phone: String = "",
    val phoneValidation: ValidationState = ValidationState(),
    val email: String = "",
    val emailValidation: ValidationState = ValidationState(),
    val password: String = "",
    val passwordValidation: ValidationState = ValidationState(),
    val isPasswordVisible: Boolean = false,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)

/**
 * Representa o estado geral da tela de autenticação (login/registro).
 *
 * @param mode Define se a tela atual está em modo [Login] ou [Register].
 * @param eyesOpen Define se os olhos do personagem Ivy estão abertos.
 * @param loginState Estado específico do formulário de login.
 * @param registerState Estado específico do formulário de registro.
 */
data class AuthState(
    val mode: AuthScreenMode = AuthScreenMode.Login,
    val eyesOpen: Boolean = true,
    val loginState: LoginState = LoginState(),
    val registerState: RegisterState = RegisterState()
)
