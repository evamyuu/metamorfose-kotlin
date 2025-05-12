/**
 * File: MainActivity.kt
 * Description: Atividade principal do aplicativo Metamorfose, responsável por aplicar o tema e iniciar a navegação.
 *
 * Responsabilidades:
 * - Ponto de entrada do aplicativo.
 * - Aplicar o tema personalizado da aplicação.
 * - Inicializar o sistema de navegação via Jetpack Compose.
 *
 * Author: Vitoria Lana
 * Created on: 28-04-2025
 * Last modified: 09-05-2025
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
        setTheme(R.style.Theme_Metamorfoseapp)

        super.onCreate(savedInstanceState)
        setContent {
            MetamorfoseTheme {
                    AppNavigation()
            }
        }
    }
}