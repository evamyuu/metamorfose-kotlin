/**
 * File: ToggleButtonGroup.kt
 * Description: Componente de grupo de botões de alternância para selecionar entre opções mutuamente exclusivas.
 *
 * Responsabilidades:
 * - Cria um grupo de botões para alternar entre duas opções (ex: "Entrar" e "Cadastrar-se").
 * - Permite selecionar uma opção e altera a aparência do botão selecionado.
 * - Callback chamado para atualizar o índice selecionado.
 *
 * Author: Evelin Cordeiro
 * Created on: 29-04-2025
 * Last modified: 30-04-2025
 * Version: 1.0.0
 * Squad: Metamorfose
 *
 */

package br.com.metamorfose.ui.components.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.metamorfose.ui.theme.GreyLightest2
import br.com.metamorfose.ui.theme.GreyMedium
import br.com.metamorfose.ui.theme.PurpleNormal
import br.com.metamorfose.ui.theme.Typography
import br.com.metamorfose.ui.theme.WhiteLight

/**
 * @param options Lista de rótulos das opções (por exemplo: ["Entrar", "Cadastrar-se"]).
 * @param selectedIndex Índice da opção atualmente selecionada.
 * @param onSelectionChanged Callback chamado ao clicar em uma opção, retorna o novo índice selecionado.
 * @param modifier [Modifier] opcional para customização externa do layout.
 *
 * Exemplo de uso:
 * ```
 * var selectedIndex by remember { mutableStateOf(0) }
 *
 * ToggleButtonGroup(
 *     options = listOf("Entrar", "Cadastrar-se"),
 *     selectedIndex = selectedIndex,
 *     onSelectionChanged = { selectedIndex = it }
 * )
 * ```
 */
@Composable
fun ToggleButtonGroup(
    options: List<String>,
    selectedIndex: Int,
    onSelectionChanged: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .width(334.dp)
            .height(43.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(GreyLightest2)
            .padding(4.dp),
        horizontalArrangement = Arrangement.spacedBy(26.dp)
    ) {
        options.forEachIndexed { index, text ->
            val isSelected = index == selectedIndex

            Box(
                modifier = Modifier
                    .width(154.dp)
                    .height(35.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(
                        if (isSelected) WhiteLight else Color.Transparent
                    )
                    .clickable { onSelectionChanged(index) },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = text,
                    color = if (isSelected) PurpleNormal else GreyMedium,
                    style = Typography.titleSmall.copy(
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                    ),
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ToggleButtonGroupPreview() {
    ToggleButtonGroup(
        options = listOf("Entrar", "Cadastrar-se"),
        selectedIndex = 0,
        onSelectionChanged = { }
    )
}
