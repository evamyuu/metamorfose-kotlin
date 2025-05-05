package br.com.metamorfose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.metamorfose.ui.screens.auth.AuthScreen
import br.com.metamorfose.ui.screens.splash.SplashScreen

/**
 * Destinations object contém as constantes de navegação para as telas do aplicativo.
 * Define os nomes das telas para navegação entre elas.
 */
object Destinations {
    const val SPLASH_SCREEN = "splash"  // Nova constante para a tela de splash
    const val AUTH_SCREEN = "auth"  // Tela de autenticação do usuário.
    const val MAIN_SCREEN = "main"  // Tela principal do aplicativo, ainda não implementada.
}

/**
 * Função que configura o fluxo de navegação entre as telas do aplicativo.
 * A navegação começa pela tela de splash e depois segue para a autenticação.
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
        startDestination = Destinations.SPLASH_SCREEN  // Mudamos para iniciar na tela de splash
    ) {
        // Define o comportamento da tela de splash
        composable(Destinations.SPLASH_SCREEN) {
            SplashScreen(
                onNavigateToAuth = {
                    // Navega para a tela de autenticação e remove a splash da pilha de navegação
                    navController.navigate(Destinations.AUTH_SCREEN) {
                        popUpTo(Destinations.SPLASH_SCREEN) { inclusive = true }
                    }
                }
            )
        }

        // Define o comportamento da tela de autenticação.
        composable(Destinations.AUTH_SCREEN) {
            AuthScreen()  // Chama a tela de autenticação.
        }


    }
}