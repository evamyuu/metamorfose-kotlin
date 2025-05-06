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
 *
 *  - BRAND_SPLASH_SCREEN: Tela splash com logo do Metamorfose.
 *  - MASCOT_SPLASH_SCREEN: Tela splash com imagem do Ivy.
 *
 *  Author: Vitoria Lana
 *  Created on: 05-05-2025
 *  Last modified: 05-05-2025
 *  version: 1.0.0
 *  Squad: Metamorfose
 */

package br.com.metamorfose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.metamorfose.ui.screens.auth.AuthScreen
import br.com.metamorfose.ui.screens.splash.BrandSplashScreen
import br.com.metamorfose.ui.screens.splash.MascotSplashScreen

/**
 * Destinations object contém as constantes de navegação para as telas do aplicativo.
 * Define os nomes das telas para navegação entre elas.
 */
object Destinations {
    const val BRAND_SPLASH_SCREEN = "brand_splash"  // Tela inicial com logo da marca
    const val MASCOT_SPLASH_SCREEN = "mascot_splash"  // Tela de splash com o Ivy
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
        navController = navController,
        startDestination = Destinations.BRAND_SPLASH_SCREEN  // Inicia com a tela de splash da marca
    ) {
        // Define o comportamento da tela de splash da marca
        composable(Destinations.BRAND_SPLASH_SCREEN) {
            BrandSplashScreen(
                onNavigateToMascotSplash = {
                    // Navega para a tela de splash da mascote e remove a splash da marca da pilha de navegação
                    navController.navigate(Destinations.MASCOT_SPLASH_SCREEN) {
                        popUpTo(Destinations.BRAND_SPLASH_SCREEN) { inclusive = true }
                    }
                }
            )
        }

        // Define o comportamento da tela de splash da mascote
        composable(Destinations.MASCOT_SPLASH_SCREEN) {
            MascotSplashScreen(
                onNavigateToAuth = {
                    // Navega para a tela de autenticação e remove a splash da mascote da pilha de navegação
                    navController.navigate(Destinations.AUTH_SCREEN) {
                        popUpTo(Destinations.MASCOT_SPLASH_SCREEN) { inclusive = true }
                    }
                }
            )
        }

        // Define o comportamento da tela de autenticação.
        composable(Destinations.AUTH_SCREEN) {
            AuthScreen(
                onNavigateToHome = {
                    // Quando autenticado, navega para a tela principal
                    navController.navigate(Destinations.MAIN_SCREEN) {
                        popUpTo(Destinations.AUTH_SCREEN) { inclusive = true }
                    }
                }
            )
        }
    }
}