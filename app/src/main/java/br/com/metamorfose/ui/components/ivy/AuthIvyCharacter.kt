/**
 * File: IvyCharacter.kt
 * Description: Componente que exibe o personagem Ivy com olhos abertos ou fechados, permitindo animações ou reações visuais baseadas no estado dos olhos.
 * Este componente exibe uma imagem do personagem Ivy e altera a imagem dependendo do estado dos olhos (abertos ou fechados).
 *
 * Responsabilidades:
 * - Renderizar o personagem Ivy com base no estado dos olhos (abertos ou fechados).
 * - Permitir personalização do tamanho do personagem através do parâmetro `size`.
 * - Suporte a animações ou reações visuais durante interações.
 *
 * Author: Evelin Cordeiro
 * Created on: 30-04-2025
 * Last modified: 30-04-2025
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
 * @param eyesOpen Define se os olhos da Ivy estão abertos (`true`) ou fechados (`false`).
 * @param modifier Modificador opcional para personalização externa.
 * @param size Tamanho do personagem em dp (padrão: 120f).
 *
 * Exemplo de uso:
 * ```
 * var isEyesOpen by remember { mutableStateOf(true) }
 *
 * IvyCharacter(
 *     eyesOpen = isEyesOpen,
 *     size = 140f
 * )
 * ```
 */
@Composable
fun IvyCharacter(
    eyesOpen: Boolean,
    modifier: Modifier = Modifier,
    size: Float = 120f
) {
    Box(
        modifier = modifier.size(size.dp),
        contentAlignment = Alignment.Center
    ) {
        val imageRes = if (eyesOpen) {
            R.drawable.ivy_eyes_open
        } else {
            R.drawable.ivy_eyes_closed
        }

        Image(
            painter = painterResource(id = imageRes),
            contentDescription = if (eyesOpen) "Ivy com olhos abertos" else "Ivy com olhos fechados",
            modifier = Modifier.size(size.dp)
        )
    }
}
