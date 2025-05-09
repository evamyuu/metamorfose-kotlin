/**
 * File: AppNavigation.kt
 * Description: Componente de navegação principal do Metamorfose, que define a estrutura de navegação entre as telas.
 * Utiliza o Jetpack Navigation Compose para gerenciar as navegações entre as telas do app.
 *
 * Responsabilidades:
 * - Definir a estrutura de navegação entre as telas utilizando NavHost.
 * - Gerenciar a navegação entre todas as telas do aplicativo.
 * - Controlar a navegação utilizando o NavController.
 *
 * Author: Evelin Cordeiro
 * Modified by: [Seu Nome]
 * Created on: 30-04-2025
 * Last modified: 08-05-2025
 * Version: 2.0.0
 * Squad: Metamorfose
 */

package br.com.metamorfose.ui.navigation

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.metamorfose.ui.MainScreen
import br.com.metamorfose.ui.screens.auth.AuthScreen
import br.com.metamorfose.ui.screens.plantsetup.PlantSetupScreen
import br.com.metamorfose.ui.screens.splash.BrandSplashScreen
import br.com.metamorfose.ui.screens.splash.MascotSplashScreen

/**
 * Destinations object contém as constantes de navegação para as telas do aplicativo.
 */
object Destinations {
    const val BRAND_SPLASH_SCREEN = "brand_splash"  // Tela inicial com logo da marca
    const val MASCOT_SPLASH_SCREEN = "mascot_splash"  // Tela de splash com o Ivy
    const val AUTH_SCREEN = "auth"  // Tela de autenticação do usuário
    const val PLANT_SETUP_SCREEN = "plant_setup"  // Tela de configuração da planta
    const val MAIN_SCREEN = "main"  // Tela principal do aplicativo
}

/**
 * Função que configura o fluxo de navegação entre as telas do aplicativo.
 * O fluxo segue: BrandSplashScreen -> MascotSplashScreen -> AuthScreen -> PlantSetupScreen -> MainScreen
 *
 * @param navController O controlador de navegação, usado para gerenciar o fluxo de telas.
 */
@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController()
) {
    val activity = LocalContext.current as? Activity

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

        // Define o comportamento da tela de autenticação
        composable(Destinations.AUTH_SCREEN) {
            // Impede voltar com o botão físico
            BackHandler {
                // Opcionalmente sair do app
                activity?.finish()
            }

            AuthScreen(
                onNavigateToPlantSetup = {
                    // Quando autenticado, navega para a tela de configuração da planta
                    navController.navigate(Destinations.PLANT_SETUP_SCREEN)
                }
            )
        }

        // Define o comportamento da tela de configuração da planta
        composable(Destinations.PLANT_SETUP_SCREEN) {
            PlantSetupScreen(
                onNavigateToMain = {
                    // Quando a configuração da planta for concluída, navega para a tela principal
                    navController.navigate(Destinations.MAIN_SCREEN) {
                        popUpTo(Destinations.AUTH_SCREEN) { inclusive = true }
                    }
                },
                onNavigateBack = {
                    // Volta para a tela de autenticação
                    navController.navigateUp()
                }
            )
        }

        // Define o comportamento da tela principal
        composable(Destinations.MAIN_SCREEN) {
            // Impede voltar para a tela de setup com o botão físico
            BackHandler {
                // Opcionalmente sair do app
                activity?.finish()
            }

            MainScreen(
                peronaName = "Ivy",
                userName = "Usuário",
                onExitApp = {
                    // Sair do aplicativo
                    activity?.finish()
                }
            )
        }
    }
}