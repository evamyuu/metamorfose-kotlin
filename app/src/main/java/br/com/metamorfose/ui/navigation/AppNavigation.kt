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
 * Modified by: [Seu Nome]
 * Created on: 09-05-2025
 * Last modified: 11-05-2025
 * Version: 3.0.0
 * Squad: Metamorfose
 *
 * Changelog:
 * - [10-05-2025] Adicionado Onboarding. (por Evelin Cordeiro)
 * - [10-05-2025] Substituído MainScreen por VoiceChatScreen. (por ChatGPT)
 * - [11-05-2025] Implementado fluxo completo de navegação incluindo todas as telas de onboarding.
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
import br.com.metamorfose.ui.screens.auth.AuthScreen
import br.com.metamorfose.ui.screens.chat.VoiceChatScreen
import br.com.metamorfose.ui.screens.onboarding.OnboardingButterflyScreen
import br.com.metamorfose.ui.screens.onboarding.OnboardingEggScreen
import br.com.metamorfose.ui.screens.onboarding.OnboardingFinalScreen
import br.com.metamorfose.ui.screens.onboarding.OnboardingPlantScreen
import br.com.metamorfose.ui.screens.onboarding.OnboardingScreen
import br.com.metamorfose.ui.screens.onboarding.OnboardingWelcomeScreen
import br.com.metamorfose.ui.screens.plantsetup.PlantSetupScreen
import br.com.metamorfose.ui.screens.splash.BrandSplashScreen
import br.com.metamorfose.ui.screens.splash.MascotSplashScreen

/**
 * Define os destinos de navegação disponíveis no app.
 */
object Destinations {
    const val BRAND_SPLASH_SCREEN = "brand_splash"
    const val MASCOT_SPLASH_SCREEN = "mascot_splash"
    const val ONBOARDING_SCREEN = "onboarding"
    const val ONBOARDING_WELCOME = "onboarding_welcome"
    const val ONBOARDING_PLANT_SCREEN = "onboarding_plant"
    const val ONBOARDING_EGG_SCREEN = "onboarding_egg"
    const val ONBOARDING_BUTTERFLY_SCREEN = "onboarding_butterfly"
    const val ONBOARDING_FINAL_SCREEN = "onboarding_final"
    const val AUTH_SCREEN = "auth"
    const val PLANT_SETUP_SCREEN = "plant_setup"
    const val VOICE_CHAT_SCREEN = "voice_chat"
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
        // Tela de splash da marca
        composable(Destinations.BRAND_SPLASH_SCREEN) {
            BrandSplashScreen(
                onNavigateToMascotSplash = {
                    navController.navigate(Destinations.MASCOT_SPLASH_SCREEN) {
                        popUpTo(Destinations.BRAND_SPLASH_SCREEN) { inclusive = true }
                    }
                }
            )
        }

        // Tela de splash da mascote
        composable(Destinations.MASCOT_SPLASH_SCREEN) {
            MascotSplashScreen(
                onNavigateToAuth = {
                    navController.navigate(Destinations.ONBOARDING_SCREEN) {
                        popUpTo(Destinations.MASCOT_SPLASH_SCREEN) { inclusive = true }
                    }
                }
            )
        }

        // Primeira tela de onboarding
        composable(Destinations.ONBOARDING_SCREEN) {
            OnboardingScreen(
                onLoginClick = {
                    navController.navigate(Destinations.AUTH_SCREEN)
                },
                onStartClick = {
                    navController.navigate(Destinations.ONBOARDING_WELCOME)
                }
            )
        }

        // Tela de boas-vindas do onboarding
        composable(Destinations.ONBOARDING_WELCOME) {
            OnboardingWelcomeScreen(
                onNavigateNext = {
                    navController.navigate(Destinations.ONBOARDING_PLANT_SCREEN)
                },
                onNavigateBack = {
                    navController.navigateUp()
                }
            )
        }

        // Tela da planta no onboarding
        composable(Destinations.ONBOARDING_PLANT_SCREEN) {
            OnboardingPlantScreen(
                onContinueClick = {
                    navController.navigate(Destinations.ONBOARDING_EGG_SCREEN)
                },
                onBackClick = {
                    navController.navigateUp()
                }
            )
        }

        // Tela da casulo no onboarding
        composable(Destinations.ONBOARDING_EGG_SCREEN) {
            OnboardingEggScreen(
                onContinueClick = {
                    navController.navigate(Destinations.ONBOARDING_BUTTERFLY_SCREEN)
                },
                onBackClick = {
                    navController.navigateUp()
                }
            )
        }

        // Tela da borboleta no onboarding
        composable(Destinations.ONBOARDING_BUTTERFLY_SCREEN) {
            OnboardingButterflyScreen(
                onContinueClick = {
                    navController.navigate(Destinations.ONBOARDING_FINAL_SCREEN)
                },
                onBackClick = {
                    navController.navigateUp()
                }
            )
        }

        // Tela final do onboarding
        composable(Destinations.ONBOARDING_FINAL_SCREEN) {
            OnboardingFinalScreen(
                onClickSim = {
                    navController.navigate(Destinations.AUTH_SCREEN)
                },
                onBackClick = {
                    navController.navigateUp()
                }
            )
        }

        // Tela de autenticação
        composable(Destinations.AUTH_SCREEN) {
            // Impede voltar para o onboarding
            BackHandler {
                navController.navigate(Destinations.ONBOARDING_SCREEN) {
                    popUpTo(Destinations.AUTH_SCREEN) { inclusive = true }
                }
            }

            AuthScreen(
                onNavigateToPlantSetup = {
                    navController.navigate(Destinations.PLANT_SETUP_SCREEN)

                },
                onBackClick = {
                    navController.navigateUp()
                }
            )
        }

        // Tela de configuração da planta
        composable(Destinations.PLANT_SETUP_SCREEN) {
            PlantSetupScreen(
                onNavigateToMain = {
                    navController.navigate(Destinations.VOICE_CHAT_SCREEN) {
                        popUpTo(Destinations.AUTH_SCREEN) { inclusive = true }
                    }
                },
                onNavigateBack = {
                    navController.navigateUp()
                }
            )
        }

        // Tela de chat por voz
        composable(Destinations.VOICE_CHAT_SCREEN) {
            // Impede voltar para o plant setup
            BackHandler {
                activity?.finish()
            }

            VoiceChatScreen(
                characterName = "Usuário",
                plantName = "Ivy",
                onHomeClick = { /* Implementar ação futura se necessário */ },
                onMicrophoneClick = { /* Implementar ação de microfone */ },
                onProfileClick = { /* Implementar ação de perfil */ },
                onExitClick = {
                    activity?.finish()
                }
            )
        }
    }
}