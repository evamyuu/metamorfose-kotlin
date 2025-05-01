/**
 * File: GradientBackground.kt
 * Description: Componente que cria um fundo de tela com um gradiente personalizado, permitindo a personalização do conteúdo exibido sobre ele.
 * Este componente é ideal para aplicar um fundo gradiente, com a flexibilidade de inserir qualquer tipo de conteúdo sobre ele.
 *
 * Responsabilidades:
 * - Definir um fundo com gradiente, que pode ser facilmente modificado para outros tipos de gradientes.
 * - Permitir que o conteúdo seja exibido sobre o fundo gradiente de forma flexível.
 *
 * Author: Evelin Cordeiro
 * Created on: 30-04-2025
 * Last modified: 30-04-2025
 * Version: 1.0.0
 * Squad: Metamorfose
 *
 */

package br.com.metamorfose.ui.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.metamorfose.ui.theme.LightPurple33Gradient

/**
 * @param brush Gradiente aplicado ao fundo.
 * @param modifier Modificadores para customização externa.
 * @param content Conteúdo que será exibido sobre o fundo.
 */
@Composable
fun GradientBackground(
    brush: Brush = LightPurple33Gradient,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(brush)
    ) {
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun GradientBackgroundPreview() {
    Column {
        GradientBackground(brush = LightPurple33Gradient) {
            Text(text = "Fundo com Gradiente Roxo Claro", modifier = Modifier.padding(16.dp))
        }
    }
}
