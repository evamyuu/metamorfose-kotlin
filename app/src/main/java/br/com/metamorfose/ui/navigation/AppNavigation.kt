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
 * Author: Vitoria Lana
 * Created on: 09-05-2025
 * Last modified: 10-05-2025
 * Version: 2.0.0
 * Squad: Metamorfose
 *
 *  * Changelog:
 *  * - [10-05-2025] Adicionado Onboarding. (por Evelin Cordeiro)
 *
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
import br.com.metamorfose.ui.screens.onboarding.OnboardingFinalScreen
import br.com.metamorfose.ui.screens.plantsetup.PlantSetupScreen
import br.com.metamorfose.ui.screens.splash.BrandSplashScreen
import br.com.metamorfose.ui.screens.splash.MascotSplashScreen

/**
 * Define os destinos de navegação disponíveis no app.
 */
object Destinations {
    const val BRAND_SPLASH_SCREEN = "brand_splash"
    const val MASCOT_SPLASH_SCREEN = "mascot_splash"
    const val ONBOARDING_FINAL_SCREEN = "onboarding_final"
    const val AUTH_SCREEN = "auth"
    const val PLANT_SETUP_SCREEN = "plant_setup"
    const val MAIN_SCREEN = "main"
}

/**
 * Componente de navegação que define o fluxo de telas do aplicativo.
 *
 * @param navController Controlador responsável por gerenciar a navegação entre as telas.
 */
@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController()
) {
    val activity = LocalContext.current as? Activity

    NavHost(
        navController = navController,
        startDestination = Destinations.BRAND_SPLASH_SCREEN
    ) {
        composable(Destinations.BRAND_SPLASH_SCREEN) {
            BrandSplashScreen(
                onNavigateToMascotSplash = {
                    navController.navigate(Destinations.MASCOT_SPLASH_SCREEN) {
                        popUpTo(Destinations.BRAND_SPLASH_SCREEN) { inclusive = true }
                    }
                }
            )
        }

        composable(Destinations.MASCOT_SPLASH_SCREEN) {
            MascotSplashScreen(
                onNavigateToAuth = {
                    navController.navigate(Destinations.AUTH_SCREEN) {
                        popUpTo(Destinations.MASCOT_SPLASH_SCREEN) { inclusive = true }
                    }
                }
            )
        }

        composable(Destinations.ONBOARDING_FINAL_SCREEN) {
            OnboardingFinalScreen(
                onClickSim = {
                    navController.navigate(Destinations.PLANT_SETUP_SCREEN)
                },
                onBackClick = {
                    navController.navigateUp()
                }
            )
        }

        composable(Destinations.AUTH_SCREEN) {
            BackHandler {
                activity?.finish()
            }

            AuthScreen(
                onNavigateToPlantSetup = {
                    navController.navigate(Destinations.PLANT_SETUP_SCREEN)
                }
            )
        }

        composable(Destinations.PLANT_SETUP_SCREEN) {
            PlantSetupScreen(
                onNavigateToMain = {
                    navController.navigate(Destinations.MAIN_SCREEN) {
                        popUpTo(Destinations.AUTH_SCREEN) { inclusive = true }
                    }
                },
                onNavigateBack = {
                    navController.navigate(Destinations.ONBOARDING_FINAL_SCREEN)
                }
            )
        }

        composable(Destinations.MAIN_SCREEN) {
            BackHandler {
                activity?.finish()
            }

            MainScreen(
                peronaName = "Ivy",
                userName = "Usuário",
                onExitApp = {
                    activity?.finish()
                }
            )
        }
    }
}
