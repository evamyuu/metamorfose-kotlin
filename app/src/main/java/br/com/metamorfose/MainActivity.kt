package br.com.metamorfose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import br.com.metamorfose.ui.navigation.AppNavigation
import br.com.metamorfose.ui.theme.MetamorfoseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // Aplica o tema normal assim que possível, substituindo o tema de inicialização
        setTheme(R.style.Theme_Metamorfoseapp)

        super.onCreate(savedInstanceState)
        setContent {
            MetamorfoseTheme {
                AppNavigation()
            }
        }
    }
}