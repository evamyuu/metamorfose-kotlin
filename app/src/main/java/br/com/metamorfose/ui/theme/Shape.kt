/**
 * File: Shape.kt
 * Description: Definições de formas (shapes) utilizadas no tema do app Metamorfose. Contém configurações de bordas arredondadas para diferentes componentes da interface.
 *
 * Responsabilidades:
 * - Define os tamanhos das bordas arredondadas para os componentes de UI do app, como botões e cards.
 * - Facilita a manutenção da consistência visual e identidade do design do app.
 *
 * Author: Evelin Cordeiro
 * Created on: 28-04-2025
 * Last modified: 30-04-2025
 * Version: 1.0.0
 * Squad: Metamorfose
 *
 */

package br.com.metamorfose.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

val Shape = Shapes(
    small = RoundedCornerShape(12.dp),
    medium = RoundedCornerShape(16.dp),
    large = RoundedCornerShape(24.dp)
)
