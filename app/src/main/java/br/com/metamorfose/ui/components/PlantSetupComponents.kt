/**
 * File: PlantSetupComponents.kt
 * Description: Componentes adicionais necessários para a tela de configuração de planta.
 *
 * Responsabilidades:
 * - Define componentes reutilizáveis específicos para a tela de setup de planta
 * - Implementa o mascote da planta como um componente separado
 * - Encapsula dropdowns para seleção de plantas e cores de vaso
 *
 * Author: [Seu Nome]
 * Created on: 05-05-2025
 * Last modified: 05-05-2025
 * Version: 1.0.0
 * Squad: Metamorfose
 *
 */

package br.com.metamorfose.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.metamorfose.ui.theme.*

/**
 * Componente para exibir o mascote da planta
 * 
 * @param modifier Modificador opcional para customização adicional
 */
@Composable
fun PlantMascot(
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxWidth()
    ) {
        // Corpo roxo do mascote
        Box(
            modifier = Modifier
                .size(160.dp)
                .clip(CircleShape)
                .background(PurpleNormal)
        ) {
            // Rosto do mascote
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFFFC0CB))
                    .align(Alignment.Center)
            ) {
                // Olhos do mascote
                Row(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(top = 8.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(24.dp)
                            .clip(CircleShape)
                            .background(BlackDark)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Box(
                        modifier = Modifier
                            .size(24.dp)
                            .clip(CircleShape)
                            .background(BlackDark)
                    )
                }
                
                // Boca do mascote
                Box(
                    modifier = Modifier
                        .padding(top = 48.dp)
                        .size(width = 40.dp, height = 12.dp)
                        .clip(CircleShape)
                        .background(PurpleDarken)
                        .align(Alignment.Center)
                )
            }
        }
        
        // Broto no topo
        Box(
            modifier = Modifier
                .offset(y = (-70).dp)
                .align(Alignment.TopCenter)
        ) {
            // Tronco
            Box(
                modifier = Modifier
                    .width(8.dp)
                    .height(20.dp)
                    .background(GreenDarken)
                    .align(Alignment.TopCenter)
            )
            
            // Folhas
            Row(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .offset(y = (-10).dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .clip(RoundedCornerShape(topStart = 12.dp, bottomEnd = 12.dp))
                        .background(GreenLight)
                        .rotate(-15f)
                )
                Spacer(modifier = Modifier.width((-12).dp))
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .clip(RoundedCornerShape(topEnd = 12.dp, bottomStart = 12.dp))
                        .background(GreenLight)
                        .rotate(15f)
                )
            }
        }
    }
}

/**
 * Campo de seleção de planta com ícone personalizado
 * 
 * @param value Valor atual da seleção
 * @param onValueChange Função chamada quando o valor é alterado
 * @param modifier Modificador opcional para customização adicional 
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlantSelectionField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        readOnly = true,
        placeholder = { 
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(android.R.drawable.ic_menu_add),
                    contentDescription = null,
                    tint = PurpleNormal,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    "Selecione a sua planta", 
                    style = Typography.bodyMedium,
                    color = GreyMedium
                )
            }
        },
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = "Selecionar planta",
                tint = PurpleNormal
            )
        },
        modifier = modifier.fillMaxWidth(),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = PurpleNormal,
            unfocusedBorderColor = GreyLight
        ),
        shape = Shape.small,
        singleLine = true,
        textStyle = Typography.bodyMedium
    )
}

/**
 * Campo de seleção de cor do vaso com indicador visual de cor
 * 
 * @param value Valor atual da seleção
 * @param onValueChange Função chamada quando o valor é alterado
 * @param selectedColor Cor atualmente selecionada (círculo de cor)
 * @param modifier Modificador opcional para customização adicional 
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PotColorSelectionField(
    value: String,
    onValueChange: (String) -> Unit,
    selectedColor: Color = PurpleNormal,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        readOnly = true,
        placeholder = { 
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(16.dp)
                        .clip(CircleShape)
                        .background(selectedColor)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    "Cor do vaso", 
                    style = Typography.bodyMedium,
                    color = GreyMedium
                )
            }
        },
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = "Selecionar cor",
                tint = PurpleNormal
            )
        },
        modifier = modifier.fillMaxWidth(),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = PurpleNormal,
            unfocusedBorderColor = GreyLight
        ),
        shape = Shape.small,
        singleLine = true,
        textStyle = Typography.bodyMedium
    )
}

@Preview(showBackground = true)
@Composable
fun PlantMascotPreview() {
    MetamorfoseTheme {
        PlantMascot()
    }
}

@Preview(showBackground = true)
@Composable
fun PlantSelectionFieldPreview() {
    MetamorfoseTheme {
        PlantSelectionField(
            value = "",
            onValueChange = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PotColorSelectionFieldPreview() {
    MetamorfoseTheme {
        PotColorSelectionField(
            value = "",
            onValueChange = {}
        )
    }
}
