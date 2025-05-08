/**
 * File: PlantSetupIvyCharacter.kt
 * Description: Componente que exibe o personagem Ivy na seção de configuração.
 * Este componente exibe uma imagem do personagem Ivy para a tela onde o usuário personalizará sua planta digitaç.
 *
 * Responsabilidades:
 * - Renderizar o personagem Ivy.
 * - Permitir personalização do tamanho do personagem através do parâmetro `size`.
 * - Permitir personalização da cor do personagem através do parâmetro `color`. (TO DO)
 *
 * Author: Gabriel Souza Teixeira
 * Created on: 08-05-2025
 * Last modified: 08-05-2025
 * Version: 1.0.0
 * Squad: Metamorfose
 *
 */

package br.com.metamorfose.ui.components.ivy

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.com.metamorfose.R

/**
 * @param modifier Modificador opcional para personalização externa.
 * @param size Tamanho do personagem em dp (padrão: 120f).
 *
 * Exemplo de uso:
 * ```
 * IvyCharacter(
 *     size = 140f
 * )
 * ```
 */
@Composable
fun PlantSetupIvyCharacter(
    modifier: Modifier = Modifier,
    size: Float = 120f
) {
    Box(
        modifier = modifier.size(size.dp),
        contentAlignment = Alignment.Center
    ) {
        val imageRes = R.drawable.ivy_plant_setup

        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "Sua Nova Planta!",
            modifier = Modifier.size(size.dp)
        )
    }
}
