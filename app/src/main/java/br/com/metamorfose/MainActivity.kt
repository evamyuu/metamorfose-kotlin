/**
 * File: MainActivity.kt
 * Description: Atividade principal do aplicativo Metamorfose que configura a navegação e o tema.
 *
 * Responsabilidades:
 * - Ponto de entrada do aplicativo
 * - Configura o tema do aplicativo
 * - Inicializa o sistema de navegação
 *
 * Author: [Autor Original]
 * Modified by: [Seu Nome]
 * Created on: 28-04-2025
 * Last modified: 08-05-2025
 * Version: 2.0.0
 * Squad: Metamorfose
 */

package br.com.metamorfose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import br.com.metamorfose.ui.navigation.AppNavigation
import br.com.metamorfose.ui.theme.MetamorfoseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // Aplica o tema normal assim que possível, substituindo o tema de inicialização
        setTheme(R.style.Theme_Metamorfoseapp)

        super.onCreate(savedInstanceState)
        setContent {
            MetamorfoseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Inicializa o sistema de navegação com o fluxo completo:
                    // BrandSplash -> MascotSplash -> Auth -> PlantSetup -> Main
                    AppNavigation()
                }
            }
        }
    }
}