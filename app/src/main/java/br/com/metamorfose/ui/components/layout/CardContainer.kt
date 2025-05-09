/**
 * File: CardContainer.kt
 * Description: Componente que cria um contêiner personalizável em forma de cartão arredondado, com suporte a rolagem vertical do conteúdo interno.
 * Este componente é ideal para exibir conteúdos em forma de cartão, como formulários, telas de cadastro ou detalhes de um item.
 *
 * Responsabilidades:
 * - Criar um cartão com cantos arredondados e rolagem vertical para o conteúdo interno.
 * - Permitir personalização de cor de fundo, formato e padding do card.
 * - Suporte a empilhamento de elementos com a utilização de `ColumnScope`.
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
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.metamorfose.ui.theme.BlackNormal
import br.com.metamorfose.ui.theme.Typography
import br.com.metamorfose.ui.theme.WhiteLight

/**
 * @param modifier Modificador para personalizar a aparência e o comportamento do card.
 * @param shape Formato do card, padrão com cantos superiores arredondados de 50dp.
 * @param color Cor de fundo do card, padrão é [WhiteLight].
 * @param contentPadding Espaçamento interno do conteúdo, padrão com 24dp nas laterais e 30dp no topo.
 * @param content Conteúdo a ser exibido dentro do card. Usa uma [ColumnScope] para permitir empilhamento vertical.
 *
 * Exemplo de uso:
 * ```
 * CardContainer {
 *     Text(text = "Título")
 *     Text(text = "Descrição do conteúdo")
 * }
 * ```
 */
@Composable
fun CardContainer(
    modifier: Modifier = Modifier,
    shape: RoundedCornerShape = RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp),
    color: Color = WhiteLight,
    contentPadding: PaddingValues = PaddingValues(start = 24.dp, top = 30.dp, end = 24.dp),
    content: @Composable ColumnScope.() -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(color = color, shape = shape)
            .clip(shape)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(25.dp),
            content = content
        )
    }
}

/**
 * Preview do CardContainer exibindo exemplo de conteúdo.
 */
@Preview(showBackground = true)
@Composable
fun CardContainerPreview() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = BlackNormal)
            .padding(16.dp)
    ) {
        CardContainer {
            Text(
                text = "Título",
                style = Typography.titleLarge
            )
            Text(
                text = "Este é um exemplo de conteúdo dentro do CardContainer.",
                style = Typography.bodyMedium
            )
        }
    }
}
