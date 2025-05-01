/**
 * File: AppNavigation.kt
 * Description: Componente de navegação principal do Metamorfose, que define a estrutura de navegação entre as telas.
 * Utiliza o Jetpack Navigation Compose para gerenciar as navegações entre as telas do app.
 * A navegação inicial começa pela tela de autenticação (AuthScreen).
 *
 * Responsabilidades:
 * - Definir a estrutura de navegação entre as telas utilizando NavHost.
 * - Gerenciar a navegação entre a tela de autenticação e outras telas futuras (por exemplo, MainScreen).
 * - Controlar a navegação utilizando o NavController.
 *
 * Destinations:
 * - AUTH_SCREEN: Tela de autenticação.
 * - MAIN_SCREEN: Tela principal (não implementada no momento).
 *
 * Author: Evelin Cordeiro
 * Created on: 30-04-2025
 * Last modified: 30-04-2025
 * Version: 1.0.0
 * Squad: Metamorfose
 *
 */

package br.com.metamorfose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.metamorfose.ui.screens.auth.AuthScreen

/**
 * Destinations object contém as constantes de navegação para as telas do aplicativo.
 * Define os nomes das telas para navegação entre elas.
 */
object Destinations {
    const val AUTH_SCREEN = "auth"  // Tela de autenticação do usuário.
    const val MAIN_SCREEN = "main"  // Tela principal do aplicativo, ainda não implementada.
}

/**
 * Função que configura o fluxo de navegação entre as telas do aplicativo.
 * A navegação começa pela tela de autenticação (AuthScreen) e pode ser estendida para outras telas.
 *
 * @param navController O controlador de navegação, usado para gerenciar o fluxo de telas.
 *                       Caso não seja fornecido, um NavController padrão é criado.
 *
 * O fluxo de navegação é definido dentro do NavHost, que mapeia destinos e as telas associadas.
 */
@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController()  // Cria o NavController, se necessário.
) {
    // O NavHost define o destino inicial e os destinos possíveis no fluxo de navegação.
    NavHost(
        navController = navController,  // O controlador de navegação.
        startDestination = Destinations.AUTH_SCREEN  // Tela inicial, neste caso, a tela de autenticação.
    ) {
        // Define o comportamento da tela de autenticação.
        composable(Destinations.AUTH_SCREEN) {
            AuthScreen()  // Chama a tela de autenticação.
        }
    }
}
