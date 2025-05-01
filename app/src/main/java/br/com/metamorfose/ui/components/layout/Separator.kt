/**
 * File: Separator.kt
 * Description: Componente que exibe um divisor com um texto centralizado entre duas linhas. O divisor ocupa toda a largura disponível
 * da tela, com o texto posicionado no meio, oferecendo uma divisão visual clara e atraente entre seções de conteúdo.
 *
 * Responsabilidades:
 * - Exibir um divisor horizontal com um texto no centro.
 * - Permitir a customização das cores do divisor e do texto.
 * - Prover uma interface simples para separar visualmente diferentes blocos de conteúdo.
 *
 * Author: Evelin Cordeiro
 * Created on: 30-04-2025
 * Last modified: 30-04-2025
 * Version: 1.0.0
 * Squad: Metamorfose
 *
 */

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import br.com.metamorfose.ui.theme.GreyLight
import br.com.metamorfose.ui.theme.PurpleDarken
import br.com.metamorfose.ui.theme.PurpleNormal
import br.com.metamorfose.ui.theme.Typography
import br.com.metamorfose.ui.theme.WhiteDark

/**
 * @param text Texto a ser exibido no meio do divisor.
 * @param modifier Modificador opcional para personalizar o estilo do componente.
 * @param dividerColor Cor do divisor. O padrão é a cor E5E5E5.
 * @param textColor Cor do texto. O padrão é o cinza médio.
 */
@Composable
fun Separator(
    text: String,
    modifier: Modifier = Modifier,
    dividerColor: Color = WhiteDark,
    textColor: Color = GreyLight
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            modifier = Modifier
                .weight(1f)
                .height(2.dp),
            color = dividerColor
        )

        Text(
            text = text,
            modifier = Modifier.padding(horizontal = 8.dp),
            style = Typography.titleSmall.copy(fontWeight = FontWeight.Bold),
            color = textColor
        )

        Divider(
            modifier = Modifier
                .weight(1f)
                .height(2.dp),
            color = dividerColor
        )
    }
}

/**
 * Preview do componente Divider.
 *
 * Exibe o componente Divider em uma tela de visualização para testes de UI.
 */
@Preview(showBackground = true)
@Composable
fun SeparatorPreview() {
    Separator(
        text = "Texto no Meio",
        dividerColor = PurpleDarken,
        textColor = PurpleNormal
    )
}
