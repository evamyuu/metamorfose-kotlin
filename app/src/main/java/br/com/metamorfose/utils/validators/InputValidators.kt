/**
 * File: InputValidators.kt
 * Description: Contém funções de validação para diferentes tipos de entrada no aplicativo Metamorfose.
 *              Estas funções garantem que os dados inseridos pelos usuários (como email, nome de usuário, telefone e senha)
 *              atendam a determinados critérios de formato e obrigatoriedade.
 *
 * Responsabilidades:
 * - Validar um endereço de e-mail, nome de usuário, número de telefone e senha.
 * - Garantir que os campos de entrada atendam aos requisitos de formato e tamanho.
 * - Retornar mensagens de erro quando a validação falha, ou null se os dados forem válidos.
 *
 * Funções principais:
 * - [validateEmail]: Valida se o e-mail fornecido é válido.
 * - [validateUsername]: Valida se o nome de usuário está no formato correto e tem comprimento mínimo.
 * - [validatePhone]: Valida se o número de telefone possui um formato correto e comprimento adequado.
 * - [validatePassword]: Valida se a senha atende aos requisitos de complexidade (letras maiúsculas, minúsculas, números).
 * - [validateNotEmpty]: Valida se um campo não está vazio, sendo obrigatório.
 *
 * Author: Evelin Cordeiro
 * Created on: 28-04-2025
 * Last modified: 30-04-2025
 * Version: 1.0.0
 * Squad: Metamorfose
 *
 */

package br.com.metamorfose.utils.validators

object InputValidators {

    /**
     * Valida um endereço de e-mail
     * @param email Email a ser validado
     * @return Mensagem de erro ou null se for válido
     */
    fun validateEmail(email: String): String? {
        return when {
            email.isEmpty() -> "O e-mail é obrigatório"
            !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() -> "E-mail inválido"
            else -> null
        }
    }

    /**
     * Valida um nome de usuário
     * @param username Nome de usuário a ser validado
     * @return Mensagem de erro ou null se for válido
     */
    fun validateUsername(username: String): String? {
        return when {
            username.isEmpty() -> "O nome de usuário é obrigatório"
            username.length < 3 -> "Nome de usuário deve ter pelo menos 3 caracteres"
            !username.matches(Regex("^[a-zA-Z0-9._-]+$")) -> "Nome de usuário deve conter apenas letras, números, . _ -"
            else -> null
        }
    }

    /**
     * Valida um número de telefone
     * @param phone Número de telefone a ser validado
     * @return Mensagem de erro ou null se for válido
     */
    fun validatePhone(phone: String): String? {
        return when {
            phone.isEmpty() -> "O telefone é obrigatório"
            !phone.matches(Regex("^[0-9() -]+$")) -> "Telefone inválido"
            phone.replace(Regex("[^0-9]"), "").length < 10 -> "Telefone deve ter pelo menos 10 dígitos"
            else -> null
        }
    }

    /**
     * Valida uma senha
     * @param password Senha a ser validada
     * @return Mensagem de erro ou null se for válida
     */
    fun validatePassword(password: String): String? {
        return when {
            password.isEmpty() -> "A senha é obrigatória"
            password.length < 6 -> "A senha deve ter pelo menos 6 caracteres"
            !password.matches(Regex(".*[A-Z].*")) -> "A senha deve ter pelo menos uma letra maiúscula"
            !password.matches(Regex(".*[a-z].*")) -> "A senha deve ter pelo menos uma letra minúscula"
            !password.matches(Regex(".*[0-9].*")) -> "A senha deve ter pelo menos um número"
            else -> null
        }
    }

    /**
     * Valida um campo genérico (não vazio)
     * @param value Valor a ser validado
     * @param fieldName Nome do campo para mensagem de erro
     * @return Mensagem de erro ou null se for válido
     */
    fun validateNotEmpty(value: String, fieldName: String): String? {
        return if (value.isEmpty()) "$fieldName é obrigatório" else null
    }
}