/**
 * File: AppNavigation.kt
 * Description: Configuração simplificada da navegação do app Metamorfose.
 *
 * Responsabilidades:
 * - Define as rotas disponíveis no aplicativo
 * - Gerencia a navegação entre as telas
 * - Configura o NavHost para controlar o fluxo de navegação
 *
 * Author: [Seu Nome]
 * Created on: 05-05-2025
 * Last modified: 05-05-2025
 * Version: 1.0.0
 * Squad: Metamorfose
 */
package br.com.metamorfose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.metamorfose.ui.screens.plantsetup.PlantSetupScreen

/**
 * Objeto com as rotas utilizadas na navegação do app
 */
object AppRoutes {
    const val PLANT_SETUP = "plant_setup"
}

/**
 * Componente principal de navegação do app
 * Versão simplificada apenas para teste da PlantSetupScreen
 *
 * @param navController Controlador de navegação
 * @param startDestination Rota inicial (tela de setup da planta)
 */
@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController(),
    startDestination: String = AppRoutes.PLANT_SETUP
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        // Tela de configuração inicial da planta
        composable(route = AppRoutes.PLANT_SETUP) {
            PlantSetupScreen(

            )
        }
    }
}